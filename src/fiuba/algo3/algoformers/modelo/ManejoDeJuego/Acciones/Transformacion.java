package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.HumanoideNoPuedeAtravesarPantanoException;
import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Errores.NoPuedeTransformarseEnHumanoideException;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Accion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadHumanoide;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

/**
 * Created by gaston.tulipani on 05/06/2016.
 */
public class Transformacion implements Accion {
    private AlgoFormer algoFormer;
    private Casillero casillero;

    public Transformacion (Casillero casillero, AlgoFormer algoFormer) {
        this.algoFormer = algoFormer;
        this.casillero = casillero;
    }

    public void aplicarTransformacion() throws NoPuedeTransformarseEnHumanoideException {
        this.algoFormer.transformar();
        if (this.algoFormer.esTipoUnidad(new TipoUnidadHumanoide())){
            try {
                casillero.getSuperficieTerreste().interactuar(this.algoFormer);
            } catch (HumanoideNoPuedeAtravesarPantanoException e) {
                this.algoFormer.transformar();
                throw new NoPuedeTransformarseEnHumanoideException();
            } catch (NoPuedeInteractuarConSuperficieException e) {

            }
        }
    }
}
