package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by german.shokida on 2/6/2016.
 */
public class ControlDeTurnosTest {
    @Test
    public void nuevoControlDeTurnos_getNumeroTurno_ComienzaUno(){
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();

        ControlDeTurnos controlDeTurnos = new ControlDeTurnos(jugadorUno, jugadorDos);

        assertEquals(1, controlDeTurnos.getNumeroTurno());
    }

    @Test
    public void avanzaTurno_getNumeroTurno_SumaUnoAlNumeroAnterior(){
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();

        ControlDeTurnos controlDeTurnos = new ControlDeTurnos(jugadorUno, jugadorDos);

        int numeroAnterior = controlDeTurnos.getNumeroTurno();

        controlDeTurnos.avanzarTurno();

        assertEquals(numeroAnterior + 1, controlDeTurnos.getNumeroTurno());
    }

    @Test
    public void avanzaTurno_getTurno_ContieneAlgunoDeLosDosJugadores(){
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();

        ControlDeTurnos controlDeTurnos = new ControlDeTurnos(jugadorUno, jugadorDos);

        Turno turnoActual = controlDeTurnos.getTurno();

        assertTrue(turnoActual.getJugador().equals(jugadorUno) || turnoActual.getJugador().equals(jugadorDos));
    }
}
