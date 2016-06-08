package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by gaston.tulipani on 06/06/2016.
 */
public class EfectoTormentaPsionica implements EfectoSuperficieDurable {
    private int porcentaje = 40;
    private int ataqueSacado;

    public EfectoTormentaPsionica() {}

    @Override
    public void aplicarEfecto(AlgoFormer algoformer){
        this.ataqueSacado = algoformer.getAtaque() * porcentaje / 100;
        algoformer.debilitar(ataqueSacado);
    }
    @Override
    public void pasarTurno() {    }
}
