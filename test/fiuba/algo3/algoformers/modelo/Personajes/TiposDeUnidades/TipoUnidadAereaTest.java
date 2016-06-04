package fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hennico on 23/5/2016.
 */
public class TipoUnidadAereaTest {
    @Test
    public void esTipoUnidad_siSeEnviaASiMismo_esVerdadero() throws Exception {
        assertTrue(TipoUnidadAerea.getInstance().esTipoUnidad(TipoUnidadAerea.getInstance()));
    }

    @Test
    public void esTipoUniad_siSeEnviaTipoDeUnidadDistinto_esFalso() throws Exception {
        assertFalse(TipoUnidadAerea.getInstance().esTipoUnidad(TipoUnidadTerrestre.getInstance()));
    }
}