package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class Jugador {

    String nombre;
    boolean turno;


    public void addNombre(String nombre) {

        this.nombre = nombre;
    }

    public boolean seLlama(String nombre) {

       return this.nombre == nombre;
    }


    public void esSuTurno(boolean b) {


        this.turno = b;

    }

    public boolean puedeJugar() {

        return  this.turno;

    }
}
