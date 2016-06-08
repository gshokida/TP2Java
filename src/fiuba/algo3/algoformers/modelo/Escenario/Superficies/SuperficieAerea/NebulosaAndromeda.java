package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable.EfectoNebulosaAndromeda;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable.EfectoSuperficieDurable;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class NebulosaAndromeda implements SuperficieAerea {
    public void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException {
        EfectoSuperficieDurable efecto = new EfectoNebulosaAndromeda();

        algoformer.agregarEfecto(efecto);
    }
}
