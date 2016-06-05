package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bonecrusher;
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
}
