package fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades;

/**
 * Created by Hennico on 23/5/2016.
 */
public abstract class TipoUnidad {
    public boolean esTipoUnidad(TipoUnidad tipoUnidad) {
        return tipoUnidad.sonIguales(this);
    }
    protected abstract boolean sonIguales (TipoUnidad tipoUnidad);
}