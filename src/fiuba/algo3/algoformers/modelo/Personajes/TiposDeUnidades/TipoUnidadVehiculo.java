package fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades;

/**
 * Created by Hennico on 11/6/2016.
 */
public class TipoUnidadVehiculo extends TipoUnidadTerrestre {
    @Override
    protected boolean sonIguales(TipoUnidad tipoUnidad) {
        try {
            TipoUnidadVehiculo prueba = (TipoUnidadVehiculo)tipoUnidad;
            return true;
        }
        catch(Exception error) {
            return false;
        }
    }
}
