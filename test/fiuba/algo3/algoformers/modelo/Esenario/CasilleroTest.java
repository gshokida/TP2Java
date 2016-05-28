package fiuba.algo3.algoformers.modelo.Esenario;

import fiuba.algo3.algoformers.modelo.Esenario.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class CasilleroTest {
    @Test
    public void casilleroNuevoEsVacio(){
        Contenido contenido = new ContenidoVacio();
        Casillero casillero = new Casillero();

        casillero.setContenido(contenido);
        assertEquals(casillero.getContenido(), contenido);
    }

    @Test
    public void casilleroNuevoConSuperficieDeTierra(){
        SuperficieTerrestre tierraRocosa = new TierraRocosa();
        Casillero casillero = new Casillero();

        casillero.setSuperficieTerreste(tierraRocosa);
        assertEquals(casillero.getSuperficieTerreste(), tierraRocosa);
    }

    @Test
    public void casilleroNuevoConSuperficieAerea(){
        SuperficieAerea nube = new Nube();
        Casillero casillero = new Casillero();

        casillero.setSuperficieAerea(nube);
        assertEquals(casillero.getSuperficieAerea(), nube);
    }
}
