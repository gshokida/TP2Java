package fiuba.algo3.algoformers.modelo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class TurnoTest {


    @Test
    public void testGeneric(){

    }


    @Test
    public void testDecideQueJugadorLeToca(){

        Turno turno = new Turno();

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        jugador1.addNombre("Pepe");
        jugador2.addNombre("Penelope");

        turno.agregarJugador1 (jugador1);
        turno.agregarJugador2 (jugador2);

        turno.inicializar();

        Assert.assertTrue(jugador1.puedeJugar());
        Assert.assertFalse(jugador2.puedeJugar());


    }

    @Test
    public void testAvanzarTurnoCambiaElOrdenDeJugador(){

        Turno turno = new Turno();

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        jugador1.addNombre("Pepe");
        jugador2.addNombre("Penelope");

        turno.agregarJugador1 (jugador1);
        turno.agregarJugador2 (jugador2);

        turno.inicializar();
        turno.avanzarTurno();

        Assert.assertTrue(jugador2.puedeJugar());
        Assert.assertFalse(jugador1.puedeJugar());


    }


    @Test
    public void testNoAgregarDosJugadoresLanzaExepcion(){


    }




}
