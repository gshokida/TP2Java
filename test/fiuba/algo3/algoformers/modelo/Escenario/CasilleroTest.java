package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Escenario.Superficies.Nube;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.TierraRocosa;
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
