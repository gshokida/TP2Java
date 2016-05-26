package fiuba.algo3.algoformers.modelo;

/**
 * Created by german.shokida on 24/5/2016.
 */
public abstract class Modo {
    protected int ataque;
    protected int distanciaAtaque;
    protected int velocidad;
    protected Modo modoATransformar;

    protected Modo(int ataque, int distanciaAtaque, int velocidad){
        this.ataque = ataque;
        this.distanciaAtaque = distanciaAtaque;
        this.velocidad = velocidad;
    }

    public int ataque(){
        return this.ataque;
    }

    public int distanciaAtaque(){
        return this.distanciaAtaque;
    }

    public int velocidad(){
        return this.velocidad;
    }

    public void setModoATransformar (Modo modo){
        this.modoATransformar = modo;
    }

    public Modo transformar(){
        return this.modoATransformar;
    }
}
