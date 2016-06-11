package fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hennico on 11/6/2016.
 */
public class TipoUnidadVehiculoTest {
    @Test
    public void esTipoUnidad_enviandoHumanoide_esFalso() {
        assertFalse(new TipoUnidadVehiculo().esTipoUnidad(new TipoUnidadHumanoide()));
    }
    @Test
    public void esTipoUnidad_enviandoVehiculo_esVerdadero() {
        assertTrue(new TipoUnidadVehiculo().esTipoUnidad(new TipoUnidadVehiculo()));
    }
    @Test
    public void esTipoUnidad_enviandoAeronave_esFalso() {
        assertFalse(new TipoUnidadVehiculo().esTipoUnidad(new TipoUnidadAeronave()));
    }
    @Test
    public void esTipoUnidad_enviandoTerrestre_esVerdadero() {
        assertTrue(new TipoUnidadVehiculo().esTipoUnidad(new TipoUnidadTerrestre()));
    }
}