package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie;

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
}
