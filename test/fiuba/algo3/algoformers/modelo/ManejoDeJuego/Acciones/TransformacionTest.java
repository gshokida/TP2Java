package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bonecrusher;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gaston.tulipani on 05/06/2016.
 */
public class TransformacionTest {
    @Test
    public void transformacionunaVez_bonecrusher_dejaVidaEnDoscientos() {
        AlgoFormer algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getPuntosDeVida(), 200);
    }

    @Test
    public void transformacionunaVez_bonecrusher_cambiaAtaqueATreinta() {
        AlgoFormer algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getAtaque(), 30);
    }

    @Test
    public void transformacionunaVez_bonecrusher_cambiaDistanciaDeAtaqueATres() {
        AlgoFormer algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void transformacionunaVez_bonecrusher_cambiaVelocidadAOcho() {
        AlgoFormer algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getVelocidad(), 8);
    }
}
