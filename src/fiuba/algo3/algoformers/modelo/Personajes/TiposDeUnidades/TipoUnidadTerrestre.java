package fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades;

/**
 * Created by Hennico on 23/5/2016.
 */
public class TipoUnidadTerrestre implements TipoUnidad {
    private static TipoUnidadTerrestre unicaInstancia = new TipoUnidadTerrestre();
    private TipoUnidadTerrestre() {}
    public static TipoUnidadTerrestre instancia() {
        return unicaInstancia;
    }

    public boolean esTipoUnidad(TipoUnidad tipoUnidad) {
        return tipoUnidad == unicaInstancia;
    }
}
