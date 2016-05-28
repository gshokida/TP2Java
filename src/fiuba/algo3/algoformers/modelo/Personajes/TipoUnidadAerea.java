package fiuba.algo3.algoformers.modelo.Personajes;

/**
 * Created by Hennico on 23/5/2016.
 */
public class TipoUnidadAerea implements TipoUnidad {
    private static TipoUnidadAerea unicaInstancia = new TipoUnidadAerea();
    private TipoUnidadAerea() {}
    public static TipoUnidadAerea instancia() {
        return unicaInstancia;
    }

    public boolean esTipoUnidad(TipoUnidad tipoUnidad) {
        return tipoUnidad == unicaInstancia;
    }
}
