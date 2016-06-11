package fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hennico on 11/6/2016.
 */
public class TipoUnidadHumanoideTest {
    @Test
    public void esTipoUnidad_enviandoHumanoide_esVerdadero() {
        assertTrue(new TipoUnidadHumanoide().esTipoUnidad(new TipoUnidadHumanoide()));
    }
    @Test
    public void esTipoUnidad_enviandoVehiculo_esFalso() {
        assertFalse(new TipoUnidadHumanoide().esTipoUnidad(new TipoUnidadVehiculo()));
    }
    @Test
    public void esTipoUnidad_enviandoAeronave_esFalso() {
        assertFalse(new TipoUnidadHumanoide().esTipoUnidad(new TipoUnidadAeronave()));
    }
    @Test
    public void esTipoUnidad_enviandoTerrestre_esVerdadero() {
        assertTrue(new TipoUnidadHumanoide().esTipoUnidad(new TipoUnidadTerrestre()));
    }
}