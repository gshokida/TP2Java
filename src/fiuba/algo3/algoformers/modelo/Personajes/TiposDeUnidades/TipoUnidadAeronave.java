package fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades;

/**
 * Created by Hennico on 23/5/2016.
 */
public class TipoUnidadAeronave extends TipoUnidad {
    protected boolean sonIguales(TipoUnidad tipoUnidad) {
        try {
            TipoUnidadAeronave prueba = (TipoUnidadAeronave) tipoUnidad;
            return true;
        }
        catch(Exception error) {
            return false;
        }
    }
}