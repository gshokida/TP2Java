package fiuba.algo3.algoformers.modelo.Escenario;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by german.shokida on 2/6/2016.
 */
public class PosicionTest {
    @Test
    public void nuevaPosicion_GuardaLosValoresXEnElConstructor(){
        int x = 5;
        int y = 4;

        Posicion posicion = new Posicion(x, y);

        assertEquals(x, posicion.getX());
    }

    @Test
    public void nuevaPosicion_GuardaLosValoresYEnElConstructor(){
        int x = 5;
        int y = 4;

        Posicion posicion = new Posicion(x, y);

        assertEquals(y, posicion.getY());
    }

    @Test
    public void actualizarPosicion_ConValoresPredefinidos_GuardaLosValoresX(){
        int x = 5;
        int y = 4;

        Posicion posicion = new Posicion(x, y);

        int x2 = 10;
        int y2 = 11;

        posicion.actualizarPosicion(x2, y2);

        assertEquals(x2, posicion.getX());
    }

    @Test
    public void actualizarPosicion_ConValoresPredefinidos_GuardaLosValoresY(){
        int x = 5;
        int y = 4;

        Posicion posicion = new Posicion(x, y);

        int x2 = 10;
        int y2 = 11;

        posicion.actualizarPosicion(x2, y2);

        assertEquals(y2, posicion.getY());
    }

    @Test
    public void actualizarPosicion_enviandoOtraPosicion_GuardaLosValoresX(){
        int x = 5;
        int y = 4;

        Posicion posicion = new Posicion(x, y);

        int x2 = 10;
        int y2 = 11;

        Posicion otraPosicion = new Posicion(x2, y2);

        posicion.actualizarPosicion(otraPosicion);

        assertEquals(x2, posicion.getX());
    }

    @Test
    public void actualizarPosicion_enviandoOtraPosicion_GuardaLosValoresY(){
        int x = 5;
        int y = 4;

        Posicion posicion = new Posicion(x, y);

        int x2 = 10;
        int y2 = 11;

        Posicion otraPosicion = new Posicion(x2, y2);

        posicion.actualizarPosicion(otraPosicion);

        assertEquals(y2, posicion.getY());
    }
}
