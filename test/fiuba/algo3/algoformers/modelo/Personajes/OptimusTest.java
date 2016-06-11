package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadHumanoide;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadVehiculo;
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
    public void nuevaInstancia_distanciaDeAtaque_valeDos() {
        Optimus optimus = new Optimus();

        assertEquals(optimus.getDistanciaDeAtaque(), 2);
    }

    @Test
    public void nuevaInstancia_velocidad_valeDos() {
        Optimus optimus = new Optimus();

        assertEquals(optimus.getVelocidad(), 2);
    }

    @Test
    public void nuevaInstancia_puntosDeVida_valeQuinientos() {
        Optimus optimus = new Optimus();

        assertEquals(optimus.getPuntosDeVida(), 500, 0D);
    }

    @Test
    public void nuevaInstancia_ataque_valeCincuenta() {
        Optimus optimus = new Optimus();

        assertEquals(optimus.getAtaque(), 50, 0D);
    }

    @Test
    public void cambiarModo_unaVez_dejaVidaEnQuinientos() {
        Optimus optimus = new Optimus();

        optimus.transformar();

        assertEquals(optimus.getPuntosDeVida(), 500, 0D);
    }

    @Test
    public void cambiarModo_unaVez_cambiaAtaqueAQuince() {
        Optimus optimus = new Optimus();

        optimus.transformar();

        assertEquals(optimus.getAtaque(), 15, 0D);
    }

    @Test
    public void cambiarModo_unaVez_cambiaDistanciaDeAtaqueACuatro() {
        Optimus optimus = new Optimus();

        optimus.transformar();

        assertEquals(optimus.getDistanciaDeAtaque(), 4);
    }

    @Test
    public void cambiarModo_unaVez_cambiaVelocidadACinco() {
        Optimus optimus = new Optimus();

        optimus.transformar();

        assertEquals(optimus.getVelocidad(), 5);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaDistanciaDeAtaqueADos() {
        Optimus optimus = new Optimus();

        optimus.transformar();
        optimus.transformar();

        assertEquals(optimus.getDistanciaDeAtaque(), 2);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaAtaqueACincuenta() {
        Optimus optimus = new Optimus();

        optimus.transformar();
        optimus.transformar();

        assertEquals(optimus.getAtaque(), 50, 0D);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaVelocidadADos() {
        Optimus optimus = new Optimus();

        optimus.transformar();
        optimus.transformar();

        assertEquals(optimus.getVelocidad(), 2);
    }

    @Test
    public void cambiarModo_TresVeces_cambiaVelocidadACinco() {
        Optimus optimus = new Optimus();

        optimus.transformar();
        optimus.transformar();
        optimus.transformar();

        assertEquals(optimus.getVelocidad(), 5);
    }

    @Test
    public void nuevaInstancia_tipoUnidad_esHumanoide() {
        Optimus optimus = new Optimus();

        assertTrue(optimus.esTipoUnidad(new TipoUnidadHumanoide()));
    }

    @Test
    public void cambiarModo_tipoUnidad_esVehiculo() {
        Optimus optimus = new Optimus();

        optimus.transformar();

        assertTrue(optimus.esTipoUnidad(new TipoUnidadVehiculo()));
    }

    @Test
    public void recibirAtaqueDeBandoEnemigo_restaVida_elValorDeAtaque() {
        Optimus optimus = new Optimus();
        double vidaInicialOptimus = optimus.getPuntosDeVida();
        int puntosDeAtaque = 10;

        optimus.recibirAtaque(puntosDeAtaque);

        assertEquals(optimus.getPuntosDeVida(), vidaInicialOptimus - puntosDeAtaque, 0D);
    }
}