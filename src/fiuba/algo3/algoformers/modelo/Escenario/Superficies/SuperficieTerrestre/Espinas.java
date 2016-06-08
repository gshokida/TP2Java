package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre;

import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficie;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosInstantaneo.EfectoEspinas;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class Espinas implements SuperficieTerrestre {

    public void interactuar(AlgoFormer algoformer) {
        EfectoSuperficie efecto = new EfectoEspinas();

        efecto.aplicarEfecto(algoformer);
    }
}
