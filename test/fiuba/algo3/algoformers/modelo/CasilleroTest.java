package fiuba.algo3.algoformers.modelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class CasilleroTest {
    @Test
    public void casilleroNuevoEsVacio(){
        Contenido contenido = new ContenidoVacio();
        Casillero casillero = new Casillero(contenido);

        assertEquals(casillero.getContenido(), contenido);
    }

    @Test
    public void casilleroConSuperficieDeTierra(){

    }
}
