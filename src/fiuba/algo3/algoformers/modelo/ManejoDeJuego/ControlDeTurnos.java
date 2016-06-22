package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import fiuba.algo3.algoformers.modelo.Utils.Cola;
import fiuba.algo3.algoformers.view2.Control.ObservadorTurnoInformacion;
import fiuba.algo3.algoformers.view2.Control.ObservadorTurnos;
import fiuba.algo3.algoformers.view2.Control.Observer;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by german.shokida on 2/6/2016.
 */
public class ControlDeTurnos implements SubscriptorManejoTurnos{
    private int numeroTurno;
    private Cola<Jugador> jugadores;
    private Turno turnoActual;
    private Jugador jugadorActual;
    private List<ObservadorTurnos> subscritos;

    public ControlDeTurnos(Jugador jugadorUno, Jugador jugadorDos){
        this.numeroTurno = 0;
        this.jugadores = new Cola<>();
        this.elegirQuienVaPrimero(jugadorUno, jugadorDos);
        subscritos = new LinkedList<>();

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
        notificar();
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
        jugadorActual = jugador;
        this.jugadores.enqueue(jugador);
        this.turnoActual = new Turno(jugador);
    }

    public Jugador getJugadorTurnoActual(){

        return jugadorActual;

    }


    @Override
    public void agregarSubscriptor(ObservadorTurnos observer) {
        subscritos.add(observer);
    }

    @Override
    public void borrarSubscriptor(ObservadorTurnos  observer) {
        this.subscritos.remove(this.subscritos.indexOf(observer));
    }

    @Override
    public void notificar() {

        if (!subscritos.isEmpty()) {
            for (ObservadorTurnos  observados : subscritos) {

                observados.update(jugadorActual.getNombre(),numeroTurno);
                observados.update(jugadorActual);

            }
        }



    }
}