package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by german.shokida on 6/6/2016.
 */
public class EfectoSuperficieEspinas implements EfectoSuperficie {
    private int duracion = 1;
    private int porcentaje = 5;

    public void aplicarEfecto(AlgoFormer algoformer){
        int danio = algoformer.getPuntosDeVida() * this.porcentaje / 100;
        algoformer.recibirDanio(danio);
    }

    public int duracionEfecto(){
        return this.duracion;
    }
}
