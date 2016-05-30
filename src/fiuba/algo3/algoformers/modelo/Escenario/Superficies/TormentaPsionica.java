package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class TormentaPsionica implements SuperficieAerea {
    private static SuperficieAerea tormentaPsionica;

    private TormentaPsionica() {

    }

    public static SuperficieAerea getInstance() {
        if (TormentaPsionica.tormentaPsionica == null)
            TormentaPsionica.tormentaPsionica = new TormentaPsionica();

        return TormentaPsionica.tormentaPsionica;
    }
}
