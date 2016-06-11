package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class Nube implements SuperficieAerea {

    public void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException {
        if(algoformer.esTipoUnidad(new TipoUnidadTerrestre()))
            throw new NoPuedeInteractuarConSuperficieException();
    }
}
