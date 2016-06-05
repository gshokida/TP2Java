package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bonecrusher;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gaston.tulipani on 05/06/2016.
 */
public class TransformacionTest {
    @Test
    public void transformacionunaVez_bonecrusher_dejaVidaEnDoscientos() {
        Bonecrusher algoFormer = new Bonecrusher();
        Transformacion transformacion = new Transformacion(algoFormer);

        transformacion.aplicarTransformacion();

        assertEquals(algoFormer.getPuntosDeVida(), 200);
    }
}
