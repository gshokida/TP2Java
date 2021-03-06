package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Errores.NoPuedeTransformarseEnHumanoideException;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by german.shokida on 6/6/2016.
 */
public class TierraRocosaTest {
    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreOptimus(){
        AlgoFormer optimus = new Optimus();
        TierraRocosa tierraRocosa = new TierraRocosa();

        try {
            tierraRocosa.interactuar(optimus);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(500, optimus.getPuntosDeVida(), 0D);
        assertEquals(50, optimus.getAtaque(), 0D);
        assertEquals(2, optimus.getDistanciaDeAtaque());
        assertEquals(2, optimus.getVelocidad());
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreOptimusTransformado(){
        AlgoFormer optimus = new Optimus();
        TierraRocosa tierraRocosa = new TierraRocosa();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        Transformacion transformacion = new Transformacion(casillero, optimus);


        try {
            transformacion.aplicarTransformacion();
            tierraRocosa.interactuar(optimus);
        } catch (NoPuedeInteractuarConSuperficieException | NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(500, optimus.getPuntosDeVida(), 0D);
        assertEquals(15, optimus.getAtaque(), 0D);
        assertEquals(4, optimus.getDistanciaDeAtaque());
        assertEquals(5, optimus.getVelocidad());
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreBumblebee(){
        AlgoFormer bumblebee = new Bumblebee();
        TierraRocosa tierraRocosa = new TierraRocosa();

        try {
            tierraRocosa.interactuar(bumblebee);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(350, bumblebee.getPuntosDeVida(), 0D);
        assertEquals(40, bumblebee.getAtaque(), 0D);
        assertEquals(1, bumblebee.getDistanciaDeAtaque());
        assertEquals(2, bumblebee.getVelocidad());
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreBumblebeeTransformado() {
        AlgoFormer bumblebee = new Bumblebee();
        TierraRocosa tierraRocosa = new TierraRocosa();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        Transformacion transformacion = new Transformacion(casillero, bumblebee);


        try {
            transformacion.aplicarTransformacion();
            tierraRocosa.interactuar(bumblebee);
        } catch (NoPuedeInteractuarConSuperficieException | NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(350, bumblebee.getPuntosDeVida(), 0D);
        assertEquals(20, bumblebee.getAtaque(), 0D);
        assertEquals(3, bumblebee.getDistanciaDeAtaque());
        assertEquals(5, bumblebee.getVelocidad());
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreRatchet(){
        AlgoFormer ratchet = new Ratchet();
        TierraRocosa tierraRocosa = new TierraRocosa();

        try {
            tierraRocosa.interactuar(ratchet);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(150, ratchet.getPuntosDeVida(), 0D);
        assertEquals(5, ratchet.getAtaque(), 0D);
        assertEquals(5, ratchet.getDistanciaDeAtaque());
        assertEquals(1, ratchet.getVelocidad());
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreRatchetTransformado_NoPuedeInteractuarConUnidadAerea(){
        AlgoFormer ratchet = new Ratchet();
        TierraRocosa tierraRocosa = new TierraRocosa();

        Casillero casillero = new Casillero(new Posicion(0, 0));
        Transformacion transformacion = new Transformacion(casillero, ratchet);


        try {
            transformacion.aplicarTransformacion();
            tierraRocosa.interactuar(ratchet);
            fail();
        }catch (NoPuedeInteractuarConSuperficieException ex){
            success();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreMegatron(){
        AlgoFormer megatron = new Megatron();
        TierraRocosa tierraRocosa = new TierraRocosa();

        try {
            tierraRocosa.interactuar(megatron);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(550, megatron.getPuntosDeVida(), 0D);
        assertEquals(10, megatron.getAtaque(), 0D);
        assertEquals(3, megatron.getDistanciaDeAtaque());
        assertEquals(1, megatron.getVelocidad());
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreMegatronTransformado_NoPuedeInteractuarConUnidadAerea(){
        AlgoFormer megatron = new Megatron();
        TierraRocosa tierraRocosa = new TierraRocosa();

        Casillero casillero = new Casillero(new Posicion(0, 0));
        Transformacion transformacion = new Transformacion(casillero, megatron);


        try {
            transformacion.aplicarTransformacion();
            tierraRocosa.interactuar(megatron);
            fail();
        }catch (NoPuedeInteractuarConSuperficieException ex){
            success();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreBonecrusher(){
        AlgoFormer bonecrusher = new Bonecrusher();
        TierraRocosa tierraRocosa = new TierraRocosa();

        try {
            tierraRocosa.interactuar(bonecrusher);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(200, bonecrusher.getPuntosDeVida(), 0D);
        assertEquals(30, bonecrusher.getAtaque(), 0D);
        assertEquals(3, bonecrusher.getDistanciaDeAtaque());
        assertEquals(1, bonecrusher.getVelocidad());
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreBonecrusherTransformado() {
        AlgoFormer bonecrusher = new Bonecrusher();
        TierraRocosa tierraRocosa = new TierraRocosa();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        Transformacion transformacion = new Transformacion(casillero, bonecrusher);


        try {
            transformacion.aplicarTransformacion();
            tierraRocosa.interactuar(bonecrusher);
        } catch (NoPuedeInteractuarConSuperficieException | NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(200, bonecrusher.getPuntosDeVida(), 0D);
        assertEquals(30, bonecrusher.getAtaque(), 0D);
        assertEquals(3, bonecrusher.getDistanciaDeAtaque());
        assertEquals(8, bonecrusher.getVelocidad());
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreFrenzy(){
        AlgoFormer frenzy = new Frenzy();
        TierraRocosa tierraRocosa = new TierraRocosa();

        try {
            tierraRocosa.interactuar(frenzy);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(400, frenzy.getPuntosDeVida(), 0D);
        assertEquals(10, frenzy.getAtaque(), 0D);
        assertEquals(5, frenzy.getDistanciaDeAtaque());
        assertEquals(2, frenzy.getVelocidad());
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreFrenzyTransformado() {
        AlgoFormer frenzy = new Frenzy();
        TierraRocosa tierraRocosa = new TierraRocosa();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        Transformacion transformacion = new Transformacion(casillero, frenzy);


        try {
            transformacion.aplicarTransformacion();
            tierraRocosa.interactuar(frenzy);
        } catch (NoPuedeInteractuarConSuperficieException | NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(400, frenzy.getPuntosDeVida(), 0D);
        assertEquals(25, frenzy.getAtaque(), 0D);
        assertEquals(2, frenzy.getDistanciaDeAtaque());
        assertEquals(6, frenzy.getVelocidad());
    }

    private void success() {
        assertTrue(true);
    }
}
