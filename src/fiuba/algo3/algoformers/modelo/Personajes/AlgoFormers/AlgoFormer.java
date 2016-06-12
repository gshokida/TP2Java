package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable.EfectoDurable;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidad;

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
    protected List<EfectoDurable> efectos;

    public String getNombre() {
        return nombre;
    }
    public double getPuntosDeVida() {
        return puntosDeVida;
    }
    public double getAtaque() {
        return (this.estado.getAtaque());
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

    public void recibirAtaque(double puntosDeAtaque) {
        recibirDanio(puntosDeAtaque);
    }
    public void recibirDanio(double puntosDeAtaque) {
        this.puntosDeVida -= (puntosDeAtaque);
    }

    public abstract void transformar();

    public void agregarEfecto(EfectoDurable efecto) {
        if (!this.efectos.contains(efecto))
            this.efectos.add(efecto);
    }
    public void frenar(int velocidadSacada) {
        this.estado.disminuirVelocidad(velocidadSacada);
    }
    public void acelerar(int velocidadSacada) {
        this.estado.aumentarVelocidad(velocidadSacada);
    }
    public void debilitar(double ataqueSacado) {
        double ataqueActual = this.estado.getAtaque();
        this.estado.setAtaque(ataqueActual - ataqueSacado);
    }
    public void multiplicarAtaque(int multiplicador) {
        double ataqueActual = this.estado.getAtaque();
        this.estado.setAtaque(ataqueActual * multiplicador);
    }
    public void dividirAtaque(int divisor) {
        double ataqueActual = this.estado.getAtaque();
        this.estado.setAtaque(ataqueActual / divisor);
    }
    public boolean sePuedeMover() {
        this.aplicarEfectos(this.efectos);
        return (this.estado.getVelocidad() != 0);
    }
    public void pasarTurno() {
        pasarTurno(efectos);
    }
    public double calcularAtaque() {
        this.aplicarEfectos(this.efectos);
        return (this.estado.getAtaque());
    }

    private void pasarTurno(List<EfectoDurable> efectos) {
        Iterator<EfectoDurable> iterador = efectos.iterator();
        while (iterador.hasNext()) {
            EfectoDurable efecto = iterador.next();
            efecto.pasarTurno();
            if (efecto.finalizo())
                eliminarEfecto(efecto);
        }
    }
    private void aplicarEfectos(List<EfectoDurable> efectos) {
        Iterator<EfectoDurable> iterador = efectos.iterator();
        while (iterador.hasNext()) {
            EfectoDurable efecto = iterador.next();
            efecto.aplicarEfecto(this);
        }
    }
    private void eliminarEfecto(EfectoDurable efecto) {
        efecto.revertirEfecto(this);
        this.efectos.remove(efecto);
    }
}