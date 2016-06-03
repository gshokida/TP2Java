package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bonecrusher;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by german.shokida on 24/5/2016.
 */
public class MegatronTest {
    @Test
    public void nuevaInstancia_nombre_valeMegatronPrime() {
        Megatron megatron = new Megatron();

        assertEquals(megatron.getNombre(), "Megatron");
    }

    @Test
    public void nuevaInstancia_distanciaDeAtaque_valeTres() {
        Megatron megatron = new Megatron();

        assertEquals(megatron.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void nuevaInstancia_velocidad_valeUno() {
        Megatron megatron = new Megatron();

        assertEquals(megatron.getVelocidad(), 1);
    }

    @Test
    public void nuevaInstancia_puntosDeVida_valeQuinientosCincuenta() {
        Megatron megatron = new Megatron();

        assertEquals(megatron.getPuntosDeVida(), 550);
    }

    @Test
    public void nuevaInstancia_ataque_valeDiez() {
        Megatron megatron = new Megatron();

        assertEquals(megatron.getAtaque(), 10);
    }

    @Test
    public void cambiarModo_unaVez_dejaVidaEnQuinientosCincuenta() {
        Megatron megatron = new Megatron();

        megatron.transformar();

        assertEquals(megatron.getPuntosDeVida(), 550);
    }

    @Test
    public void cambiarModo_unaVez_cambiaAtaqueACincuentaYCinco() {
        Megatron megatron = new Megatron();

        megatron.transformar();

        assertEquals(megatron.getAtaque(), 55);
    }

    @Test
    public void cambiarModo_unaVez_cambiaDistanciaDeAtaqueADos() {
        Megatron megatron = new Megatron();

        megatron.transformar();

        assertEquals(megatron.getDistanciaDeAtaque(), 2);
    }

    @Test
    public void cambiarModo_unaVez_cambiaVelocidadAOcho() {
        Megatron megatron = new Megatron();

        megatron.transformar();

        assertEquals(megatron.getVelocidad(), 8);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaDistanciaDeAtaqueATres() {
        Megatron megatron = new Megatron();

        megatron.transformar();
        megatron.transformar();

        assertEquals(megatron.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaAtaqueADiez() {
        Megatron megatron = new Megatron();

        megatron.transformar();
        megatron.transformar();

        assertEquals(megatron.getAtaque(), 10);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaVelocidadAUno() {
        Megatron megatron = new Megatron();

        megatron.transformar();
        megatron.transformar();

        assertEquals(megatron.getVelocidad(), 1);
    }

    @Test
    public void cambiarModo_TresVeces_cambiaVelocidadAOcho() {
        Megatron megatron = new Megatron();

        megatron.transformar();
        megatron.transformar();
        megatron.transformar();

        assertEquals(megatron.getVelocidad(), 8);
    }

    @Test
    public void nuevaInstancia_tipoUnidad_esTerrestre() {
        Megatron megatron = new Megatron();

        assertTrue(megatron.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void cambiarModo_tipoUnidad_esAerea() {
        Megatron megatron = new Megatron();

        megatron.transformar();

        assertTrue(megatron.esTipoUnidad(TipoUnidadAerea.instancia()));
    }

    @Test
    public void atacar_restaVidaDeEnemigo_elValorDeAtaque() {
        Megatron megatron = new Megatron();
        Optimus optimus = new Optimus();
        int vidaInicialOptimus = optimus.getPuntosDeVida();

        Posicion posicionOptimus = new Posicion(1, 1);
        Posicion posicionMegatron = new Posicion(2, 2);

        optimus.setPosicion(posicionOptimus);
        megatron.setPosicion(posicionMegatron);

        try {
            megatron.atacar(optimus);
        } catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        } catch (DistanciaExcedidaException e) {
            fail();
        }

        assertEquals(optimus.getPuntosDeVida(), vidaInicialOptimus - megatron.getAtaque());
    }

    @Test
    public void atacar_cuandoLaUnidadEsUnAliado_daError () {
        Megatron megatron = new Megatron();
        Bonecrusher bonecrusher = new Bonecrusher();

        try {
            megatron.atacar(bonecrusher);
            fail();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            success();
        } catch (DistanciaExcedidaException e) {
            fail();
        }
    }

    private void success() {
        assertTrue(true);
    }
}
