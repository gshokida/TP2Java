package fiuba.algo3.algoformers.modelo.Utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by german.shokida on 3/6/2016.
 */
public class ColaTest {
    @Test
    public void nuevaCola_estaVacia(){
        Cola<String> cola = new Cola<String>();
        assertFalse(cola.hasItems());
    }

    @Test
    public void nuevaCola_tamanioCero(){
        Cola<String> cola = new Cola<String>();
        assertEquals(cola.size(), 0);
    }
}
