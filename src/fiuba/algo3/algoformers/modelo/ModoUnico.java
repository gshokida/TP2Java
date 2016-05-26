package fiuba.algo3.algoformers.modelo;

/**
 * Created by german.shokida on 26/5/2016.
 */
public class ModoUnico extends ModoTerrestre {
    public ModoUnico(int ataque, int distanciaAtaque, int velocidad) {
        super(ataque, distanciaAtaque, velocidad);
        this.modoATransformar = this;
    }
}
