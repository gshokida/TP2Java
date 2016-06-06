package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficie;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficieTormentaPsionica;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class TormentaPsionica implements SuperficieAerea {

    public void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException {
        EfectoSuperficie efecto = new EfectoSuperficieTormentaPsionica();

        algoformer.recibirEfectoSuperficies(efecto);

        algoformer.ejecutarEfecto();
    }
}
