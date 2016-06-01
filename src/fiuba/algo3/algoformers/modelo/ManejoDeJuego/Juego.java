package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.Personajes.*;

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


    //ESTO DEBERIA VERSE MAS LINDO, CAPAZ QUE PODEMOS CREAR UNA LISTA Y MANDAR A METODO, AGREGARAUTOBOT y AGREGARDECEPTICONS

    public void situarPersonajes() {

        Optimus optimus = new Optimus();
        Bumblebee bumblebee = new Bumblebee();
        Ratchet rathcet = new Ratchet();


        Megatron megatron = new Megatron();
        Bonecrusher bonecrusher = new Bonecrusher();
        Frenzy frenzy = new Frenzy();

        tablero.setPersonaje(optimus,1, 2);
        tablero.setPersonaje(bumblebee,0, 1);
        tablero.setPersonaje(rathcet,0, 3 );
        tablero.setPersonaje(megatron,2, 3 );
        tablero.setPersonaje(bonecrusher,4, 1);
        tablero.setPersonaje(frenzy,4,3 );

    }
}
