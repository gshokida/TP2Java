package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Errores.NoPuedeTransformarseEnHumanoideException;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.TormentaPsionica;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Ratchet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by gaston.tulipani on 06/06/2016.
 */
public class TormentaPsionicaTest {
    @Test
    public void tormentaPsionicaEnModoAlterno_atraviesaTormentaPsionica_DisminuyeAtaqueAtaqueDelEstado() {
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea tormentaPsionica = new TormentaPsionica();

        Casillero casillero = new Casillero(new Posicion(0, 0));
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        double ataqueAlterno = 0;

        try {
            transformacion.aplicarTransformacion();
            ataqueAlterno  = algoFormer.getAtaque() * 60 / 100;
            tormentaPsionica.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException | NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(ataqueAlterno, algoFormer.getAtaque(), 0D);
    }

    @Test
    public void tormentaPsionicaEnModoAlterno_atraviesaTormentaPsionica_noDisminuyeAtaqueDeModoHumanoide() {
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea tormentaPsionica = new TormentaPsionica();
        double ataqueHumanoide = algoFormer.getAtaque();

        Casillero casillero = new Casillero(new Posicion(0, 0));
        Transformacion transformacion = new Transformacion(casillero, algoFormer);

        try {
            transformacion.aplicarTransformacion();
            tormentaPsionica.interactuar(algoFormer);
            transformacion.aplicarTransformacion();
        } catch (NoPuedeInteractuarConSuperficieException | NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }


        assertEquals(ataqueHumanoide, algoFormer.getAtaque(), 0D);
    }
}