package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosInstantaneo;

import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficie;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by gaston.tulipani on 08/06/2016.
 */
public interface EfectoSuperficieInstantaneo extends EfectoSuperficie {
    @Override
    void aplicarEfecto(AlgoFormer algoformer);
}
