package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bumblebee;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by german.shokida on 6/6/2016.
 */
public class TierraRocosaTest {
    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreOptimus(){
        AlgoFormer optimus = new Optimus();
        TierraRocosa tierraRocosa = new TierraRocosa();

        tierraRocosa.interactuar(optimus);

        assertEquals(500, optimus.getPuntosDeVida());
        assertEquals(50, optimus.getAtaque());
        assertEquals(2, optimus.getDistanciaDeAtaque());
        assertEquals(2, optimus.getVelocidad());
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreOptimusTransformado(){
        AlgoFormer optimus = new Optimus();
        TierraRocosa tierraRocosa = new TierraRocosa();
        Transformacion transformacion = new Transformacion(optimus);

        transformacion.aplicarTransformacion();

        tierraRocosa.interactuar(optimus);

        assertEquals(500, optimus.getPuntosDeVida());
        assertEquals(15, optimus.getAtaque());
        assertEquals(4, optimus.getDistanciaDeAtaque());
        assertEquals(5, optimus.getVelocidad());
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreBumblebee(){
        AlgoFormer bumblebee = new Bumblebee();
        TierraRocosa tierraRocosa = new TierraRocosa();

        tierraRocosa.interactuar(bumblebee);

        assertEquals(350, bumblebee.getPuntosDeVida());
        assertEquals(40, bumblebee.getAtaque());
        assertEquals(1, bumblebee.getDistanciaDeAtaque());
        assertEquals(2, bumblebee.getVelocidad());
    }

    @Test
    public void superficieRocosaNoAplicaNingunEfectoSobreBumblebeeTransformado(){
        AlgoFormer bumblebee = new Bumblebee();
        TierraRocosa tierraRocosa = new TierraRocosa();
        Transformacion transformacion = new Transformacion(bumblebee);

        transformacion.aplicarTransformacion();

        tierraRocosa.interactuar(bumblebee);

        assertEquals(350, bumblebee.getPuntosDeVida());
        assertEquals(20, bumblebee.getAtaque());
        assertEquals(3, bumblebee.getDistanciaDeAtaque());
        assertEquals(5, bumblebee.getVelocidad());
    }
}
