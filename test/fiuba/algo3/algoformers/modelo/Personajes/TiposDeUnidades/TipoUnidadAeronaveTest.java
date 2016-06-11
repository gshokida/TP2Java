package fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hennico on 23/5/2016.
 */
public class TipoUnidadAeronaveTest {
    @Test
    public void esTipoUnidad_enviandoHumanoide_esFalso() {
        assertFalse(new TipoUnidadAeronave().esTipoUnidad(new TipoUnidadHumanoide()));
    }
    @Test
    public void esTipoUnidad_enviandoVehiculo_esFalso() {
        assertFalse(new TipoUnidadAeronave().esTipoUnidad(new TipoUnidadVehiculo()));
    }
    @Test
    public void esTipoUnidad_enviandoAeronave_esVerdadero() {
        assertTrue(new TipoUnidadAeronave().esTipoUnidad(new TipoUnidadAeronave()));
    }
    @Test
    public void esTipoUnidad_enviandoTerrestre_esFalso() {
        assertFalse(new TipoUnidadAeronave().esTipoUnidad(new TipoUnidadTerrestre()));
    }
}