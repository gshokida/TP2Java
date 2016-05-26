package fiuba.algo3.algoformers.modelo;

/**
 * Created by german.shokida on 24/5/2016.
 */
public class Optimus extends AlgoFormer implements Transformable {

    public Optimus(){
        this.nombre = "Optimus Prime";
        this.vida = 500;
        this.modo = new ModoHumanoide(50, 2, 2, new ModoVehiculo(15, 4, 5));
    }

    public void transformar(){
        this.modo = this.modo.transformar();
    }
}
