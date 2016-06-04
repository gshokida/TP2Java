package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import fiuba.algo3.algoformers.modelo.Utils.Cola;

import java.util.Random;

/**
 * Created by german.shokida on 2/6/2016.
 */
public class ControlDeTurnos {
    private int numeroTurno;
    private Cola<Jugador> jugadores;
    private Turno turnoActual;

    public ControlDeTurnos(Jugador jugadorUno, Jugador jugadorDos){
        this.numeroTurno = 0;
        this.jugadores = new Cola<Jugador>();
        this.elegirQuienVaPrimero(jugadorUno, jugadorDos);
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public Turno getTurno() {
        return turnoActual;
    }

    public void pasarTurno() {
        this.actualizarTurnoActual();
        this.numeroTurno++;
    }

    private void elegirQuienVaPrimero(Jugador jugadorUno, Jugador jugadorDos) {
        Random randomGenerator = new Random();

        if(randomGenerator.nextBoolean()) {
            this.jugadores.enqueue(jugadorUno);
            this.jugadores.enqueue(jugadorDos);
        }else{
            this.jugadores.enqueue(jugadorDos);
            this.jugadores.enqueue(jugadorUno);
        }

        this.actualizarTurnoActual();
    }

    private void actualizarTurnoActual() {
        Jugador jugador = this.jugadores.dequeue();
        this.jugadores.enqueue(jugador);
        this.turnoActual = new Turno(jugador);
    }
}