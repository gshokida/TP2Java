package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Accion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by gaston.tulipani on 05/06/2016.
 */
public class Transformacion implements Accion {
    private AlgoFormer algoFormer;

    public Transformacion (AlgoFormer algoFormer) {
        this.algoFormer = algoFormer;
    }

    public void aplicarTransformacion() {
        this.algoFormer.transformar();
    }
}
