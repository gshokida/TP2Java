package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.Nube;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.*;
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
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea nube = new Nube();

        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();

        try {
            nube.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(150, algoFormer.getPuntosDeVida(), 0D);
        assertEquals(35, algoFormer.getAtaque(), 0D);
        assertEquals(2, algoFormer.getDistanciaDeAtaque());
        assertEquals(8, algoFormer.getVelocidad());
    }

    @Test
    public void ratchetEnModoHumanoide_LaSuperficieNoAfectaAUnidadesTerrestres(){
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea nube = new Nube();

        try {
            nube.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void megatronEnModoAvion_NoEsAfectadoPorNube(){
        AlgoFormer algoFormer = new Megatron();
        SuperficieAerea nube = new Nube();

        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();

        try {
            nube.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(550, algoFormer.getPuntosDeVida(), 0D);
        assertEquals(55, algoFormer.getAtaque(), 0D);
        assertEquals(2, algoFormer.getDistanciaDeAtaque());
        assertEquals(8, algoFormer.getVelocidad());
    }

    @Test
    public void megatronEnModoHumanoide_LaSuperficieNoAfectaAUnidadesTerrestres(){
        AlgoFormer algoFormer = new Megatron();
        SuperficieAerea nube = new Nube();

        try {
            nube.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void optimusEnModoAlterno_LaSuperficieNoAfectaAUnidadesTerrestres(){
        AlgoFormer algoFormer = new Optimus();
        SuperficieAerea nube = new Nube();

        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();

        try {
            nube.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void optimusEnModoHumanoide_LaSuperficieNoAfectaAUnidadesTerrestres(){
        AlgoFormer algoFormer = new Optimus();
        SuperficieAerea nube = new Nube();

        try {
            nube.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void bumblebeeEnModoAlterno_LaSuperficieNoAfectaAUnidadesTerrestres(){
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieAerea nube = new Nube();

        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();

        try {
            nube.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void bumblebeeEnModoHumanoide_LaSuperficieNoAfectaAUnidadesTerrestres(){
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieAerea nube = new Nube();

        try {
            nube.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void bonecrusherEnModoAlterno_LaSuperficieNoAfectaAUnidadesTerrestres(){
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieAerea nube = new Nube();

        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();

        try {
            nube.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void bonecrusherEnModoHumanoide_LaSuperficieNoAfectaAUnidadesTerrestres(){
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieAerea nube = new Nube();

        try {
            nube.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void frenzyEnModoAlterno_LaSuperficieNoAfectaAUnidadesTerrestres(){
        AlgoFormer algoFormer = new Frenzy();
        SuperficieAerea nube = new Nube();

        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();

        try {
            nube.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void frenzyEnModoHumanoide_LaSuperficieNoAfectaAUnidadesTerrestres(){
        AlgoFormer algoFormer = new Frenzy();
        SuperficieAerea nube = new Nube();

        try {
            nube.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    private void success() {
        assertTrue(true);
    }
}
