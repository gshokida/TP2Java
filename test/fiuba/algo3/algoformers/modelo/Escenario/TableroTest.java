package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Optimus;
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

        Tablero tablero = new Tablero(5,5);

        Assert.assertTrue(tablero.tieneTamanio(5*5));


    }

    @Test
    public void testBuscarMedio(){

        Tablero tablero = new Tablero(5,5);

        Assert.assertTrue(tablero.medio() == 4);

    }

    @Test
    public void testEncontrarElElementoMedioDeCasillero(){

        Tablero tablero = new Tablero(5,5);

        Casillero casillero = new Casillero();

        tablero.llenarCasilleroDelMedio(casillero);

        Assert.assertTrue(tablero.devolverElementoMedio().equals(casillero));

    }

    @Test
    public void testTablero_Esta_Ocupado(){

        AlgoFormer optimus = new Optimus();

        Tablero tablero = new Tablero(5,5);

        Casillero casillero = new Casillero();

        casillero.setContenido(optimus);

        tablero.llenarCasilleroDelMedio(casillero);


        Assert.assertTrue(tablero.casilleroOcupado(2,2));


    }



    @Test
    public void testUnTableroImparLanzaExcepcion(){

    }
}
