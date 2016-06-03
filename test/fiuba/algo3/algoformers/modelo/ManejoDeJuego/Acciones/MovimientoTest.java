package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Accion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gaston.tulipani on 03/06/2016.
 */
public class MovimientoTest {
    @Test
    public void nuevoMovimientoValidoConOptimus_getPosicion_verificoPosicionDestino() {
        AlgoFormer megatron = new Megatron();
        Posicion posicionOrigen = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(1, 0);
        megatron.setPosicion(new Posicion(posicionOrigen.getX(),posicionOrigen.getY()));

        Accion movimiento = new Movimiento(megatron, posicionDestino);

        assertEquals(megatron.getPosicion(),posicionDestino);
    }
}
