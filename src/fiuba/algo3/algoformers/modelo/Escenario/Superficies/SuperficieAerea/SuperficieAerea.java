package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by german.shokida on 15/6/2016.
 */
public abstract class SuperficieAerea {
    public abstract void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException;
    public int obtenerCostoMovimiento (){
        return 1;
    }
}
