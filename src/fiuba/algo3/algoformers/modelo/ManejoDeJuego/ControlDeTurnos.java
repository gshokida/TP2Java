package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import java.util.Random;

/**
 * Created by german.shokida on 2/6/2016.
 */
public class ControlDeTurnos {
    private int numeroTurno;
    private Jugador jugadorActivo;
    private Jugador jugadorEnEspera;

    public ControlDeTurnos(Jugador jugadorUno, Jugador jugadorDos){
        this.numeroTurno = 1;
        Random randomGenerator = new Random();

        if(randomGenerator.nextBoolean()) {
            this.jugadorActivo = jugadorUno;
            this.jugadorEnEspera = jugadorDos;
        }else{
            this.jugadorActivo = jugadorDos;
            this.jugadorEnEspera = jugadorUno;
        }
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }


    public void avanzarTurno() {
        this.numeroTurno++;
        Jugador jugadorAuxiliar = this.jugadorActivo;
        this.jugadorActivo = this.jugadorEnEspera;
        this.jugadorEnEspera = jugadorAuxiliar;
    }

    public Turno getTurno() {
        Turno turno = new Turno(this.jugadorActivo);

        return turno;
    }
}
