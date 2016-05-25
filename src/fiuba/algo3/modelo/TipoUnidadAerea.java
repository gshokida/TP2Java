package fiuba.algo3.modelo;

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
