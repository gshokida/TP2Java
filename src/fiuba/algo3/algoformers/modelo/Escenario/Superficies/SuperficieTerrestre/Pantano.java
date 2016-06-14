package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable.EfectoPantano;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable.EfectoTemporal;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAeronave;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class Pantano implements SuperficieTerrestre {

    public void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException {
        if (algoformer.esTipoUnidad(new TipoUnidadAeronave())) {
            throw new NoPuedeInteractuarConSuperficieException();
        }
        EfectoTemporal efecto = new EfectoPantano(3);
        algoformer.agregarEfecto(efecto);
    }
}
