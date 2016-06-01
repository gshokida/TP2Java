package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaEntreAlgoFormersExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Contenido;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidad;
import static java.lang.Math.abs;

/**
 * Created by german.shokida on 24/5/2016.
 */
public abstract class AlgoFormer implements Contenido {
    protected String nombre;
    protected int puntosDeVida;
    protected AlgoformerEstado estado;
    protected Bando bando;
    private int posx;
    private int posy;

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

    public int getPosicionX() {
        return posx;
    }

    public int getPosicionY() {
        return posy;
    }

    public void setPosicion(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }

    public void atacar(AlgoFormer enemigo) throws NoSePermiteElFuegoAmistosoException, DistanciaEntreAlgoFormersExcedidaException {
        if (bando.esMismoBando(enemigo.bando))
            throw new NoSePermiteElFuegoAmistosoException();
        if (distanciaInvalida(enemigo))
            throw new DistanciaEntreAlgoFormersExcedidaException();
        enemigo.puntosDeVida -= estado.getAtaque();
    }

    public abstract void transformar();

    public boolean esLaHoloSpark (Contenido contenido){
        return this.equals(contenido);
    }

    private boolean distanciaInvalida(AlgoFormer enemigo) {
        int distanciaX = abs(getPosicionX() - enemigo.getPosicionX());
        int distanciaY = abs(getPosicionY() - enemigo.getPosicionY());
        return((distanciaX > getDistanciaDeAtaque()) && (distanciaY > getDistanciaDeAtaque()));
    }
}