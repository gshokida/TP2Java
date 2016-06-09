package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable.EfectoSuperficieDurable;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.Modo;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidad;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;

import java.util.Iterator;
import java.util.List;

/**
 * Created by german.shokida on 24/5/2016.
 */
public abstract class AlgoFormer {
    protected String nombre;
    protected double puntosDeVida;
    protected Bando bando;
    protected AlgoformerEstado estado;
    protected List<EfectoSuperficieDurable> efectos;
    protected Estado estadoAlgoformer;
    protected boolean fueDebilitado;


    public String getNombre() {
        return nombre;
    }
    public double getPuntosDeVida() {
        return puntosDeVida;
    }


    public int getAtaque() {
        return estado.getAtaque();
    }


    public int getDistanciaDeAtaque() {
        return estado.getDistanciaDeAtaque();
    }
    public int getVelocidad() {
        return estado.getVelocidad();
    }
    public Bando getBando() {
        return bando;
    }

    public boolean esTipoUnidad(TipoUnidad tipoUnidad) {
        return estado.esTipoUnidad(tipoUnidad);
    }
    public boolean esModo(Modo modo) {
        return estado.esModo(modo);
    }

    public void recibirAtaque(int puntosDeAtaque) {
        recibirDanio(puntosDeAtaque);
    }
    public void recibirDanio(double puntosDeAtaque) {
        this.puntosDeVida -= (puntosDeAtaque);
    }

    public abstract void transformar();

    public void agregarEfecto(EfectoSuperficieDurable efecto) {

            this.efectos.add(efecto);
            this.aplicarEfectos(efectos);

    }


    public void frenar(int velocidadSacada) {
        this.estado.disminuirVelocidad(velocidadSacada);
    }

    public void acelerar(int velocidadSacada) {
        this.estado.aumentarVelocidad(velocidadSacada);
    }

    public void debilitar(int ataqueSacado) {
        if (!fueDebilitado) {
            int ataqueActual = this.estado.getAtaque();
            this.estado.setAtaque(ataqueActual - ataqueSacado);
        }
        this.fueDebilitado = true;
    }


    public boolean sePuedeMover() {
        return (estado.getVelocidad() != 0);
    }

    public void pasarTurno() {
        pasarTurno(efectos);
    }

    private void pasarTurno(List<EfectoSuperficieDurable> efectosDeMovimiento) {
        Iterator<EfectoSuperficieDurable> iterador = efectosDeMovimiento.iterator();
        while (iterador.hasNext()) {
            EfectoSuperficieDurable efecto = iterador.next();
            efecto.pasarTurno();
            if (efecto.finalizo())
                eliminarEfecto(efecto);
        }
    }
    private void aplicarEfectos(List<EfectoSuperficieDurable> efectosDeSuperficie) {
        Iterator<EfectoSuperficieDurable> iterador = efectosDeSuperficie.iterator();
        while (iterador.hasNext()) {
            EfectoSuperficieDurable efecto = iterador.next();


            efecto.aplicarEfecto(this);
        }
    }

    private void eliminarEfecto(EfectoSuperficieDurable efecto) {
        efecto.revertirEfecto(this);
        this.efectos.remove(efecto);
    }

    public void setEstado(Estado estado) {

        this.estadoAlgoformer = estado;

    }

    public Estado getEstado (){

        return this.estadoAlgoformer;

    }



}