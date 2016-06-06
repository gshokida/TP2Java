package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by german.shokida on 6/6/2016.
 */
public class EspinasTest {
    @Test
    public void superficieEspinas_BajaCincoPorcietoAOptimus() {
        AlgoFormer optimus = new Optimus();
        SuperficieTerrestre espinas = new Espinas();

        try {
            espinas.interactuar(optimus);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(475, optimus.getPuntosDeVida());
    }
}
