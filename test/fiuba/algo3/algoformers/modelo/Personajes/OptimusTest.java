package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaEntreAlgoFormersExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bumblebee;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.*;

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

        assertEquals(optimus.getPuntosDeVida(), 500);
    }

    @Test
    public void nuevaInstancia_ataque_valeCincuenta() {
        Optimus optimus = new Optimus();

        assertEquals(optimus.getAtaque(), 50);
    }

    @Test
    public void cambiarModo_unaVez_dejaVidaEnQuinientos() {
        Optimus optimus = new Optimus();

        optimus.transformar();

        assertEquals(optimus.getPuntosDeVida(), 500);
    }

    @Test
    public void cambiarModo_unaVez_cambiaAtaqueAQuince() {
        Optimus optimus = new Optimus();

        optimus.transformar();

        assertEquals(optimus.getAtaque(), 15);
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

        assertEquals(optimus.getAtaque(), 50);
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
    public void nuevaInstancia_tipoUnidad_esTerrestre() {
        Optimus optimus = new Optimus();

        assertTrue(optimus.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void cambiarModo_tipoUnidad_esTerrestre() {
        Optimus optimus = new Optimus();

        optimus.transformar();

        assertTrue(optimus.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void atacar_restaVidaDeEnemigo_elValorDeAtaque() {
        Optimus optimus = new Optimus();
        Megatron megatron = new Megatron();
        int vidaInicialMegatron = megatron.getPuntosDeVida();

        try {
            optimus.atacar(megatron);
        } catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        } catch (DistanciaEntreAlgoFormersExcedidaException e) {
            fail();
        }

        assertEquals(megatron.getPuntosDeVida(), vidaInicialMegatron - optimus.getAtaque());
    }

    @Test
    public void atacar_cuandoLaUnidadEsUnAliado_daError () {
        Optimus optimus = new Optimus();
        Bumblebee bumblebee = new Bumblebee();

        try {
            optimus.atacar(bumblebee);
            fail();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            success();
        } catch (DistanciaEntreAlgoFormersExcedidaException e) {
            fail();
        }
    }

    private void success() {
        assertTrue(true);
    }
}