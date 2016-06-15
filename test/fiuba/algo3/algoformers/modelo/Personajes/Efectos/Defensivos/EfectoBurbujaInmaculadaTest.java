package fiuba.algo3.algoformers.modelo.Personajes.Efectos.Defensivos;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by german.shokida on 15/6/2016.
 */
public class EfectoBurbujaInmaculadaTest {
    @Test
    public void efectoBurbujaAnulaElAtaque(){
        double ataque = 2;
        int duracion = 3;
        EfectoDefensivo efecto = new EfectoBurbujaInmaculada(duracion);

        assertEquals(efecto.aplicarEfecto(ataque), 0, 0D);
    }

    @Test
    public void efectoBurbujaMantieneSuDuracion(){
        int duracion = 3;
        EfectoBurbujaInmaculada efecto = new EfectoBurbujaInmaculada(duracion);

        assertEquals(efecto.getDuracion(), 3);
    }

    @Test
    public void pasarTurnoBajaUnoALaDuracionDelEfecto(){
        int duracion = 2;
        AlgoFormer optimus = new Optimus();
        EfectoBurbujaInmaculada efecto = new EfectoBurbujaInmaculada(duracion);

        optimus.agregarEfectoDefensivo(efecto);

        optimus.pasarTurno();
        assertEquals(efecto.getDuracion(), 1);
    }

    @Test
    public void agregarEfectoAnulaAtaqueDeOtroAlgoformer(){
        int duracion = 3;
        double vidaOptimusConBonus = 500;
        AlgoFormer optimus = new Optimus();
        EfectoDefensivo efecto = new EfectoBurbujaInmaculada(duracion);

        optimus.agregarEfectoDefensivo(efecto);

        optimus.recibirAtaque(100);

        assertEquals(optimus.getPuntosDeVida(), vidaOptimusConBonus, 0D);
    }

    @Test
    public void agregarEfectoConAlgoformerNoTransformado_transformarAnulaAtaqueDeOtroAlgoformer(){
        int duracion = 3;
        double vidaOptimusConBonus = 500;
        AlgoFormer optimus = new Optimus();
        EfectoDefensivo efecto = new EfectoBurbujaInmaculada(duracion);

        optimus.agregarEfectoDefensivo(efecto);
        optimus.transformar();

        optimus.recibirAtaque(50);

        assertEquals(optimus.getPuntosDeVida(), vidaOptimusConBonus, 0D);
    }

    @Test
    public void agregarEfectoConAlgoformerTransformadoAnulaAtaqueDeOtroAlgoformer(){
        int duracion = 3;
        double vidaOptimusConBonus = 500;
        AlgoFormer optimus = new Optimus();
        EfectoDefensivo efecto = new EfectoBurbujaInmaculada(duracion);

        optimus.transformar();

        optimus.agregarEfectoDefensivo(efecto);

        optimus.recibirAtaque(50);

        assertEquals(optimus.getPuntosDeVida(), vidaOptimusConBonus, 0D);
    }

    @Test
    public void aplicarDosVecesEfectoBurbuja_PasoTurnosHastaFinalizarPrimerBonus(){
        int duracion = 2;
        double vidaOptimusConBonus = 500;
        AlgoFormer optimus = new Optimus();
        EfectoBurbujaInmaculada efecto = new EfectoBurbujaInmaculada(duracion);
        EfectoBurbujaInmaculada efectoDos = new EfectoBurbujaInmaculada(duracion);

        optimus.agregarEfectoDefensivo(efecto);

        optimus.pasarTurno();

        optimus.agregarEfectoDefensivo(efectoDos);

        optimus.pasarTurno();

        optimus.recibirAtaque(50);

        assertEquals(optimus.getPuntosDeVida(), vidaOptimusConBonus, 0D);
    }

    @Test
    public void aplicarDosVecesEfectoBurbuja_PasoTurnosHastaFinalizarLosDosBonus(){
        int duracion = 2;
        double vidaOptimusConBonus = 450;
        AlgoFormer optimus = new Optimus();
        EfectoBurbujaInmaculada efecto = new EfectoBurbujaInmaculada(duracion);
        EfectoBurbujaInmaculada efectoDos = new EfectoBurbujaInmaculada(duracion);

        optimus.agregarEfectoDefensivo(efecto);

        optimus.pasarTurno();

        optimus.agregarEfectoDefensivo(efectoDos);

        optimus.pasarTurno();
        optimus.pasarTurno();

        optimus.recibirAtaque(50);

        assertEquals(optimus.getPuntosDeVida(), vidaOptimusConBonus, 0D);
    }
}
