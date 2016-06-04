package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by german.shokida on 2/6/2016.
 */
public class ControlDeTurnosTest {
    @Test
    public void nuevoControlDeTurnos_getNumeroTurno_ComienzaEnCero(){
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();

        ControlDeTurnos controlDeTurnos = new ControlDeTurnos(jugadorUno, jugadorDos);

        assertEquals(0, controlDeTurnos.getNumeroTurno());
    }

    @Test
    public void pasarTurno_getNumeroTurno_SumaUnoAlNumeroAnterior(){
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();

        ControlDeTurnos controlDeTurnos = new ControlDeTurnos(jugadorUno, jugadorDos);

        int numeroAnterior = controlDeTurnos.getNumeroTurno();

        controlDeTurnos.pasarTurno();

        assertEquals(numeroAnterior + 1, controlDeTurnos.getNumeroTurno());
    }

    @Test
    public void nuevoTurno_getTurno_ContieneAlgunoDeLosDosJugadores(){
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();

        ControlDeTurnos controlDeTurnos = new ControlDeTurnos(jugadorUno, jugadorDos);

        Turno turnoActual = controlDeTurnos.getTurno();

        assertTrue(turnoActual.getJugador().equals(jugadorUno) || turnoActual.getJugador().equals(jugadorDos));
    }

    @Test
    public void pasarTurno_getTurno_ContieneAlOtroJugador(){
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();
        ControlDeTurnos controlDeTurnos = new ControlDeTurnos(jugadorUno, jugadorDos);

        Turno turno = controlDeTurnos.getTurno();
        Jugador jugadorActivo = turno.getJugador();

        controlDeTurnos.pasarTurno();
        Turno turnoActual = controlDeTurnos.getTurno();

        if(jugadorActivo.equals(jugadorUno)) {
            assertTrue(turnoActual.getJugador().equals(jugadorDos));
        }else{
            assertTrue(turnoActual.getJugador().equals(jugadorUno));
        }
    }

    @Test
    public void avanzaTurnoDosVeces_getTurno_ContieneAlOtroJugador(){
        Jugador jugadorUno = new Jugador();
        Jugador jugadorDos = new Jugador();
        ControlDeTurnos controlDeTurnos = new ControlDeTurnos(jugadorUno, jugadorDos);
        Turno turno = controlDeTurnos.getTurno();
        Jugador jugadorActivo = turno.getJugador();

        controlDeTurnos.pasarTurno();
        controlDeTurnos.pasarTurno();
        Turno turnoActual = controlDeTurnos.getTurno();

        if(jugadorActivo.equals(jugadorUno)) {
            assertTrue(turnoActual.getJugador().equals(jugadorUno));
        }else{
            assertTrue(turnoActual.getJugador().equals(jugadorDos));
        }
    }
}
