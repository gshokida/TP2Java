package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficie;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficieEspinas;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class Espinas implements SuperficieTerrestre {

    public void interactuar(AlgoFormer algoformer) {
        EfectoSuperficie efecto = new EfectoSuperficieEspinas();

        algoformer.recibirEfectoSuperficies(efecto);

        algoformer.ejecutarEfecto();
    }
}
