package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bonecrusher;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bumblebee;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Frenzy;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gaston.tulipani on 05/06/2016.
 */
public class TransformacionTest {
    @Test
    public void transformacionUnaVez_bonecrusher_dejaVidaEnDoscientos() {
        AlgoFormer algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getPuntosDeVida(), 200);
    }

    @Test
    public void transformacionUnaVez_bonecrusher_cambiaAtaqueATreinta() {
        AlgoFormer algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getAtaque(), 30);
    }

    @Test
    public void transformacionUnaVez_bonecrusher_cambiaDistanciaDeAtaqueATres() {
        AlgoFormer algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void transformacionUnaVez_bonecrusher_cambiaVelocidadAOcho() {
        AlgoFormer algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getVelocidad(), 8);
    }

    @Test
    public void transformacionDosVeces_bonecrusher_cambiaAtaqueATreinta() {
        AlgoFormer algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();
        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getAtaque(), 30);
    }

    @Test
    public void transformacionDosVeces_bonecrusher_cambiaDistanciaDeAtaqueATres() {
        AlgoFormer algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();
        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void transformacionDosVeces_bonecrusher_cambiaVelocidadAUno() {
        AlgoFormer algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();
        transformacion.aplicarTransformacion();


        assertEquals(algoFormer.getVelocidad(), 1);
    }

    @Test
    public void transformacionUnaVez_bonecrusher_cambiarTipoUnidad_esTerrestre() {
        AlgoFormer algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.getInstance()));
    }

    @Test
    public void transformacionUnaVez_bumblebee_dejaVidaEnTrescientosCincuenta() {
        AlgoFormer algoFormer = new Bumblebee();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getPuntosDeVida(), 350);
    }

    @Test
    public void transformacionUnaVez_bumblebee_cambiaAtaqueAVeinte() {
        AlgoFormer algoFormer = new Bumblebee();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getAtaque(), 20);
    }

    @Test
    public void transformacionUnaVez_bumblebee_cambiaDistanciaDeAtaqueATres() {
        AlgoFormer algoFormer = new Bumblebee();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void transformacionUnaVez_bumblebee_cambiaVelocidadACinco() {
        AlgoFormer algoFormer = new Bumblebee();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getVelocidad(), 5);
    }

    @Test
    public void transformacionDosVeces_bumblebee_cambiaAtaqueACuarenta() {
        AlgoFormer algoFormer = new Bumblebee();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();
        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getAtaque(), 40);
    }

    @Test
    public void transformacionDosVeces_bumblebee_cambiaDistanciaDeAtaqueAUno() {
        AlgoFormer algoFormer = new Bumblebee();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();
        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 1);
    }

    @Test
    public void transformacionDosVeces_bumblebee_cambiaVelocidadADos() {
        AlgoFormer algoFormer = new Bumblebee();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();
        transformacion.aplicarTransformacion();


        assertEquals(algoFormer.getVelocidad(), 2);
    }

    @Test
    public void transformacionUnaVez_bumblebee_cambiarTipoUnidad_esTerrestre() {
        AlgoFormer algoFormer = new Bumblebee();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.getInstance()));
    }

    @Test
    public void transformacionUnaVez_frenzy_dejaVidaEnCuatrocientos() {
        AlgoFormer algoFormer = new Frenzy();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getPuntosDeVida(), 400);
    }

    @Test
    public void transformacionUnaVez_frenzy_cambiaAtaqueAVeinticinco() {
        AlgoFormer algoFormer = new Frenzy();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getAtaque(), 25);
    }

    @Test
    public void transformacionUnaVez_frenzy_cambiaDistanciaDeAtaqueADos() {
        AlgoFormer algoFormer = new Frenzy();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 2);
    }

    @Test
    public void transformacionUnaVez_frenzy_cambiaVelocidadASeis() {
        AlgoFormer algoFormer = new Frenzy();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getVelocidad(), 6);
    }

    @Test
    public void transformacionDosVeces_frenzy_cambiaAtaqueADiez() {
        AlgoFormer algoFormer = new Frenzy();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();
        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getAtaque(), 10);
    }

    @Test
    public void transformacionDosVeces_frenzy_cambiaDistanciaDeAtaqueACinco() {
        AlgoFormer algoFormer = new Frenzy();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();
        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 5);
    }

    @Test
    public void transformacionDosVeces_frenzy_cambiaVelocidadADos() {
        AlgoFormer algoFormer = new Frenzy();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();
        transformacion.aplicarTransformacion();


        assertEquals(algoFormer.getVelocidad(), 2);
    }

    @Test
    public void transformacionUnaVez_frenzy_cambiarTipoUnidad_esTerrestre() {
        AlgoFormer algoFormer = new Frenzy();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.getInstance()));
    }

    @Test
    public void transformacionUnaVez_megatron_dejaVidaEnQuinientosCincuenta() {
        AlgoFormer algoFormer = new Megatron();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getPuntosDeVida(), 550);
    }

    @Test
    public void transformacionUnaVez_megatron_cambiaAtaqueACincuentaYCinco() {
        AlgoFormer algoFormer = new Megatron();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getAtaque(), 55);
    }

    @Test
    public void transformacionUnaVez_megatron_cambiaDistanciaDeAtaqueADos() {
        AlgoFormer algoFormer = new Megatron();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 2);
    }

    @Test
    public void transformacionUnaVez_megatron_cambiaVelocidadAOcho() {
        AlgoFormer algoFormer = new Megatron();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getVelocidad(), 8);
    }

    @Test
    public void transformacionDosVeces_megatron_cambiaAtaqueADiez() {
        AlgoFormer algoFormer = new Megatron();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();
        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getAtaque(), 10);
    }

    @Test
    public void transformacionDosVeces_megatron_cambiaDistanciaDeAtaqueATres() {
        AlgoFormer algoFormer = new Megatron();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();
        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void transformacionDosVeces_megatron_cambiaVelocidadAUno() {
        AlgoFormer algoFormer = new Megatron();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();
        transformacion.aplicarTransformacion();


        assertEquals(algoFormer.getVelocidad(), 1);
    }

    @Test
    public void transformacionUnaVez_megatron_cambiarTipoUnidad_esAerea() {
        AlgoFormer algoFormer = new Megatron();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadAerea.getInstance()));
    }
}
