package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Efecto;
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
    protected List<Efecto> efectosActivos;

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

    public void agregarEfecto(Efecto efecto) {
        if (!this.efectosActivos.contains(efecto))
            this.efectosActivos.add(efecto);
    }
    /*public void frenar(int velocidadSacada) {
        this.estado.disminuirVelocidad(velocidadSacada);
    }*/
    /*public void acelerar(int velocidadSacada) {
        this.estado.aumentarVelocidad(velocidadSacada);
    }*/
    /*public void debilitar(double ataqueSacado) {
        double ataqueActual = this.estado.getAtaque();
        this.estado.setAtaque(ataqueActual - ataqueSacado);
    }*/
    /*public void multiplicarAtaque(int multiplicador) {
        double ataqueActual = this.estado.getAtaque();
        this.estado.setAtaque(ataqueActual * multiplicador);
    }*/
    /*public void dividirAtaque(int divisor) {
        double ataqueActual = this.estado.getAtaque();
        this.estado.setAtaque(ataqueActual / divisor);
    }*/
    public boolean sePuedeMover() {
        this.aplicarEfectos(this.efectosActivos);
        return (this.estado.getVelocidad() != 0);
    }
    public void pasarTurno() {
        for(Efecto efecto : this.efectosActivos) {
            efecto.pasarTurno();
        }
    }
    public double calcularAtaque() {
        this.aplicarEfectos(this.efectosActivos);
        return (this.estado.getAtaque());
    }

    public int calcularVelocidad() {
        this.aplicarEfectos(this.efectosActivos);
        return (this.estado.getVelocidad());
    }

    private void aplicarEfectos(List<Efecto> efectos) {
        Iterator<Efecto> iterador = efectos.iterator();
        while (iterador.hasNext()) {
            Efecto efecto = iterador.next();
            efecto.aplicarEfecto(this);
        }
    }
    /*
    private void eliminarEfecto(Efecto efecto) {
        efecto.revertirEfecto(this);
        this.efectosActivos.remove(efecto);
    }*/


    public void setPuntosDeVida(double puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }
    public void removerEfecto(Efecto efecto) {
        if (efectosActivos.contains(efecto)) {
            revertirEfectos();
            efectosActivos.remove(efecto);
            aplicarEfectos();
        }
    }
    private void aplicarEfectos() {
        for (Efecto efecto : efectosActivos)
            efecto.aplicarEfecto(this);
    }
    private void revertirEfectos() {
        for (Efecto efecto : efectosActivos)
            efecto.revertirEfecto(this);
    }
    public void setAtaque(double ataque) {
        this.estado.setAtaque(ataque);
    }
    public void setVelocidad(int velocidad) {
        this.estado.setVelocidad(velocidad);
    }
}