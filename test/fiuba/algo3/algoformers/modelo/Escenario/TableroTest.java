package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Errores.TableroParInvalidoException;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.HoloSpark;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class TableroTest {

    @Test(expected=TableroParInvalidoException.class)
    public void testCrearTableroParLanzaExcepcion(){
        Tablero tablero = new Tablero(4,4);
    }


    @Test
    public void testTablero_EstaOcupadoCasilleroDelMedio(){
        Tablero tablero = new Tablero(5,5);

        Assert.assertTrue(tablero.casilleroOcupado(new Posicion(2, 2)));
    }

    @Test
    public void testTablero_EstaOcupadoCasilleroDelMedio_ConHoloSpark(){
        Tablero tablero = new Tablero(5,5);

        Assert.assertEquals(HoloSpark.instancia(), tablero.getCasillero(new Posicion(2, 2)).getContenido());
    }

    @Test
    public void testUnTableroImparLanzaExcepcion(){

    }
}
