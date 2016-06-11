package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Hennico on 23/5/2016.
 */
public class AlgoformerEstadoTest {
    @Test
    public void nuevaInstancia_ataque_tieneValorIndicado() {
        AlgoformerEstado estado = new AlgoformerEstado(15,4,4, new TipoUnidadTerrestre());

        assertTrue(estado.getAtaque() == 15f);
    }

    @Test
    public void nuevaInstancia_distanciaDeAtaque_tieneValorIndicado() {
        AlgoformerEstado estado = new AlgoformerEstado(15,4,5, new TipoUnidadTerrestre());

        assertTrue(estado.getDistanciaDeAtaque() == 4);
    }

    @Test
    public void nuevaInstancia_velocidad_tieneValorIndicado() {
        AlgoformerEstado estado = new AlgoformerEstado(15,4,5, new TipoUnidadTerrestre());

        assertTrue(estado.getVelocidad() == 5);
    }

    @Test
    public void esTipoUnidad_enviandoElMismoTipoQueSeUsoEnElConstructor_daVerdadero() {
        AlgoformerEstado estado = new AlgoformerEstado(15,4,5,new TipoUnidadTerrestre());

        assertTrue(estado.esTipoUnidad(new TipoUnidadTerrestre()));
    }
}