package fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades;

import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hennico on 23/5/2016.
 */
public class TipoUnidadTerrestreTest {
    @Test
    public void esTipoUnidad_siSeEnviaASiMismo_esVerdadero() throws Exception {
        assertTrue(TipoUnidadTerrestre.instancia().esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void esTipoUniad_siSeEnviaTipoDeUnidadDistinto_esFalso() throws Exception {
        assertFalse(TipoUnidadTerrestre.instancia().esTipoUnidad(TipoUnidadAerea.instancia()));
    }
}