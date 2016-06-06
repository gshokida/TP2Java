package fiuba.algo3.algoformers.modelo.Personajes.Modos;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by gaston.tulipani on 06/06/2016.
 */
public class ModoHumanoideTest {
    @Test
    public void esModo_siSeEnviaASiMismo_esVerdadero() {
        assertTrue(ModoHumanoide.getInstance().esModo(ModoHumanoide.getInstance()));
    }

    @Test
    public void esModo_siSeEnviaModoDistinto_esFalse() throws Exception {
        assertFalse(ModoHumanoide.getInstance().esModo(ModoAlterno.getInstance()));
    }
}
