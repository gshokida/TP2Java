package fiuba.algo3.modelo;

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
