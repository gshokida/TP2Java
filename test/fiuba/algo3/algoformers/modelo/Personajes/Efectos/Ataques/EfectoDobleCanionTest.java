package fiuba.algo3.algoformers.modelo.Personajes.Efectos.Ataques;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by german.shokida on 14/6/2016.
 */
public class EfectoDobleCanionTest {
    @Test
    public void efectoDobleCanionMeDuplicaElAtaque(){
        double ataque = 2;
        int duracion = 3;
        EfectoAtaque efecto = new EfectoDobleCanion(duracion);

         assertEquals(efecto.aplicarEfecto(ataque), 4, 0D);
    }

    @Test
    public void efectoDobleCanionMantieneSuDuracion(){
        int duracion = 3;
        EfectoDobleCanion efecto = new EfectoDobleCanion(duracion);

        assertEquals(efecto.getDuracion(), 3);
    }

    @Test
    public void pasarTurnoBajaUnoALaDuracionDelEfecto(){
        int duracion = 3;
        AlgoFormer optimus = new Optimus();
        EfectoDobleCanion efecto = new EfectoDobleCanion(duracion);

        optimus.agregarEfectoAtaque(efecto);

        optimus.pasarTurno();
        assertEquals(efecto.getDuracion(), 2);
    }

    @Test
    public void agregarEfectoDuplicaAtaqueDelAlgoformer(){
        int duracion = 3;
        double ataqueOptimusConBonus = 50 * 2;
        AlgoFormer optimus = new Optimus();
        EfectoDobleCanion efecto = new EfectoDobleCanion(duracion);

        optimus.agregarEfectoAtaque(efecto);

        assertEquals(optimus.getAtaque(), ataqueOptimusConBonus, 0D);
    }

    @Test
    public void agregarEfectoDuplicaAtaqueDelAlgoformerTransformado(){
        int duracion = 3;
        double ataqueOptimusConBonus = 15 * 2;
        AlgoFormer optimus = new Optimus();
        EfectoDobleCanion efecto = new EfectoDobleCanion(duracion);

        optimus.agregarEfectoAtaque(efecto);
        optimus.transformar();

        assertEquals(optimus.getAtaque(), ataqueOptimusConBonus, 0D);
    }

    @Test
    public void aplicarDosVecesEfectoDobleCanionCuatriplicaAtaque(){
        int duracion = 3;
        double ataqueOptimusConBonus = 50 * 2 * 2;
        AlgoFormer optimus = new Optimus();
        EfectoDobleCanion efecto = new EfectoDobleCanion(duracion);
        EfectoDobleCanion efectoDos = new EfectoDobleCanion(duracion);

        optimus.agregarEfectoAtaque(efecto);
        optimus.agregarEfectoAtaque(efectoDos);

        assertEquals(optimus.getAtaque(), ataqueOptimusConBonus, 0D);
    }

    @Test
    public void aplicarDosVecesEfectoDobleCanion_PasoTurnosHastaFinalizarPrimerBonus(){
        int duracion = 3;
        double ataqueOptimusConBonus = 50 * 2;
        AlgoFormer optimus = new Optimus();
        EfectoDobleCanion efecto = new EfectoDobleCanion(duracion);
        EfectoDobleCanion efectoDos = new EfectoDobleCanion(duracion);

        optimus.agregarEfectoAtaque(efecto);

        optimus.pasarTurno();

        optimus.agregarEfectoAtaque(efectoDos);

        optimus.pasarTurno();
        optimus.pasarTurno();

        assertEquals(optimus.getAtaque(), ataqueOptimusConBonus, 0D);
    }

    @Test
    public void aplicarDosVecesEfectoDobleCanion_PasoTurnosHastaFinalizarLosDosBonus(){
        int duracion = 3;
        double ataqueOptimusConBonus = 50;
        AlgoFormer optimus = new Optimus();
        EfectoDobleCanion efecto = new EfectoDobleCanion(duracion);
        EfectoDobleCanion efectoDos = new EfectoDobleCanion(duracion);

        optimus.agregarEfectoAtaque(efecto);

        optimus.pasarTurno();

        optimus.agregarEfectoAtaque(efectoDos);

        optimus.pasarTurno();
        optimus.pasarTurno();
        optimus.pasarTurno();

        assertEquals(optimus.getAtaque(), ataqueOptimusConBonus, 0D);
    }
}
