package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.NebulosaAndromeda;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Ratchet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Familia on 07/06/2016.
 */
public class NebulosaAndromedaTest {
    @Test
    public void superficieNebulosaAndromeda_afectaARatchetTransformado_noLanzaError() {
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea nebulosaAndromeda = new NebulosaAndromeda();

        algoFormer.transformar();

        double puntosDeVida = algoFormer.getPuntosDeVida();
        double ataque = algoFormer.getAtaque();
        int distanciaDeAtaque = algoFormer.getDistanciaDeAtaque();
        int velocidad = 0;

        try {
            nebulosaAndromeda.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(puntosDeVida, algoFormer.getPuntosDeVida(),0D);
        assertEquals(ataque, algoFormer.getAtaque(), 0D);
        assertEquals(distanciaDeAtaque, algoFormer.getDistanciaDeAtaque());
        assertEquals(velocidad, algoFormer.getVelocidad());
    }

    @Test
    public void superficieNebulosaAndromeda_afectaARatchet_LanzaError() {
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea nebulosaAndromeda = new NebulosaAndromeda();

        double puntosDeVida = algoFormer.getPuntosDeVida();
        double ataque = algoFormer.getAtaque();
        int distanciaDeAtaque = algoFormer.getDistanciaDeAtaque();
        int velocidad = algoFormer.getVelocidad();

        try {
            nebulosaAndromeda.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            success();
        }

        assertEquals(puntosDeVida, algoFormer.getPuntosDeVida(),0D);
        assertEquals(ataque, algoFormer.getAtaque(), 0D);
        assertEquals(distanciaDeAtaque, algoFormer.getDistanciaDeAtaque());
        assertEquals(velocidad, algoFormer.getVelocidad());
    }

    private void success() {
        assertTrue(true);
    }
}
