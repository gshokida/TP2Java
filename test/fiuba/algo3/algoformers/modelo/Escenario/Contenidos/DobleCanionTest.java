package fiuba.algo3.algoformers.modelo.Escenario.Contenidos;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable.EfectoDobleCanion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by German on 12/06/2016.
 */
public class DobleCanionTest {
    @Test
    public void aplicarEfectoDobleCanionAAlgoformerDuplicaSuAtaque(){
        double ataqueOptimusConEfecto = 50 * 2;

        DobleCanion bonusDobleCanion = new DobleCanion();
        AlgoFormer algoformer = new Optimus();

        bonusDobleCanion.interactuar(algoformer);

        assertEquals(ataqueOptimusConEfecto, algoformer.calcularAtaque(), 0D);
    }

    @Test
    public void aplicarEfectoDobleCanionDuraTresTurnos(){
        double ataqueOptimus = 50;

        DobleCanion bonusDobleCanion = new DobleCanion();
        AlgoFormer algoformer = new Optimus();

        bonusDobleCanion.interactuar(algoformer);

        algoformer.pasarTurno();
        algoformer.pasarTurno();
        algoformer.pasarTurno();

        assertEquals(ataqueOptimus, algoformer.calcularAtaque(), 0D);
    }
    /*
    @Test
    public void aplicarEfectoDobleDosVecesMultiplicaAtaquePorCuatro(){
        double ataqueOptimus = 200;

        DobleCanion bonusDobleCanion = new DobleCanion();
        DobleCanion segundoBonusDobleCanion = new DobleCanion();
        AlgoFormer algoformer = new Optimus();

        bonusDobleCanion.interactuar(algoformer);
        segundoBonusDobleCanion.interactuar(algoformer);

        assertEquals(ataqueOptimus, algoformer.calcularAtaque(), 0D);
    }*/
}
