package fiuba.algo3.algoformers.modelo.Escenario.Contenidos;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by german.shokida on 27/5/2016.
 */
public interface Contenido {
     boolean esLaChispaSuprema(Contenido contenido);

     void interactuar(AlgoFormer algoformer);
}
