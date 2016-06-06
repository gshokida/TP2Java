package fiuba.algo3.algoformers.modelo.Personajes.Modos;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by gaston.tulipani on 06/06/2016.
 */
public class ModoAlternoTest {
    @Test
    public void esModo_siSeEnviaASiMismo_esVerdadero() throws Exception {
        assertTrue(ModoAlterno.getInstance().esModo(ModoAlterno.getInstance()));
    }
}
