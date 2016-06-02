package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Contenidos.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Contenidos.HoloSpark;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.Nube;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class CasilleroTest {
    @Test
    public void casilleroNuevoEsVacio(){
        Contenido contenido = ContenidoVacio.getInstance();
        Casillero casillero = new Casillero();

        casillero.setContenido(contenido);

        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void testAgregoAlgoFormerYDejaDeEstarVacio() {
        Contenido optimus = new Optimus();
        Casillero casillero = new Casillero();

        casillero.setContenido(optimus);

        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void testAgregoHoloSparkYDejaDeEstarVacio() {
        Contenido holoSpark = HoloSpark.instancia();
        Casillero casillero = new Casillero();

        casillero.setContenido(holoSpark);

        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void casilleroNuevoConSuperficieDeTierra(){
        SuperficieTerrestre tierraRocosa = TierraRocosa.getInstance();
        Casillero casillero = new Casillero();

        casillero.setSuperficieTerreste(tierraRocosa);

        assertEquals(casillero.getSuperficieTerreste(), tierraRocosa);
    }

    @Test
    public void casilleroNuevoConSuperficieAerea(){
        SuperficieAerea nube = Nube.getInstance();
        Casillero casillero = new Casillero();

        casillero.setSuperficieAerea(nube);

        assertEquals(casillero.getSuperficieAerea(), nube);
    }
}
