package fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hennico on 23/5/2016.
 */
public class TipoUnidadTerrestreTest {
    @Test
    public void esTipoUnidad_siSeEnviaASiMismo_esVerdadero() {
        assertTrue(TipoUnidadTerrestre.getInstance().esTipoUnidad(TipoUnidadTerrestre.getInstance()));
    }

    @Test
    public void esTipoUniad_siSeEnviaTipoDeUnidadDistinto_esFalso() {
        assertFalse(TipoUnidadTerrestre.getInstance().esTipoUnidad(TipoUnidadAerea.getInstance()));
    }
}