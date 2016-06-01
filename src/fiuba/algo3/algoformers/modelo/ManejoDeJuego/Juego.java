package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.Personajes.*;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;

import java.util.LinkedList;
import java.util.List;

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


        this.jugadorUno = new Jugador();
        this.jugadorDos = new Jugador();

        jugadorUno.addNombre(nombreJugadorUno);
        jugadorDos.addNombre(nombreJugadorDos);

        this.turno = new Turno();
        this.turno.agregarJugador1(jugadorUno);
        this.turno.agregarJugador2(jugadorDos);

        this.tablero = new Tablero(filas, columnas);

        this.comenzarNuevoJuego();

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

        this.jugadorUno.agregarAlgoformers(autobots);
        this.jugadorUno.setBando(BandoAutobots.instancia());


        List<AlgoFormer> decepticons = new LinkedList<>();
        decepticons.add(megatron);
        decepticons.add(bonecrusher);
        decepticons.add(frenzy);

        this.jugadorDos.agregarAlgoformers(autobots);
        this.jugadorDos.setBando(BandoDecepticons.instancia());


        tablero.setPersonaje(optimus,0, 0);
        tablero.setPersonaje(bumblebee,0, 1);
        tablero.setPersonaje(rathcet,1, 2 );
        tablero.setPersonaje(megatron,this.filas-1, this.columnas-1 );
        tablero.setPersonaje(bonecrusher,this.filas-1 , this.columnas-2);
        tablero.setPersonaje(frenzy,this.filas-2,this.columnas-1);

    }

    public Jugador getJugador1() {
        return this.jugadorUno;
    }

    public Jugador getJugador2() {
        return this.jugadorDos;
    }

    public Tablero getTablero (){
        return this.tablero;
    }



}
