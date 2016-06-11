package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadHumanoide;

/**
 * Created by Familia on 07/06/2016.
 */
public class EfectoPantano extends EfectoSuperficieDurable {
    static int hashSeed = 0;

    private int hashCode;
    private int velocidadSacada = 0;
    private boolean finalizo = false;

    public EfectoPantano() {
        this.hashCode = EfectoPantano.hashSeed;
        EfectoPantano.hashSeed++;
    }

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

    @Override
    public void pasarTurno() { }
    @Override
    public boolean finalizo() {
        return this.finalizo;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof EfectoPantano);
    }
    @Override
    public int hashCode() {
        return this.hashCode;
    }

}

