package fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Movimientos.EfectoMovimiento;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Movimientos.EfectoNebulosaAndromeda;
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

        EfectoMovimiento efecto = new EfectoNebulosaAndromeda(this.duracion);
        algoformer.agregarEfectoMovimiento(efecto);
    }
}
