package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by German on 04/06/2016.
 */
public class NoOcupado extends AlgoFormer {

    private static AlgoFormer noOcupado;

    private NoOcupado() {

    }

    public static AlgoFormer getInstance() {
        if (NoOcupado.noOcupado == null)
            NoOcupado.noOcupado = new NoOcupado();

        return NoOcupado.noOcupado;
    }

    public void transformar(){

    }
}
