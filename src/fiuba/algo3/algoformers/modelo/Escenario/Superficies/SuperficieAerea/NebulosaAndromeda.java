package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoNebulosaAndromeda;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficieMovimiento;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class NebulosaAndromeda implements SuperficieAerea {
    public void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException {
        EfectoSuperficieMovimiento efecto = new EfectoNebulosaAndromeda();

        algoformer.agregarEfecto(efecto);
    }
}
