package fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosInstantaneo;

import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Efecto;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by gaston.tulipani on 08/06/2016.
 */
public interface EfectoInstantaneo extends Efecto {
    @Override
    void aplicarEfecto(AlgoFormer algoformer);
}
