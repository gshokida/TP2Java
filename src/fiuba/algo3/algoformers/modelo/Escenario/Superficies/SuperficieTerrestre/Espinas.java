package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAeronave;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class Espinas implements SuperficieTerrestre {

    private int porcentajeDanio = 5;

    public void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException {
        if (algoformer.esTipoUnidad(new TipoUnidadAeronave())) {
            throw new NoPuedeInteractuarConSuperficieException();
        }

        aplicarEfectoInstantaneo(algoformer);
    }

    private void aplicarEfectoInstantaneo(AlgoFormer algoformer) {
        double puntosDeVida = algoformer.getPuntosDeVida();

        puntosDeVida = puntosDeVida - (puntosDeVida * porcentajeDanio / 100);

        algoformer.setPuntosDeVida(puntosDeVida);
    }
}
