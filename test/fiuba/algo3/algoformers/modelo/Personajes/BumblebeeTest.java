package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoError;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BumblebeeTest {
    @Test
    public void nuevaInstancia_nombre_valeBumblebee() {
        Bumblebee bumblebee = new Bumblebee();

        assertEquals(bumblebee.getNombre(), "Bumblebee");
    }

    @Test
    public void nuevaInstancia_distanciaDeAtaque_valeUno() {
        Bumblebee bumblebee = new Bumblebee();

        assertEquals(bumblebee.getDistanciaDeAtaque(), 1);
    }

    @Test
    public void nuevaInstancia_velocidad_valeDos() {
        Bumblebee bumblebee = new Bumblebee();

        assertEquals(bumblebee.getVelocidad(), 2);
    }

    @Test
    public void nuevaInstancia_puntosDeVida_valeTrescientosCincuenta() {
        Bumblebee bumblebee = new Bumblebee();

        assertEquals(bumblebee.getPuntosDeVida(), 350);
    }

    @Test
    public void nuevaInstancia_ataque_valeCuarenta() {
        Bumblebee bumblebee = new Bumblebee();

        assertEquals(bumblebee.getAtaque(), 40);
    }

    @Test
    public void cambiarModo_unaVez_dejaVidaEnTrescientosCincuenta() {
        Bumblebee bumblebee = new Bumblebee();

        bumblebee.transformar();

        assertEquals(bumblebee.getPuntosDeVida(), 350);
    }

    @Test
    public void cambiarModo_unaVez_cambiaAtaqueAVeinte() {
        Bumblebee bumblebee = new Bumblebee();

        bumblebee.transformar();

        assertEquals(bumblebee.getAtaque(), 20);
    }

    @Test
    public void cambiarModo_unaVez_cambiaDistanciaDeAtaqueATres() {
        Bumblebee bumblebee = new Bumblebee();

        bumblebee.transformar();

        assertEquals(bumblebee.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void cambiarModo_unaVez_cambiaVelocidadACinco() {
        Bumblebee bumblebee = new Bumblebee();

        bumblebee.transformar();

        assertEquals(bumblebee.getVelocidad(), 5);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaDistanciaDeAtaqueAUno() {
        Bumblebee bumblebee = new Bumblebee();

        bumblebee.transformar();
        bumblebee.transformar();

        assertEquals(bumblebee.getDistanciaDeAtaque(), 1);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaAtaqueACuarenta() {
        Bumblebee bumblebee = new Bumblebee();

        bumblebee.transformar();
        bumblebee.transformar();

        assertEquals(bumblebee.getAtaque(), 40);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaVelocidadADos() {
        Bumblebee bumblebee = new Bumblebee();

        bumblebee.transformar();
        bumblebee.transformar();

        assertEquals(bumblebee.getVelocidad(), 2);
    }

    @Test
    public void cambiarModo_TresVeces_cambiaVelocidadACinco() {
        Bumblebee bumblebee = new Bumblebee();

        bumblebee.transformar();
        bumblebee.transformar();
        bumblebee.transformar();

        assertEquals(bumblebee.getVelocidad(), 5);
    }

    @Test
    public void nuevaInstancia_tipoUnidad_esTerrestre() {
        Bumblebee bumblebee = new Bumblebee();

        assertTrue(bumblebee.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void cambiarModo_tipoUnidad_esTerrestre() {
        Bumblebee bumblebee = new Bumblebee();

        bumblebee.transformar();

        assertTrue(bumblebee.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void atacar_restaVidaDeEnemigo_elValorDeAtaque() {
        Bumblebee bumblebee = new Bumblebee();
        Megatron megatron = new Megatron();
        int vidaInicialMegatron = megatron.getPuntosDeVida();

        try {
            bumblebee.atacar(megatron);
        } catch (NoSePermiteElFuegoAmistosoError error) {
            fail();
        }

        assertEquals(megatron.getPuntosDeVida(), vidaInicialMegatron - bumblebee.getAtaque());
    }

    @Test
    public void atacar_cuandoLaUnidadEsUnAliado_daError () {
        Bumblebee bumblebee = new Bumblebee();
        Ratchet ratchet = new Ratchet();

        try {
            bumblebee.atacar(ratchet);
            fail();
        }
        catch (NoSePermiteElFuegoAmistosoError error) {
            success();
        }
    }

    private void success() {
        assertTrue(true);
    }
}