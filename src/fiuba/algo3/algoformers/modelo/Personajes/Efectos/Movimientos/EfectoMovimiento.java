package fiuba.algo3.algoformers.modelo.Personajes.Efectos.Movimientos;

import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Efecto;

/**
 * Created by german.shokida on 14/6/2016.
 */
public interface EfectoMovimiento extends Efecto {
    int aplicarEfecto (int velocidad);
}
