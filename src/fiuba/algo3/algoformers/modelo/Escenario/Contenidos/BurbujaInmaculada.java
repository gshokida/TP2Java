package fiuba.algo3.algoformers.modelo.Escenario.Contenidos;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Defensivos.EfectoBurbujaInmaculada;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Defensivos.EfectoDefensivo;

/**
 * Created by german.shokida on 15/6/2016.
 */
public class BurbujaInmaculada extends Bonus {
    private int duracion = 2;

    @Override
    public void interactuar(AlgoFormer algoformer) {
        EfectoDefensivo efecto = new EfectoBurbujaInmaculada(this.duracion);
        algoformer.agregarEfectoDefensivo(efecto);
    }
}
