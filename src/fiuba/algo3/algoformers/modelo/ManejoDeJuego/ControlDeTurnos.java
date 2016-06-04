package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import fiuba.algo3.algoformers.modelo.Utils.Cola;

import java.util.Random;

/**
 * Created by german.shokida on 2/6/2016.
 */
public class ControlDeTurnos {
    private int numeroTurno;
    private Cola<Jugador> jugadores;

    public ControlDeTurnos(Jugador jugadorUno, Jugador jugadorDos){
        this.numeroTurno = 0;
        Random randomGenerator = new Random();
        this.jugadores = new Cola<>();

        if(randomGenerator.nextBoolean()) {
            this.jugadores.enqueue(jugadorUno);
            this.jugadores.enqueue(jugadorDos);
        }else{
            this.jugadores.enqueue(jugadorDos);
            this.jugadores.enqueue(jugadorUno);
        }
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public Turno getTurno() {
        Jugador jugador = this.jugadores.dequeue();
        Turno turno = new Turno(jugador);
        this.jugadores.enqueue(jugador);
        this.numeroTurno++;
        return turno;
    }
}
