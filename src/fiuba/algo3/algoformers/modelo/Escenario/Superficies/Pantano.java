package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class Pantano implements SuperficieTerrestre {
    private static SuperficieTerrestre pantano;

    private Pantano() {

    }

    public static SuperficieTerrestre getInstance() {
        if (Pantano.pantano == null) {
            Pantano.pantano = new Pantano();
        }

        return Pantano.pantano;
    }
}
