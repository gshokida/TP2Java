package fiuba.algo3.algoformers.modelo.Personajes.Efectos.Movimientos;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by german.shokida on 14/6/2016.
 */
public class EfectoNebulosaAndromedaTest {
    @Test
    public void efectoNebulosaMultiplicaPorCeroLaVelocidad(){
        int velocidad = 10;
        int duracion = 3;
        EfectoMovimiento efecto = new EfectoNebulosaAndromeda(duracion);

        assertEquals(efecto.aplicarEfecto(velocidad), 0);
    }

    @Test
    public void efectoNebulosaMantieneSuDuracion(){
        int duracion = 3;
        EfectoNebulosaAndromeda efecto = new EfectoNebulosaAndromeda(duracion);

        assertEquals(efecto.getDuracion(), 3);
    }

    @Test
    public void pasarTurnoBajaUnoALaDuracionDelEfecto(){
        int duracion = 3;
        AlgoFormer optimus = new Optimus();
        EfectoNebulosaAndromeda efecto = new EfectoNebulosaAndromeda(duracion);

        optimus.agregarEfectoMovimiento(efecto);

        optimus.pasarTurno();
        assertEquals(efecto.getDuracion(), 2);
    }

    @Test
    public void agregarEfectoDuplicaAtaqueDelAlgoformer(){
        int duracion = 3;
        int velocidadOptimusConBonus = 2 * 0;
        AlgoFormer optimus = new Optimus();
        EfectoNebulosaAndromeda efecto = new EfectoNebulosaAndromeda(duracion);

        optimus.agregarEfectoMovimiento(efecto);

        assertEquals(optimus.getVelocidad(), velocidadOptimusConBonus);
    }

    @Test
    public void agregarEfectoDuplicaAtaqueDelAlgoformerTransformado(){
        int duracion = 3;
        int velocidadOptimusConBonus = 5 * 0;
        AlgoFormer optimus = new Optimus();
        EfectoNebulosaAndromeda efecto = new EfectoNebulosaAndromeda(duracion);

        optimus.agregarEfectoMovimiento(efecto);
        optimus.transformar();

        assertEquals(optimus.getVelocidad(), velocidadOptimusConBonus);
    }
}
