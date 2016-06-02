package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class TierraRocosa implements SuperficieTerrestre {
    private static SuperficieTerrestre tierraRocosa;

    private TierraRocosa() {

    }

    public static SuperficieTerrestre getInstance() {
        if (TierraRocosa.tierraRocosa == null)
            TierraRocosa.tierraRocosa = new TierraRocosa();

        return TierraRocosa.tierraRocosa;
    }
}
