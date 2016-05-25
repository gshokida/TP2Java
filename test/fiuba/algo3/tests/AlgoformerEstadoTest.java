package fiuba.algo3.tests;

import fiuba.algo3.modelo.AlgoformerEstado;
import fiuba.algo3.modelo.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AlgoformerEstadoTest {
    @Test
    public void nuevaInstancia_ataque_tieneValorIndicado() {
        AlgoformerEstado estado = new AlgoformerEstado(15f,4,4, TipoUnidadTerrestre.instancia());

        assertTrue(estado.getAtaque() == 15f);
    }

    @Test
    public void nuevaInstancia_distanciaDeAtaque_tieneValorIndicado() throws Exception {
        AlgoformerEstado estado = new AlgoformerEstado(15f,4,5, TipoUnidadTerrestre.instancia());

        assertTrue(estado.getDistanciaDeAtaque() == 4);
    }

    @Test
    public void nuevaInstancia_velocidad_tieneValorIndicado() {
        AlgoformerEstado estado = new AlgoformerEstado(15f,4,5, TipoUnidadTerrestre.instancia());

        assertTrue(estado.getVelocidad() == 5);
    }

    @Test
    public void esTipoUnidad_enviandoElMismoTipoQueSeUsoEnElConstructor_daVerdadero() throws Exception {
        AlgoformerEstado estado = new AlgoformerEstado(15f,4,5,TipoUnidadTerrestre.instancia());

        assertTrue(estado.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }
}