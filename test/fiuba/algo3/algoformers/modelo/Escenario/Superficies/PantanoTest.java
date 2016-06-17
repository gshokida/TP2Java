package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.HumanoideNoPuedeAtravesarPantanoException;
import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Pantano;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by gaston.tulipani on 06/06/2016.
 */
public class PantanoTest {
    @Test
    public void optimusEnModoHumanoide_PuedeIngresarAPantano_noLanzaError() {
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre pantano = new Pantano();

        try {
            pantano.interactuar(algoFormer);
            fail();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            success();
        }
    }

    @Test
    public void bumblebeeEnModoHumanoide_PuedeIngresarAPantano_noLanzaError() {
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieTerrestre pantano = new Pantano();

        try {
            pantano.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            success();
        }
    }

    @Test
    public void ratchetEnModoHumanoide_PuedeIngresarAPantano_noLanzaError() {
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre pantano = new Pantano();

        try {
            pantano.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            success();
        }
    }

    @Test
    public void megatronEnModoHumanoide_PuedeIngresarAPantano_noLanzaError() {
        AlgoFormer algoFormer = new Megatron();
        SuperficieTerrestre pantano = new Pantano();

        try {
            pantano.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            success();
        }
    }

    @Test
    public void bonecrusherEnModoHumanoide_PuedeIngresarAPantano_noLanzaError() {
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre pantano = new Pantano();

        try {
            pantano.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            success();
        }
    }

    @Test
    public void frenzyEnModoHumanoide_PuedeIngresarAPantano_noLanzaError() {
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre pantano = new Pantano();

        try {
            pantano.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            success();
        }
    }

    private void success() {
        assertTrue(true);
    }
}
