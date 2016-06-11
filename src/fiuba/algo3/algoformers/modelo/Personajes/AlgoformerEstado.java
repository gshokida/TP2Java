package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidad;

/**
 * Created by Hennico on 23/5/2016.
 */
public class AlgoformerEstado {
    private double ataque;
    private int distanciaDeAtaque;
    private int velocidad;
    private TipoUnidad tipoUnidad;

    public AlgoformerEstado(double ataque, int distanciaDeAtaque, int velocidad, TipoUnidad tipoUnidad) {
        this.ataque = ataque;
        this.distanciaDeAtaque = distanciaDeAtaque;
        this.velocidad = velocidad;
        this.tipoUnidad = tipoUnidad;
    }

    public double getAtaque() {
        return ataque;
    }

    public int getDistanciaDeAtaque() {
        return distanciaDeAtaque;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public boolean esTipoUnidad(TipoUnidad tipoUnidad) {
        return this.tipoUnidad.esTipoUnidad(tipoUnidad);
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public void disminuirVelocidad(int velocidadSacada) {
        this.velocidad -= velocidadSacada;
    }

    public void aumentarVelocidad(int velocidadSacada) {
        this.velocidad += velocidadSacada;
    }
}
