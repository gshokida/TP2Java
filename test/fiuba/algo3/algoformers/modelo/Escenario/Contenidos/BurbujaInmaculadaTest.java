package fiuba.algo3.algoformers.modelo.Escenario.Contenidos;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Ataque;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by german.shokida on 19/6/2016.
 */
public class BurbujaInmaculadaTest {
    @Test
    public void interactuarConBurbujaInmaculadaNoRecibeDanioDeOtroAlgoformer(){
        AlgoFormer algoFormer = new Optimus();
        BurbujaInmaculada bonusBurbuja = new BurbujaInmaculada();
        double vidaOptimus = 500;

        bonusBurbuja.interactuar(algoFormer);

        algoFormer.recibirAtaque(50);

        assertEquals(vidaOptimus, algoFormer.getPuntosDeVida(), 0D);
    }

    @Test
    public void interactuarConBurbujaInmaculadaSigueEfectoPasandoUnTurno(){
        AlgoFormer algoFormer = new Optimus();
        BurbujaInmaculada bonusBurbuja = new BurbujaInmaculada();
        double vidaOptimus = 500;

        bonusBurbuja.interactuar(algoFormer);

        algoFormer.pasarTurno();

        algoFormer.recibirAtaque(50);

        assertEquals(vidaOptimus, algoFormer.getPuntosDeVida(), 0D);
    }

    @Test
    public void interactuarConBurbujaInmaculadaDuraDosTurnos(){
        AlgoFormer algoFormer = new Optimus();
        BurbujaInmaculada bonusBurbuja = new BurbujaInmaculada();
        double vidaOptimusConDanio = 450;
        bonusBurbuja.interactuar(algoFormer);

        algoFormer.pasarTurno();
        algoFormer.pasarTurno();

        algoFormer.recibirAtaque(50);

        assertEquals(vidaOptimusConDanio, algoFormer.getPuntosDeVida(), 0D);
    }
}
