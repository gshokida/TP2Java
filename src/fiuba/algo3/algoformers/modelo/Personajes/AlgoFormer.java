package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Contenido;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidad;

/**
 * Created by german.shokida on 24/5/2016.
 */
public abstract class AlgoFormer implements Contenido {
    protected String nombre;
    protected int puntosDeVida;
    protected AlgoformerEstado estado;
    protected Bando bando;
    private Posicion posicion;

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

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public void recibirAtaque(int puntosDeAtaque, Bando bandoAtacante) throws NoSePermiteElFuegoAmistosoException {
        if (bando.esMismoBando(bandoAtacante))
            throw new NoSePermiteElFuegoAmistosoException();
        recibirDanio(puntosDeAtaque);
    }

    public void recibirDanio(int puntosDeAtaque) {
        this.puntosDeVida -= (puntosDeAtaque);
    }

    public abstract void transformar();

    public boolean esLaChispaSuprema(Contenido contenido){
        return this.equals(contenido);
    }
}