package fiuba.algo3.algoformers.modelo.Escenario.Contenidos;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Ataques.EfectoAtaque;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Ataques.EfectoDobleCanion;

/**
 * Created by German on 11/06/2016.
 */
public class DobleCanion extends Bonus {
    private int duracion = 3;

    @Override
    public void interactuar(AlgoFormer algoformer) {
        EfectoAtaque efecto = new EfectoDobleCanion(this.duracion);
        algoformer.agregarEfectoAtaque(efecto);
    }
}
