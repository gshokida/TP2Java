package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by Familia on 07/06/2016.
 */
public interface EfectoSuperficieAtaque extends EfectoSuperficie {
    @Override
    void aplicarEfecto(AlgoFormer algoformer);
}
