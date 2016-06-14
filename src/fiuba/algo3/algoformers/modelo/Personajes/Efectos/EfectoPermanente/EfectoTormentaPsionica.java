package fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectoPermanente;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by gaston.tulipani on 06/06/2016.
 */
public class EfectoTormentaPsionica extends EfectoPermanente {
    private int porcentaje;

    public EfectoTormentaPsionica (int porcentaje){
        this.porcentaje = porcentaje;
    }

    @Override
    public void aplicarEfecto(AlgoFormer algoformer) {
        double ataqueActual = algoformer.getAtaque();
        double ataqueAfectado = ataqueActual * this.porcentaje / 100;
        algoformer.setAtaque(ataqueAfectado);
    }

    @Override
    public void revertirEfecto(AlgoFormer algoformer) {
        double ataqueActual = algoformer.getAtaque();
        double ataqueAfectado = ataqueActual * 100 / (100 - this.porcentaje);
        algoformer.setAtaque(ataqueAfectado);
    }
}
