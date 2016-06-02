package fiuba.algo3.algoformers.modelo.Contenidos;

import fiuba.algo3.algoformers.modelo.Escenario.Contenido;

/**
 * Created by Rodrigo on 01/06/2016.
 */
public class HoloSpark implements Contenido{

    private static HoloSpark unicaInstancia = new HoloSpark();

    private HoloSpark() {

    }


    public static HoloSpark instancia (){
        return unicaInstancia;
    }


    public boolean esLaHoloSpark (Contenido contenido){
        return this.equals(contenido);
    }
}
