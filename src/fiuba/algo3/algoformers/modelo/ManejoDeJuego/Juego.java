package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
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
    private ControlDeTurnos controlDeTurnos;
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
        this.controlDeTurnos = new ControlDeTurnos(jugadorUno, jugadorDos);

        tablero = new Tablero(filas, columnas);
        comenzarNuevoJuego();
    }

  private void comenzarNuevoJuego() {
        List<AlgoFormer> autobots = new LinkedList<>();
        List<AlgoFormer> decepticons = new LinkedList<>();
        crearYUbicarAlgoFormers(autobots,decepticons);

        jugadorUno.prepararParaJugar(autobots,BandoAutobots.getInstance());
        jugadorDos.prepararParaJugar(decepticons,BandoDecepticons.getInstance());
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

    private void crearYUbicarAlgoFormers(List<AlgoFormer> autobots, List<AlgoFormer> decepticons) {
        AlgoFormer optimus = new Optimus();
        AlgoFormer bumblebee = new Bumblebee();
        AlgoFormer ratchet = new Ratchet();
        autobots.add(optimus);
        autobots.add(bumblebee);
        autobots.add(ratchet);

        AlgoFormer megatron = new Megatron();
        AlgoFormer bonecrusher = new Bonecrusher();
        AlgoFormer frenzy = new Frenzy();
        decepticons.add(megatron);
        decepticons.add(bonecrusher);
        decepticons.add(frenzy);

        tablero.setPersonaje(optimus, new Posicion(0, 0));
        tablero.setPersonaje(bumblebee,new Posicion(0, 1));
        tablero.setPersonaje(ratchet,new Posicion(1, 2));
        tablero.setPersonaje(megatron, new Posicion(filas-1, columnas-1));
        tablero.setPersonaje(bonecrusher, new Posicion(filas - 1, columnas - 2));
        tablero.setPersonaje(frenzy, new Posicion(filas - 2, columnas - 1));
    }

}
