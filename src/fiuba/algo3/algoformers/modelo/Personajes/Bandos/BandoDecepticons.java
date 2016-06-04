package fiuba.algo3.algoformers.modelo.Personajes.Bandos;

/**
 * Created by Hennico on 29/5/2016.
 */
public class BandoDecepticons implements Bando {
    private static BandoDecepticons unicaInstancia = new BandoDecepticons();
    private BandoDecepticons() {}
    public static BandoDecepticons getInstance() {
        return unicaInstancia;
    }

    public boolean esMismoBando(Bando bando) {
        return this.equals(bando);
    }
}
