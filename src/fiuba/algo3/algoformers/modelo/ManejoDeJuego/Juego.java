package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.Personajes.*;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.*;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import java.util.List;
import java.util.LinkedList;

/**
 * Created by german.shokida on 31/5/2016.
 */
public class Juego {
    private Turno turno;
    private Tablero tablero;
    private Jugador jugadorUno;
    private Jugador jugadorDos;
    private int filas;
    private  int columnas;

    public Juego(String nombreJugadorUno, String nombreJugadorDos, int filas, int columnas) {
        //VERIFICAR
        this.filas = filas;
        this.columnas = columnas;
        jugadorUno = new Jugador();
        jugadorDos = new Jugador();
        jugadorUno.addNombre(nombreJugadorUno);
        jugadorDos.addNombre(nombreJugadorDos);
        turno = new Turno();
        turno.agregarJugador1(jugadorUno);
        turno.agregarJugador2(jugadorDos);
        tablero = new Tablero(filas, columnas);
        comenzarNuevoJuego();
    }


    //ESTO DEBERIA VERSE MAS LINDO, CAPAZ QUE PODEMOS CREAR UNA LISTA Y MANDAR A METODO, AGREGARAUTOBOT y AGREGARDECEPTICONS

  private void comenzarNuevoJuego() {
        Optimus optimus = new Optimus();
        Bumblebee bumblebee = new Bumblebee();
        Ratchet rathcet = new Ratchet();

        Megatron megatron = new Megatron();
        Bonecrusher bonecrusher = new Bonecrusher();
        Frenzy frenzy = new Frenzy();

        List<AlgoFormer> autobots = new LinkedList<>();
        autobots.add(optimus);
        autobots.add(bumblebee);
        autobots.add (rathcet);

        jugadorUno.agregarAlgoformers(autobots);
        jugadorUno.setBando(BandoAutobots.instancia());

        List<AlgoFormer> decepticons = new LinkedList<>();
        decepticons.add(megatron);
        decepticons.add(bonecrusher);
        decepticons.add(frenzy);

        jugadorDos.agregarAlgoformers(autobots);
        jugadorDos.setBando(BandoDecepticons.instancia());

        tablero.setPersonaje(optimus,0, 0);
        tablero.setPersonaje(bumblebee,0, 1);
        tablero.setPersonaje(rathcet,1, 2 );
        tablero.setPersonaje(megatron,filas-1, columnas-1 );
        tablero.setPersonaje(bonecrusher,filas-1 , columnas-2);
        tablero.setPersonaje(frenzy,filas-2,columnas-1);
    }

    public Jugador getJugador1() {
        return jugadorUno;
    }

    public Jugador getJugador2() {
        return jugadorDos;
    }

    public Tablero getTablero (){
        return tablero;
    }
}
