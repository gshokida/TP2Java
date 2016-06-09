package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficie;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by gaston.tulipani on 08/06/2016.
 */
public abstract class EfectoSuperficieDurable implements EfectoSuperficie {
    @Override
    public abstract void aplicarEfecto(AlgoFormer algoformer);
    public abstract void revertirEfecto(AlgoFormer algoFormer);
    public abstract void pasarTurno();
    public abstract boolean finalizo();
    @Override
    public abstract boolean equals(Object o);
    @Override
    public abstract int hashCode();
}
