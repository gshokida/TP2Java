package fiuba.algo3.tests;

import fiuba.algo3.modelo.TipoUnidad;
import fiuba.algo3.modelo.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TipoUnidadTerrestreTest {
    @Test
    public void esTipoUnidad_siSeEnviaASiMismo_esVerdadero() throws Exception {
        assertTrue(TipoUnidadTerrestre.instancia().esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void esTipoUniad_siSeEnviaTipoDeUnidadDistinto_esFalso() throws Exception {
        assertFalse(TipoUnidadTerrestre.instancia().esTipoUnidad(new TipoUnidadTest()));
    }

    private class TipoUnidadTest implements TipoUnidad {
        public boolean esTipoUnidad(TipoUnidad tipoUnidad) {
            return false;
        }
    }
}