package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
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
}
