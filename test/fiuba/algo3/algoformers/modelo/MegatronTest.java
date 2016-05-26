package fiuba.algo3.algoformers.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
