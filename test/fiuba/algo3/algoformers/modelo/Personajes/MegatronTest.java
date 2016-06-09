package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.ModoAlterno;
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

        assertEquals(megatron.getPuntosDeVida(), 550, 0D);
    }

    @Test
    public void nuevaInstancia_ataque_valeDiez() {
        Megatron megatron = new Megatron();

        assertEquals(megatron.getAtaque(), 10, 0D);
    }

    @Test
    public void cambiarModo_unaVez_dejaVidaEnQuinientosCincuenta() {
        Megatron megatron = new Megatron();

        megatron.transformar();

        assertEquals(megatron.getPuntosDeVida(), 550, 0D);
    }

    @Test
    public void cambiarModo_unaVez_cambiaAtaqueACincuentaYCinco() {
        Megatron megatron = new Megatron();

        megatron.transformar();

        assertEquals(megatron.getAtaque(), 55, 0D);
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

        assertEquals(megatron.getAtaque(), 10, 0D);
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

        assertTrue(megatron.esTipoUnidad(TipoUnidadTerrestre.getInstance()));
    }

    @Test
    public void cambiarModo_tipoUnidad_esAerea() {
        Megatron megatron = new Megatron();

        megatron.transformar();

        assertTrue(megatron.esTipoUnidad(TipoUnidadAerea.getInstance()));
    }

    @Test
    public void cambiarModo_modo_esModoAlterno() {
        Megatron algoFormer = new Megatron();

        algoFormer.transformar();

        assertTrue(algoFormer.esModo(ModoAlterno.getInstance()));
    }

    @Test
    public void recibirAtaqueDeBandoEnemigo_restaVida_elValorDeAtaque() {
        Megatron megatron = new Megatron();
        double vidaInicialMegatron = megatron.getPuntosDeVida();
        int puntosDeAtaque = 10;

        megatron.recibirAtaque(puntosDeAtaque);

        assertEquals(megatron.getPuntosDeVida(), vidaInicialMegatron - puntosDeAtaque, 0D);
    }
}
