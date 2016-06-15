package fiuba.algo3.algoformers.modelo.Escenario.Contenidos;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by German on 11/06/2016.
 */
public abstract class Bonus implements Contenido{
    public boolean esLaChispaSuprema(Contenido contenido){
        return false;
    }

    public abstract void interactuar(AlgoFormer algoformer);
}
