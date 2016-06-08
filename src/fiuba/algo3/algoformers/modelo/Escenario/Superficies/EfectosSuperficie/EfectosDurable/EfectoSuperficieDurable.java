package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficie;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by gaston.tulipani on 08/06/2016.
 */
public interface EfectoSuperficieDurable extends EfectoSuperficie {
    @Override
    void aplicarEfecto(AlgoFormer algoformer);
    void pasarTurno();
}
