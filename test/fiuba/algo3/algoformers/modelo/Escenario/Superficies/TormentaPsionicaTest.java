package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.TormentaPsionica;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Ratchet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by gaston.tulipani on 06/06/2016.
 */
public class TormentaPsionicaTest {
    @Test
    public void tormentaPsionicaEnModoAlterno_atraviesaTormentaPsionica_noDisminuyeAtaqueAtaqueDelEstado() {
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea tormentaPsionica = new TormentaPsionica();

        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        double ataqueAlterno = algoFormer.getAtaque();

        try {
            tormentaPsionica.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        assertEquals(ataqueAlterno, algoFormer.getAtaque(), 0D);
    }

    @Test
    public void tormentaPsionicaEnModoAlterno_atraviesaTormentaPsionica_noDisminuyeAtaqueDeModoHumanoide() {
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea tormentaPsionica = new TormentaPsionica();
        double ataqueHumanoide = algoFormer.getAtaque();

        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();

        try {
            tormentaPsionica.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        transformacion.aplicarTransformacion();

        assertEquals(ataqueHumanoide, algoFormer.getAtaque(), 0D);
    }


}