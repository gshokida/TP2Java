package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable.EfectoPantano;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable.EfectoSuperficieDurable;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.ModoHumanoide;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class Pantano implements SuperficieTerrestre {

    public void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException {
        if(algoformer.esModo(ModoHumanoide.getInstance()))
            throw new NoPuedeInteractuarConSuperficieException();
        EfectoSuperficieDurable efecto = new EfectoPantano();

        algoformer.agregarEfecto(efecto);
    }
}
