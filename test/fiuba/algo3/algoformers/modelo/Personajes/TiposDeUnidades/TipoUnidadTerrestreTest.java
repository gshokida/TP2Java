package fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hennico on 23/5/2016.
 */
public class TipoUnidadTerrestreTest {
    @Test
    public void esTipoUnidad_enviandoHumanoide_esFalso() {
        assertFalse(new TipoUnidadTerrestre().esTipoUnidad(new TipoUnidadHumanoide()));
    }
    @Test
    public void esTipoUnidad_enviandoVehiculo_esFalso() {
        assertFalse(new TipoUnidadTerrestre().esTipoUnidad(new TipoUnidadVehiculo()));
    }
    @Test
    public void esTipoUnidad_enviandoAeronave_esFalso() {
        assertFalse(new TipoUnidadTerrestre().esTipoUnidad(new TipoUnidadAeronave()));
    }
    @Test
    public void esTipoUnidad_enviandoTerrestre_esVerdadero() {
        assertTrue(new TipoUnidadTerrestre().esTipoUnidad(new TipoUnidadTerrestre()));
    }
}