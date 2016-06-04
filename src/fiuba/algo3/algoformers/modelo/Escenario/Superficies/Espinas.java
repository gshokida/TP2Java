package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class Espinas implements SuperficieTerrestre {
    private static SuperficieTerrestre espina;

    private Espinas() {

    }

    public static SuperficieTerrestre getInstance() {
        if (Espinas.espina == null) {
            Espinas.espina = new Espinas();
        }

        return Espinas.espina;
    }
}
