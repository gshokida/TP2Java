package fiuba.algo3.algoformers.modelo;

/**
 * Created by german.shokida on 24/5/2016.
 */
public class Megatron extends AlgoFormer implements Transformable{

    public Megatron(){
        this.nombre = "Megatron";
        this.vida = 550;
        this.modo = new ModoHumanoide(10, 3, 1, new ModoAereo(55, 2, 8));
    }

    public void transformar() {
        this.modo = this.modo.transformar();
    }
}
