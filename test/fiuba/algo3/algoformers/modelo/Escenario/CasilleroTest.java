package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Errores.HumanoideNoPuedeAtravesarPantanoException;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.Contenido;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ChispaSuprema;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.Nube;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class CasilleroTest {
    @Test
    public void casilleroNuevoEsVacio(){
        Contenido contenido = ContenidoVacio.getInstance();
        Casillero casillero = new Casillero(new Posicion(0,0));

        casillero.setContenido(contenido);

        assertFalse(casillero.estaOcupado());
    }

    @Test
    public void testAgregoAlgoFormerYDejaDeEstarVacio() {
        AlgoFormer optimus = new Optimus();
        Casillero casillero = new Casillero(new Posicion(0,0));

        try {
            casillero.setAlgoformer(optimus);
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(casillero.getAlgoformer(),optimus);
    }

    @Test
    public void testAgregoHoloSparkYDejaDeEstarVacio() {
        Contenido holoSpark = ChispaSuprema.getInstance();
        Casillero casillero = new Casillero(new Posicion(0,0));

        casillero.setContenido(holoSpark);

        assertTrue(casillero.estaOcupado());
    }

    @Test
    public void casilleroNuevoConSuperficieDeTierra(){
        SuperficieTerrestre tierraRocosa = new TierraRocosa();
        Casillero casillero = new Casillero(new Posicion(0,0));

        casillero.setSuperficieTerreste(tierraRocosa);

        assertEquals(casillero.getSuperficieTerreste(), tierraRocosa);
    }

    @Test
    public void casilleroNuevoConSuperficieAerea(){
        SuperficieAerea nube = new Nube();
        Casillero casillero = new Casillero(new Posicion(0,0));

        casillero.setSuperficieAerea(nube);

        assertEquals(casillero.getSuperficieAerea(), nube);
    }
}
