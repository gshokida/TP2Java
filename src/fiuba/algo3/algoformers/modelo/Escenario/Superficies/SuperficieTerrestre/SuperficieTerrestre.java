package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by german.shokida on 15/6/2016.
 */
public interface SuperficieTerrestre {
    void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException;
}
