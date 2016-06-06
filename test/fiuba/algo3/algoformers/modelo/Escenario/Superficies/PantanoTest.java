package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.*;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by gaston.tulipani on 06/06/2016.
 */
public class PantanoTest {
    @Test
    public void optimusEnModoHumanoide_NoPuedeAtravesarPantano_lanzaError() {
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre pantano = new Pantano();

        try {
            pantano.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void bumblebeeEnModoHumanoide_NoPuedeAtravesarPantano_lanzaError() {
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieTerrestre pantano = new Pantano();

        try {
            pantano.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void ratchetEnModoHumanoide_NoPuedeAtravesarPantano_lanzaError() {
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre pantano = new Pantano();

        try {
            pantano.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void megatronEnModoHumanoide_NoPuedeAtravesarPantano_lanzaError() {
        AlgoFormer algoFormer = new Megatron();
        SuperficieTerrestre pantano = new Pantano();

        try {
            pantano.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void bonecrusherEnModoHumanoide_NoPuedeAtravesarPantano_lanzaError() {
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre pantano = new Pantano();

        try {
            pantano.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    @Test
    public void frenzyEnModoHumanoide_NoPuedeAtravesarPantano_lanzaError() {
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre pantano = new Pantano();

        try {
            pantano.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }
    }

    private void success() {
        assertTrue(true);
    }
}
