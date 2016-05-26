package fiuba.algo3.algoformers.modelo;

/**
 * Created by german.shokida on 24/5/2016.
 */
public class ModoAereo extends Modo {
    private Modo modoATransformar;

    public ModoAereo(int ataque, int distanciaAtaque, int velocidad) {
        super(ataque, distanciaAtaque, velocidad);
    }

    public void setModoATransformar (Modo modo){
        this.modoATransformar = modo;
    }

    public Modo transformar(){
        return this.modoATransformar;
    }
}
