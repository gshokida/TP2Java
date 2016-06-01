package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import fiuba.algo3.algoformers.modelo.Escenario.Tablero;

/**
 * Created by german.shokida on 31/5/2016.
 */
public class Juego {
    private Turno turno;
    private Tablero tablero;

    public Juego(String nombreJugadorUno, String nombreJugadorDos, int filas, int columnas) {
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();

        jugadorUno.addNombre(nombreJugadorUno);
        jugadorDos.addNombre(nombreJugadorDos);

        this.turno = new Turno();
        this.turno.agregarJugador1(jugadorUno);
        this.turno.agregarJugador1(jugadorUno);

        this.tablero = new Tablero(filas, columnas);
    }


    public Tablero getTablero (){
        return this.tablero;
    }
}
