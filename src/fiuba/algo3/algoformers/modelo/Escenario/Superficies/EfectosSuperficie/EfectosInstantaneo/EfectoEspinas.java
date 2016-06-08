package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosInstantaneo;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.EstadoMovimientoNominal;

/**
 * Created by german.shokida on 6/6/2016.
 */
public class EfectoEspinas implements EfectoSuperficieInstantaneo {
    private int porcentaje = 5;

    @Override
    public void aplicarEfecto(AlgoFormer algoformer){
        double danio = algoformer.getPuntosDeVida() * this.porcentaje / 100;
        algoformer.recibirDanio(danio);

        algoformer.setEstado(EstadoMovimientoNominal.getUnicaInstancia());
    }
}
