package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by german.shokida on 2/6/2016.
 */
public class ControlDeTurnosTest {
    @Test
    public void nuevoControlDeTurnos_getNumeroTurno_ComienzaUno(){
        ControlDeTurnos controlDeTurnos = new ControlDeTurnos();

        assertEquals(1, controlDeTurnos.getNumeroTurno());
    }
}
