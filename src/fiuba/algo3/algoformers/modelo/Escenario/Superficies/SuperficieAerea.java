package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by german.shokida on 27/5/2016.
 */
public interface SuperficieAerea {
    void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException;
}
