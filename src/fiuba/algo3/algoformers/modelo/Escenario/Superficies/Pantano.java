package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.ModoHumanoide;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class Pantano implements SuperficieTerrestre {

    public void interactuar(AlgoFormer algoformer) throws NoPuedeInteractuarConSuperficieException {
        if(algoformer.esModo(ModoHumanoide.getInstance()))
            throw new NoPuedeInteractuarConSuperficieException();
    }
}
