package fiuba.algo3.algoformers.modelo.Esenario;

import fiuba.algo3.algoformers.modelo.Esenario.Casillero;
import fiuba.algo3.algoformers.modelo.Esenario.Tablero;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class TableroTest {


    @Test
    public void testGeneric(){

    }


    //NOTA MENTAL: Los tableros deben tener numeros pares porque los arrays empiezan en el elento 0.

    @Test
    public void testCrearTablero(){

        Tablero tablero = new Tablero(4,4);

        Assert.assertTrue(tablero.tieneTamanio(4*4));


    }

    @Test
    public void testBuscarMedio(){

        Tablero tablero = new Tablero(4,4);

        Assert.assertTrue(tablero.medio() == 4);

    }

    @Test
    public void testEncontrarElElementoMedioDeCasillero(){

        Tablero tablero = new Tablero(4,4);

        Casillero casillero = new Casillero();

        tablero.llenarCasilleroDelMedio(casillero);

        Assert.assertTrue(tablero.devolverElementoMedio().equals(casillero));

    }





    @Test
    public void testUnTableroImparLanzaExcepcion(){

    }



}
