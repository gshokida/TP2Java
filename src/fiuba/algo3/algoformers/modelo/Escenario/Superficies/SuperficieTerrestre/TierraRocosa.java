package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAeronave;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class TierraRocosa extends SuperficieTerrestre {
    public void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException {
        if(algoformer.esTipoUnidad(new TipoUnidadAeronave())) {
            throw new NoPuedeInteractuarConSuperficieException();
        }
    }
}
