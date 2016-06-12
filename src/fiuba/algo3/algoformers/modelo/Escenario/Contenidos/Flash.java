package fiuba.algo3.algoformers.modelo.Escenario.Contenidos;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable.EfectoFlash;

/**
 * Created by German on 12/06/2016.
 */
public class Flash extends Bonus {
    private int duracion = 3;


    @Override
    public void interactuar(AlgoFormer algoformer) {
        EfectoFlash efecto = new EfectoFlash(this.duracion);
        algoformer.agregarEfecto(efecto);
    }
}
