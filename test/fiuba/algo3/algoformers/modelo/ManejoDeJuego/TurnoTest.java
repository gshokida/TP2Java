package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class TurnoTest {
    @Test
    public void testnuevoTurno_GuardoElJugador(){
        Jugador jugador = new Jugador();
        jugador.addNombre("pepe");

        Turno turno = new Turno(jugador);

        assertEquals(jugador, turno.getJugador());
    }
}
