package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Contenido;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficie;
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
    protected EfectoSuperficie efectoSuperficieRecibido;

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

    public Bando getBando() {
        return bando;
    }

    public void recibirAtaque(int puntosDeAtaque) {
        recibirDanio(puntosDeAtaque);
    }

    public void recibirDanio(int puntosDeAtaque) {
        this.puntosDeVida -= (puntosDeAtaque);
    }

    public void recibirEfectoSuperficies(EfectoSuperficie efectoSuperficie) {
        this.efectoSuperficieRecibido = efectoSuperficie;
    }

    public abstract void transformar();

    public void ejecutarEfecto() {
        this.efectoSuperficieRecibido.aplicarEfecto(this);
    }
}