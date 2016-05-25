package fiuba.algo3.tests;

import fiuba.algo3.modelo.Optimus;
import fiuba.algo3.modelo.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptimusTest {

    @Test
    public void nuevaInstancia_nombre_valeOptimusPrime() {
        Optimus optimus = new Optimus();

        assertEquals(optimus.getNombre(), "Optimus Prime");
    }

    @Test
    public void nuevaInstancia_ataque_valeCincuenta() {
        Optimus optimus = new Optimus();

        assertTrue(optimus.getAtaque() == 50f);
    }

    @Test
    public void nuevaInstancia_distanciaDeAtaque_valeDos() {
        Optimus optimus = new Optimus();

        assertTrue(optimus.getDistanciaDeAtaque() == 2);
    }

    @Test
    public void nuevaInstancia_velocidad_valeDos() {
        Optimus optimus = new Optimus();

        assertTrue(optimus.getVelocidad() == 2);
    }

    @Test
    public void nuevaInstancia_puntosDeVida_valeQuinientos() {
        Optimus optimus = new Optimus();

        assertTrue(optimus.getPuntosDeVida() == 500f);
    }

    @Test
    public void cambiarModo_unaVez_dejaVidaEnQuinientos() {
        Optimus optimus = new Optimus();

        optimus.cambiarModo();

        assertTrue(optimus.getPuntosDeVida() == 500f);
    }

    @Test
    public void cambiarModo_unaVez_cambiaAtaqueAQuince() {
        Optimus optimus = new Optimus();

        optimus.cambiarModo();

        assertTrue(optimus.getAtaque() == 15f);
    }

    @Test
    public void cambiarModo_unaVez_cambiaDistanciaDeAtaqueACuatro() {
        Optimus optimus = new Optimus();

        optimus.cambiarModo();

        assertTrue(optimus.getDistanciaDeAtaque() == 4);
    }

    @Test
    public void cambiarModo_unaVez_cambiaVelocidadACinco() {
        Optimus optimus = new Optimus();

        optimus.cambiarModo();

        assertTrue(optimus.getVelocidad() == 5);
    }

    @Test
    public void nuevaInstancia_tipoUnidad_esTerrestre() {
        Optimus optimus = new Optimus();

        assertTrue(optimus.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void cambiarModo_tipoUnidad_esTerrestre() {
        Optimus optimus = new Optimus();

        assertTrue(optimus.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }
}