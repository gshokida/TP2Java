package fiuba.algo3.algoformers.modelo;

/**
 * Created by german.shokida on 24/5/2016.
 */
public abstract class AlgoFormer {
    protected String nombre;
    protected int vida;
    protected Modo modo;

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntosDeVida() {
        return this.vida;
    }

    public int getAtaque() {
        return this.modo.ataque();
    }

    public int getVelocidad() {
        return this.modo.velocidad();
    }

    public int getDistanciaDeAtaque() {
        return this.modo.distanciaAtaque();
    }
}
