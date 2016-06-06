package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie;

import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficie;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by gaston.tulipani on 06/06/2016.
 */
public class EfectoSuperficieTormentaPsionica implements EfectoSuperficie {
    private int porcentaje = 40;

    public void aplicarEfecto(AlgoFormer algoformer){
        double disminucionAtaque = algoformer.getAtaque() * this.porcentaje / 100;
        algoformer.disminuirAtaque(disminucionAtaque);
    }

    @Override
    public int duracionEfecto() {
        return 0;
    }
}
