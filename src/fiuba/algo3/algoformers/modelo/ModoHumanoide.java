package fiuba.algo3.algoformers.modelo;

/**
 * Created by german.shokida on 24/5/2016.
 */
public class ModoHumanoide extends ModoTerrestre {

    public ModoHumanoide(int ataque, int distanciaAtaque, int velocidad, Modo modoAlterno) {
        super(ataque, distanciaAtaque, velocidad);
        this.modoATransformar = modoAlterno;
        this.modoATransformar.setModoATransformar(this);
    }
}
