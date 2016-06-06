package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Personajes.Modos.Modo;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.ModoHumanoide;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidad;

/**
 * Created by Hennico on 23/5/2016.
 */
public class AlgoformerEstado {
    private int ataque;
    private int distanciaDeAtaque;
    private int velocidad;
    private TipoUnidad tipoUnidad;
    private Modo modo;

    public AlgoformerEstado(int ataque, int distanciaDeAtaque, int velocidad, TipoUnidad tipoUnidad, Modo modo) {
        this.ataque = ataque;
        this.distanciaDeAtaque = distanciaDeAtaque;
        this.velocidad = velocidad;
        this.tipoUnidad = tipoUnidad;
        this.modo = modo;
    }

    public int getAtaque() {
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

    public boolean esModo(Modo modo) {
        return this.modo.esModo(modo);
    }

    public void disminuirAtaque(double disminucionAtaque) {
        this.ataque -= disminucionAtaque;
    }
}
