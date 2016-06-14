package fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadHumanoide;

/**
 * Created by Familia on 07/06/2016.
 */
public class EfectoPantano extends EfectoTemporal {

    public EfectoPantano(int duracion) {
        super(duracion);
    }

    protected void aplicarse() {

    }

    protected void revertirse() {

    }
    /*
    @Override
    public void aplicarEfecto(AlgoFormer algoformer) {
        if (this.velocidadSacada == 0) {
            if (algoformer.esTipoUnidad(new TipoUnidadHumanoide())) {
                this.velocidadSacada = algoformer.getVelocidad();
            }
            else {
                double velocidadActual = algoformer.getVelocidad();
                this.velocidadSacada = (int)Math.ceil(velocidadActual / 2);
            }
            algoformer.frenar(velocidadSacada);
        }
    }
    @Override
    public void revertirEfecto(AlgoFormer algoFormer) {
        algoFormer.acelerar(velocidadSacada);
    }
    */
}

