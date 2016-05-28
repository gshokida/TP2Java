package fiuba.algo3.algoformers.modelo.Personajes;

/**
 * Created by german.shokida on 24/5/2016.
 */
public abstract class AlgoFormer {
    protected String nombre;
    protected int vida;
    protected int ataque;
    protected int velocidad;
    protected int distanciaAtaque;

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getDistanciaDeAtaque() {
        return distanciaAtaque;
    }
}
