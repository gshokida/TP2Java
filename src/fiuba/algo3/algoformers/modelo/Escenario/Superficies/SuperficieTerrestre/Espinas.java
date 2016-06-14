package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Efecto;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosInstantaneo.EfectoEspinas;
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
        Efecto efecto = new EfectoEspinas(this.porcentajeDanio);

        efecto.aplicarEfecto(algoformer);
    }
}
