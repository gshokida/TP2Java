package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable.EfectoNebulosaAndromeda;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable.EfectoTemporal;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class NebulosaAndromeda implements SuperficieAerea {
    private int duracion = 3;

    public void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException {
        if (algoformer.esTipoUnidad(new TipoUnidadTerrestre())) {
            throw new NoPuedeInteractuarConSuperficieException();
        }
        EfectoTemporal efecto = new EfectoNebulosaAndromeda(this.duracion);

        algoformer.agregarEfecto(efecto);
    }
}
