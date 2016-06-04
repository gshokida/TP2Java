package fiuba.algo3.algoformers.modelo.Escenario;

import static java.lang.Math.abs;
import static java.lang.Math.max;

/**
 * Created by german.shokida on 2/6/2016.
 */
public class Posicion {

    private int x;
    private int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void actualizarPosicion(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void actualizarPosicion(Posicion posicion){
        this.x = posicion.getX();
        this.y = posicion.getY();
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public int obtenerDistanciaHasta(Posicion otraPosicion) {
        int distanciaX = abs(this.getX() - otraPosicion.getX());
        int distanciaY = abs(this.getY() - otraPosicion.getY());

        return max(distanciaX, distanciaY);
    }
}
