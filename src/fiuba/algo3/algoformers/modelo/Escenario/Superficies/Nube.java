package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class Nube implements SuperficieAerea {
    private static SuperficieAerea nube;

    private Nube() {

    }

    public static SuperficieAerea getInstance() {
        if (Nube.nube == null)
            Nube.nube = new Nube();

        return Nube.nube;
    }
}
