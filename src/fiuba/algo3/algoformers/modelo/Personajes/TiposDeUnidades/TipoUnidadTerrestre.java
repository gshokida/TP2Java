package fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades;

/**
 * Created by Hennico on 23/5/2016.
 */
public class TipoUnidadTerrestre extends TipoUnidad {
    protected boolean sonIguales(TipoUnidad tipoUnidad) {
        return tipoUnidad instanceof TipoUnidadTerrestre;
    }
}