package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Ratchet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by german.shokida on 6/6/2016.
 */
public class NubeTest {
    @Test
    public void ratchetEnModoAvion_NoEsAfectadoPorNube(){
        AlgoFormer ratchet = new Ratchet();
        SuperficieAerea nube = new Nube();

        Transformacion transformacion = new Transformacion(ratchet);
        transformacion.aplicarTransformacion();

        try {
            nube.interactuar(ratchet);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(150, ratchet.getPuntosDeVida());
        assertEquals(35, ratchet.getAtaque());
        assertEquals(2, ratchet.getDistanciaDeAtaque());
        assertEquals(8, ratchet.getVelocidad());
    }

    @Test
    public void megatronEnModoAvion_NoEsAfectadoPorNube(){
        AlgoFormer megatron = new Megatron();
        SuperficieAerea nube = new Nube();

        Transformacion transformacion = new Transformacion(megatron);
        transformacion.aplicarTransformacion();

        try {
            nube.interactuar(megatron);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(550, megatron.getPuntosDeVida());
        assertEquals(55, megatron.getAtaque());
        assertEquals(2, megatron.getDistanciaDeAtaque());
        assertEquals(8, megatron.getVelocidad());
    }

    @Test
    public void megatronEnModoHumanoide_LaSuperficieNoAfectaAUnidadesTerrestres(){
        AlgoFormer megatron = new Megatron();
        SuperficieAerea nube = new Nube();

        try {
            nube.interactuar(megatron);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    private void success() {
        assertTrue(true);
    }
}
