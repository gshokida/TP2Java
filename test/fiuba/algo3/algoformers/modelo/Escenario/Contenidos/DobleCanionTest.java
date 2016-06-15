package fiuba.algo3.algoformers.modelo.Escenario.Contenidos;


import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
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

        assertEquals(ataqueOptimusConEfecto, algoformer.getAtaque(), 0D);
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

        assertEquals(ataqueOptimus, algoformer.getAtaque(), 0D);
    }

    @Test
    public void transformar_acuandoEstaSiendoAfectadoPorUnEfecto_mantieneElEfecto(){
        double ataqueOptimusTransformadoConEfecto = 15 * 2;

        DobleCanion bonusDobleCanion = new DobleCanion();
        AlgoFormer algoformer = new Optimus();

        bonusDobleCanion.interactuar(algoformer);

        algoformer.transformar();

        assertEquals(ataqueOptimusTransformadoConEfecto, algoformer.getAtaque(), 0D);
    }

    @Test
    public void transformar_acuandoLuegoDeSerAfectadoPorUnEfecto_mantieneElEfecto(){
        double ataqueOptimusTransformadoConEfecto = 15 * 2;

        DobleCanion bonusDobleCanion = new DobleCanion();
        AlgoFormer algoformer = new Optimus();
        algoformer.transformar();
        bonusDobleCanion.interactuar(algoformer);

        assertEquals(ataqueOptimusTransformadoConEfecto, algoformer.getAtaque(), 0D);
    }

    @Test
    public void aplicarEfectoDobleDosVecesMultiplicaAtaquePorCuatro(){
        double ataqueOptimus = 200;

        DobleCanion bonusDobleCanion = new DobleCanion();
        DobleCanion segundoBonusDobleCanion = new DobleCanion();
        AlgoFormer algoformer = new Optimus();

        bonusDobleCanion.interactuar(algoformer);
        segundoBonusDobleCanion.interactuar(algoformer);

        assertEquals(ataqueOptimus, algoformer.getAtaque(), 0D);
    }
}
