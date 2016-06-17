package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.HumanoideNoPuedeAtravesarPantanoException;
import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Espinas;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by german.shokida on 6/6/2016.
 */
public class EspinasTest {
    @Test
    public void superficieEspinas_BajaCincoPorcientoAOptimus() {
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre espinas = new Espinas();

        try {
            espinas.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(475, algoFormer.getPuntosDeVida(),0D);
    }

    @Test
    public void superficieEspinas_BajaCincoPorcientoABonecrusher() {
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre espinas = new Espinas();

        try {
            espinas.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(190, algoFormer.getPuntosDeVida(), 0D);
    }

    @Test
    public void superficieEspinas_BajaCincoPorcientoAFrenzy() {
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre espinas = new Espinas();

        try {
            espinas.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(380, algoFormer.getPuntosDeVida(), 0D);
    }

    @Test
    public void superficieEspinas_BajaCincoPorcientoARatchet() {
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre espinas = new Espinas();

        try {
            espinas.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(142.5, algoFormer.getPuntosDeVida(), 0D);
    }

    @Test
    public void superficieEspinas_BajaCincoPorcientoAMegatron() {
        AlgoFormer algoFormer = new Megatron();
        SuperficieTerrestre espinas = new Espinas();

        try {
            espinas.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(522.5, algoFormer.getPuntosDeVida(), 0D);
    }

    @Test
    public void superficieEspinas_BajaCincoPorcientoABumblebee() {
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieTerrestre espinas = new Espinas();

        try {
            espinas.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(332.5, algoFormer.getPuntosDeVida(), 0D);
    }
}
