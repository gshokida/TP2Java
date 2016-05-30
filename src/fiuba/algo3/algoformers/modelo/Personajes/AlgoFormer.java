package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoError;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidad;

/**
 * Created by german.shokida on 24/5/2016.
 */
public abstract class AlgoFormer {
    protected String nombre;
    protected int puntosDeVida;
    protected AlgoformerEstado estado;
    protected Bando bando;

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeVida() {
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

    public boolean esTipoUnidad(TipoUnidad tipoUnidad) {
        return estado.esTipoUnidad(tipoUnidad);
    }

    public void atacar(AlgoFormer enemigo) throws NoSePermiteElFuegoAmistosoError {
        if (bando.esMismoBando(enemigo.bando))
            throw new NoSePermiteElFuegoAmistosoError();
        enemigo.puntosDeVida -= estado.getAtaque();
    }
}