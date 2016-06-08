package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosInstantaneo;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.EstadoEmpantanado;

/**
 * Created by Familia on 07/06/2016.
 */
public class EfectoPantano implements EfectoSuperficieInstantaneo {
    @Override
    public void aplicarEfecto(AlgoFormer algoformer) {  algoformer.setEstado(EstadoEmpantanado.getUnicaInstancia());  }

}

