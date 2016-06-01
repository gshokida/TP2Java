package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Jugador;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class JugadorTest {

    @Test
    public void testGeneric(){

    }


    @Test
    public void testJugadorTieneNombre(){

        Jugador jugador1 = new Jugador();

        jugador1.addNombre ("Pepe");

        Assert.assertTrue (jugador1.seLlama("Pepe"));
    }



    @Test
    public void testJugadorPuedeJugar(){

        Jugador jugador1 = new Jugador();

        jugador1.addNombre("Pepe");

        jugador1.esSuTurno(true);

        Assert.assertTrue(jugador1.puedeJugar());

        jugador1.esSuTurno (false);

        Assert.assertFalse(jugador1.puedeJugar());

    }

    @Test
    public void test_Jugador_Es_Autobot(){

        Jugador jugador1 = new Jugador();

        jugador1.addNombre("Pepe");

        jugador1.setBando(BandoAutobots.instancia());

        Assert.assertTrue(jugador1.getBando().equals(BandoAutobots.instancia()));

    }




}
