package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeTransformarseEnHumanoideException;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.*;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAeronave;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadVehiculo;
import org.junit.Test;
import sun.util.resources.cldr.si.CalendarData_si_LK;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by gaston.tulipani on 05/06/2016.
 */
public class TransformacionTest {
    @Test
    public void transformacionUnaVez_bonecrusher_dejaVidaEnDoscientos() {
        AlgoFormer algoFormer = new Bonecrusher();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 200, 0D);
    }

    @Test
    public void transformacionUnaVez_bonecrusher_cambiaAtaqueATreinta() {
        AlgoFormer algoFormer = new Bonecrusher();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getAtaque(), 30, 0D);
    }

    @Test
    public void transformacionUnaVez_bonecrusher_cambiaDistanciaDeAtaqueATres() {
        AlgoFormer algoFormer = new Bonecrusher();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void transformacionUnaVez_bonecrusher_cambiaVelocidadAOcho() {
        AlgoFormer algoFormer = new Bonecrusher();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getVelocidad(), 8);
    }

    @Test
    public void transformacionUnaVez_bonecrusher_cambiarTipoUnidad_esVehiculo() {
        AlgoFormer algoFormer = new Bonecrusher();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertTrue(algoFormer.esTipoUnidad(new TipoUnidadVehiculo()));
    }

    @Test
    public void transformacionDosVeces_bonecrusher_cambiaAtaqueATreinta() {
        AlgoFormer algoFormer = new Bonecrusher();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try{
            transformacion.aplicarTransformacion();
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getAtaque(), 30, 0D);
    }

    @Test
    public void transformacionDosVeces_bonecrusher_cambiaDistanciaDeAtaqueATres() {
        AlgoFormer algoFormer = new Bonecrusher();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);
        try{
            transformacion.aplicarTransformacion();
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void transformacionDosVeces_bonecrusher_cambiaVelocidadAUno() {
        AlgoFormer algoFormer = new Bonecrusher();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            e.printStackTrace();
        }

        assertEquals(algoFormer.getVelocidad(), 1);
    }

    @Test
    public void transformacionUnaVez_bumblebee_dejaVidaEnTrescientosCincuenta() {
        AlgoFormer algoFormer = new Bumblebee();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 350, 0D);
    }

    @Test
    public void transformacionUnaVez_bumblebee_cambiaAtaqueAVeinte() {
        AlgoFormer algoFormer = new Bumblebee();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getAtaque(), 20, 0D);
    }

    @Test
    public void transformacionUnaVez_bumblebee_cambiaDistanciaDeAtaqueATres() {
        AlgoFormer algoFormer = new Bumblebee();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void transformacionUnaVez_bumblebee_cambiaVelocidadACinco() {
        AlgoFormer algoFormer = new Bumblebee();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getVelocidad(), 5);
    }

    @Test
    public void transformacionUnaVez_bumblebee_cambiarTipoUnidad_esVehiculo() {
        AlgoFormer algoFormer = new Bumblebee();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertTrue(algoFormer.esTipoUnidad(new TipoUnidadVehiculo()));
    }

    @Test
    public void transformacionDosVeces_bumblebee_cambiaAtaqueACuarenta() {
        AlgoFormer algoFormer = new Bumblebee();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getAtaque(), 40, 0D);
    }

    @Test
    public void transformacionDosVeces_bumblebee_cambiaDistanciaDeAtaqueAUno() {
        AlgoFormer algoFormer = new Bumblebee();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getDistanciaDeAtaque(), 1);
    }

    @Test
    public void transformacionDosVeces_bumblebee_cambiaVelocidadADos() {
        AlgoFormer algoFormer = new Bumblebee();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }


        assertEquals(algoFormer.getVelocidad(), 2);
    }

    @Test
    public void transformacionUnaVez_frenzy_dejaVidaEnCuatrocientos() {
        AlgoFormer algoFormer = new Frenzy();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 400, 0D);
    }

    @Test
    public void transformacionUnaVez_frenzy_cambiaAtaqueAVeinticinco() {
        AlgoFormer algoFormer = new Frenzy();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getAtaque(), 25, 0D);
    }

    @Test
    public void transformacionUnaVez_frenzy_cambiaDistanciaDeAtaqueADos() {
        AlgoFormer algoFormer = new Frenzy();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getDistanciaDeAtaque(), 2);
    }

    @Test
    public void transformacionUnaVez_frenzy_cambiaVelocidadASeis() {
        AlgoFormer algoFormer = new Frenzy();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getVelocidad(), 6);
    }

    @Test
    public void transformacionUnaVez_frenzy_cambiarTipoUnidad_esVehiculo() {
        AlgoFormer algoFormer = new Frenzy();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertTrue(algoFormer.esTipoUnidad(new TipoUnidadVehiculo()));
    }

    @Test
    public void transformacionDosVeces_frenzy_cambiaAtaqueADiez() {
        AlgoFormer algoFormer = new Frenzy();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getAtaque(), 10, 0D);
    }

    @Test
    public void transformacionDosVeces_frenzy_cambiaDistanciaDeAtaqueACinco() {
        AlgoFormer algoFormer = new Frenzy();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getDistanciaDeAtaque(), 5);
    }

    @Test
    public void transformacionDosVeces_frenzy_cambiaVelocidadADos() {
        AlgoFormer algoFormer = new Frenzy();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getVelocidad(), 2);
    }

    @Test
    public void transformacionUnaVez_megatron_dejaVidaEnQuinientosCincuenta() {
        AlgoFormer algoFormer = new Megatron();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 550, 0D);
    }

    @Test
    public void transformacionUnaVez_megatron_cambiaAtaqueACincuentaYCinco() {
        AlgoFormer algoFormer = new Megatron();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getAtaque(), 55, 0D);
    }

    @Test
    public void transformacionUnaVez_megatron_cambiaDistanciaDeAtaqueADos() {
        AlgoFormer algoFormer = new Megatron();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getDistanciaDeAtaque(), 2);
    }

    @Test
    public void transformacionUnaVez_megatron_cambiaVelocidadAOcho() {
        AlgoFormer algoFormer = new Megatron();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getVelocidad(), 8);
    }

    @Test
    public void transformacionUnaVez_megatron_cambiarTipoUnidad_esAeronave() {
        AlgoFormer algoFormer = new Megatron();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertTrue(algoFormer.esTipoUnidad(new TipoUnidadAeronave()));
    }

    @Test
    public void transformacionDosVeces_megatron_cambiaAtaqueADiez() {
        AlgoFormer algoFormer = new Megatron();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getAtaque(), 10, 0D);
    }

    @Test
    public void transformacionDosVeces_megatron_cambiaDistanciaDeAtaqueATres() {
        AlgoFormer algoFormer = new Megatron();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void transformacionDosVeces_megatron_cambiaVelocidadAUno() {
        AlgoFormer algoFormer = new Megatron();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getVelocidad(), 1);
    }

    @Test
    public void transformacionUnaVez_optimus_dejaVidaEnQuinientos() {
        AlgoFormer algoFormer = new Optimus();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 500, 0D);
    }

    @Test
    public void transformacionUnaVez_optimus_cambiaAtaqueAQuince() {
        AlgoFormer algoFormer = new Optimus();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getAtaque(), 15, 0D);
    }

    @Test
    public void transformacionUnaVez_optimus_cambiaDistanciaDeAtaqueACuatro() {
        AlgoFormer algoFormer = new Optimus();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getDistanciaDeAtaque(), 4);
    }

    @Test
    public void transformacionUnaVez_optimus_cambiaVelocidadACinco() {
        AlgoFormer algoFormer = new Optimus();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getVelocidad(), 5);
    }

    @Test
    public void transformacionUnaVez_optimus_cambiarTipoUnidad_esVehiculo() {
        AlgoFormer algoFormer = new Optimus();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertTrue(algoFormer.esTipoUnidad(new TipoUnidadVehiculo()));
    }

    @Test
    public void transformacionDosVeces_optimus_cambiaAtaqueACincuenta() {
        AlgoFormer algoFormer = new Optimus();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getAtaque(), 50, 0D);
    }

    @Test
    public void transformacionDosVeces_optimus_cambiaDistanciaDeAtaqueADos() {
        AlgoFormer algoFormer = new Optimus();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getDistanciaDeAtaque(), 2);
    }

    @Test
    public void transformacionDosVeces_optimus_cambiaVelocidadADos() {
        AlgoFormer algoFormer = new Optimus();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getVelocidad(), 2);
    }

    @Test
    public void transformacionUnaVez_ratchet_dejaVidaEnCientoCincuenta() {
        AlgoFormer algoFormer = new Ratchet();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 150, 0D);
    }

    @Test
    public void transformacionUnaVez_ratchet_cambiaAtaqueATreintaYCinco() {
        AlgoFormer algoFormer = new Ratchet();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getAtaque(), 35, 0D);
    }

    @Test
    public void transformacionUnaVez_ratchet_cambiaDistanciaDeAtaqueADos() {
        AlgoFormer algoFormer = new Ratchet();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getDistanciaDeAtaque(), 2);
    }

    @Test
    public void transformacionUnaVez_ratchet_cambiaVelocidadAOcho() {
        AlgoFormer algoFormer = new Ratchet();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getVelocidad(), 8);
    }

    @Test
    public void transformacionUnaVez_ratchet_cambiarTipoUnidad_esAeronave() {
        AlgoFormer algoFormer = new Ratchet();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertTrue(algoFormer.esTipoUnidad(new TipoUnidadAeronave()));
    }

    @Test
    public void transformacionDosVeces_ratchet_cambiaAtaqueACinco() {
        AlgoFormer algoFormer = new Ratchet();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getAtaque(), 5, 0D);
    }

    @Test
    public void transformacionDosVeces_ratchet_cambiaDistanciaDeAtaqueACinco() {
        AlgoFormer algoFormer = new Ratchet();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer.getDistanciaDeAtaque(), 5);
    }

    @Test
    public void transformacionDosVeces_ratchet_cambiaVelocidadAUno() {
        AlgoFormer algoFormer = new Ratchet();
        Casillero casillero = new Casillero(new Posicion(0, 0));
        SuperficieTerrestre roca = new TierraRocosa();
        casillero.setSuperficieTerreste(roca);
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();

            transformacion.aplicarTransformacion();
        } catch (NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }


        assertEquals(algoFormer.getVelocidad(), 1);
    }
}
