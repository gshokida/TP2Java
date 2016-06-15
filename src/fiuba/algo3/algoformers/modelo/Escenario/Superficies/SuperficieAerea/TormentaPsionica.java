package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Ataques.EfectoAtaque;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Ataques.EfectoTormentaPsionica;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class TormentaPsionica implements SuperficieAerea {
    private int porcentaje = 40;

    public void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException {
        if (algoformer.esTipoUnidad(new TipoUnidadTerrestre())) {
            throw new NoPuedeInteractuarConSuperficieException();
        }

        EfectoAtaque efecto = new EfectoTormentaPsionica();
        if(algoformer.agregarEfectoAtaque(efecto))
            aplicarEfectoInstantaneo(algoformer);
    }

    private void aplicarEfectoInstantaneo(AlgoFormer algoformer) {
        double ataqueAlgoformer = algoformer.getAtaque();
        ataqueAlgoformer = ataqueAlgoformer - (ataqueAlgoformer * porcentaje / 100);
        algoformer.setAtaque(ataqueAlgoformer);
    }
}
