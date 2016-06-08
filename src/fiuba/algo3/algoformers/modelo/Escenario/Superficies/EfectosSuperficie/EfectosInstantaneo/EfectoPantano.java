package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosInstantaneo;

import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable.EfectoSuperficieDurable;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by Familia on 07/06/2016.
 */
public class EfectoPantano implements EfectoSuperficieDurable {
    @Override
    public void aplicarEfecto(AlgoFormer algoformer) {  algoformer.frenar(algoformer.getVelocidad()%2);  }

    @Override
    public void revertirEfecto(AlgoFormer algoFormer) {   algoFormer.acelerar(algoFormer.getVelocidad()*2); }

    @Override
    public void pasarTurno() {    }

    @Override
    public boolean finalizo() {
        return false;
    }
}

