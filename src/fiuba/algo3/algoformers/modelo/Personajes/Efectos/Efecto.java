package fiuba.algo3.algoformers.modelo.Personajes.Efectos;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by german.shokida on 6/6/2016.
 */
public interface Efecto {
    void aplicarEfecto(AlgoFormer algoformer);
    void revertirEfecto(AlgoFormer algoformer);
    void pasarTurno();
}
