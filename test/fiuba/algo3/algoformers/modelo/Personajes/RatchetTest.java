package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaEntreAlgoFormersExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bumblebee;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Ratchet;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RatchetTest {
    @Test
    public void nuevaInstancia_nombre_valeBumblebee() {
        Ratchet algoFormer = new Ratchet();

        assertEquals(algoFormer.getNombre(), "Ratchet");
    }

    @Test
    public void nuevaInstancia_distanciaDeAtaque_valeCinco() {
        Ratchet algoFormer = new Ratchet();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 5);
    }

    @Test
    public void nuevaInstancia_velocidad_valeUno() {
        Ratchet algoFormer = new Ratchet();

        assertEquals(algoFormer.getVelocidad(), 1);
    }

    @Test
    public void nuevaInstancia_puntosDeVida_valeCientoCincuenta() {
        Ratchet algoFormer = new Ratchet();

        assertEquals(algoFormer.getPuntosDeVida(), 150);
    }

    @Test
    public void nuevaInstancia_ataque_valeCinco() {
        Ratchet algoFormer = new Ratchet();

        assertEquals(algoFormer.getAtaque(), 5);
    }

    @Test
    public void cambiarModo_unaVez_dejaVidaEnTrescientosCincuenta() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();

        assertEquals(algoFormer.getPuntosDeVida(), 150);
    }

    @Test
    public void cambiarModo_unaVez_cambiaAtaqueATreintaYCinco() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();

        assertEquals(algoFormer.getAtaque(), 35);
    }

    @Test
    public void cambiarModo_unaVez_cambiaDistanciaDeAtaqueADos() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 2);
    }

    @Test
    public void cambiarModo_unaVez_cambiaVelocidadAOcho() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();

        assertEquals(algoFormer.getVelocidad(), 8);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaDistanciaDeAtaqueACinco() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 5);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaAtaqueACinco() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getAtaque(), 5);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaVelocidadAUno() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getVelocidad(), 1);
    }

    @Test
    public void cambiarModo_TresVeces_cambiaVelocidadAOcho() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();
        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getVelocidad(), 8);
    }

    @Test
    public void nuevaInstancia_tipoUnidad_esTerrestre() {
        Ratchet algoFormer = new Ratchet();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void cambiarModo_tipoUnidad_esAerea() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadAerea.instancia()));
    }

    @Test
    public void atacar_restaVidaDeEnemigo_elValorDeAtaque() {
        Ratchet ratchet = new Ratchet();
        Megatron megatron = new Megatron();
        int vidaInicialMegatron = megatron.getPuntosDeVida();

        Posicion posicionRatchet = new Posicion(1, 1);
        Posicion posicionMegatron = new Posicion(2, 2);

        ratchet.setPosicion(posicionRatchet);
        megatron.setPosicion(posicionMegatron);

        try {
            ratchet.atacar(megatron);
        } catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        } catch (DistanciaEntreAlgoFormersExcedidaException e) {
            fail();
        }

        assertEquals(megatron.getPuntosDeVida(), vidaInicialMegatron - ratchet.getAtaque());
    }

    @Test
    public void atacar_cuandoLaUnidadEsUnAliado_daError () {
        Ratchet ratchet = new Ratchet();
        Bumblebee bumblebee = new Bumblebee();

        try {
            ratchet.atacar(bumblebee);
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