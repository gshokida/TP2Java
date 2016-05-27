package fiuba.algo3.algoformers.modelo;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class Casillero {
    private Contenido contenido;

    public Casillero(Contenido contenido){
        this.contenido = contenido;
    }

    public Contenido getContenido(){
        return this.contenido;
    }
}
