package fiuba.algo3.algoformers.modelo.Personajes.Efectos.Movimientos;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by german.shokida on 15/6/2016.
 */
public class EfectoFlashTest {
    @Test
    public void efectoFlashMultiplicaPorTresLaVelocidad(){
        int velocidad = 10;
        int multiplicador = 3;
        int duracion = 3;
        EfectoMovimiento efecto = new EfectoFlash(duracion);

        assertEquals(efecto.aplicarEfecto(velocidad), velocidad * multiplicador);
    }

    @Test
    public void efectoFlashMantieneSuDuracion(){
        int duracion = 3;
        EfectoFlash efecto = new EfectoFlash(duracion);

        assertEquals(efecto.getDuracion(), 3);
    }

    @Test
    public void pasarTurnoBajaUnoALaDuracionDelEfecto(){
        int duracion = 3;
        AlgoFormer optimus = new Optimus();
        EfectoFlash efecto = new EfectoFlash(duracion);

        optimus.agregarEfectoMovimiento(efecto);

        optimus.pasarTurno();
        assertEquals(efecto.getDuracion(), 2);
    }

    @Test
    public void agregarEfectoDuplicaAtaqueDelAlgoformer(){
        int duracion = 3;
        int velocidadOptimusConBonus = 2 * 3;
        AlgoFormer optimus = new Optimus();
        EfectoFlash efecto = new EfectoFlash(duracion);

        optimus.agregarEfectoMovimiento(efecto);

        assertEquals(optimus.getVelocidad(), velocidadOptimusConBonus);
    }

    @Test
    public void agregarEfectoDuplicaAtaqueDelAlgoformerTransformado(){
        int duracion = 3;
        int velocidadOptimusConBonus = 5 * 3;
        AlgoFormer optimus = new Optimus();
        EfectoFlash efecto = new EfectoFlash(duracion);

        optimus.agregarEfectoMovimiento(efecto);
        optimus.transformar();

        assertEquals(optimus.getVelocidad(), velocidadOptimusConBonus);
    }

    @Test
    public void aplicarDosVecesEfectoFlashCuatriplicaAtaque(){
        int duracion = 3;
        int velocidadOptimusConBonus = 2 * 3 * 3;
        AlgoFormer optimus = new Optimus();
        EfectoFlash efecto = new EfectoFlash(duracion);
        EfectoFlash efectoDos = new EfectoFlash(duracion);

        optimus.agregarEfectoMovimiento(efecto);
        optimus.agregarEfectoMovimiento(efectoDos);

        assertEquals(optimus.getVelocidad(), velocidadOptimusConBonus);
    }

    @Test
    public void aplicarDosVecesEfectoFlash_PasoTurnosHastaFinalizarPrimerBonus(){
        int duracion = 3;
        int velocidadOptimusConBonus = 2 * 3;
        AlgoFormer optimus = new Optimus();
        EfectoFlash efecto = new EfectoFlash(duracion);
        EfectoFlash efectoDos = new EfectoFlash(duracion);

        optimus.agregarEfectoMovimiento(efecto);

        optimus.pasarTurno();

        optimus.agregarEfectoMovimiento(efectoDos);

        optimus.pasarTurno();
        optimus.pasarTurno();

        assertEquals(optimus.getVelocidad(), velocidadOptimusConBonus);
    }
}
