package fiuba.algo3.algoformers.modelo.Escenario.Contenidos;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class ContenidoVacio implements Contenido {
    private static Contenido contenidoVacio;

    private ContenidoVacio() {    }

    public static Contenido getInstance() {
        if (ContenidoVacio.contenidoVacio == null)
            ContenidoVacio.contenidoVacio = new ContenidoVacio();
        return ContenidoVacio.contenidoVacio;
    }

    public boolean esLaChispaSuprema(Contenido contenido){
        return this.equals(contenido);
    }

    public void interactuar(AlgoFormer algoformer) {

    }
}
