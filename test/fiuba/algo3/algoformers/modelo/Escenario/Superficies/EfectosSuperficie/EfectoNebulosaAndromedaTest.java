package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie;

import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable.EfectoNebulosaAndromeda;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by gaston.tulipani on 08/06/2016.
 */
public class EfectoNebulosaAndromedaTest {
    @Test
    public void nuevoEfectoNebulosaAndromeda_pasarTurno_disminuyeLaDuracion() {
        EfectoNebulosaAndromeda efecto = new EfectoNebulosaAndromeda();
        int duracionEfecto = efecto.getDuracion();

        efecto.pasarTurno();

        assertEquals(duracionEfecto - 1, efecto.getDuracion());
    }

    @Test
    public void Nebulosa_Desactiva_El_Algoformer() {
        EfectoNebulosaAndromeda nebulosa = new EfectoNebulosaAndromeda();
        AlgoFormer megatron = new Megatron();

        megatron.transformar();

        nebulosa.aplicarEfecto(megatron);

        Assert.assertEquals(megatron.getVelocidad(), 0);


    }







}
