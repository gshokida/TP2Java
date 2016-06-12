package fiuba.algo3.algoformers.modelo.Escenario.Contenidos;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by German on 12/06/2016.
 */
public class FlashTest {
    @Test
    public void aplicarFlashAAlgoformerTriplicaSuVelocidad(){
        Flash efectoFlash = new Flash();
        AlgoFormer optimus = new Optimus();
        int velocidadConBonus = 2 * 3;

        efectoFlash.interactuar(optimus);

        assertEquals(velocidadConBonus, optimus.calcularVelocidad());
    }
}
