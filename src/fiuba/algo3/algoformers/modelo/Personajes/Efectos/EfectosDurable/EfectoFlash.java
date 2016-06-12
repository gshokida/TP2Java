package fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by German on 12/06/2016.
 */
public class EfectoFlash extends EfectoDurable {
    static int hashSeed = 0;
    private int hashCode;
    private int velocidadAgregada = 0;
    private int duracion;

    public EfectoFlash(int duracion) {
        this.duracion = duracion;
        this.hashCode = EfectoFlash.hashSeed;
        EfectoFlash.hashSeed++;
    }

    @Override
    public void aplicarEfecto(AlgoFormer algoformer) {
        if (this.velocidadAgregada == 0) {
            this.velocidadAgregada = algoformer.getVelocidad() * 2;
            algoformer.acelerar(velocidadAgregada);
        }
    }

    @Override
    public void revertirEfecto(AlgoFormer algoFormer) {
        algoFormer.frenar(this.velocidadAgregada);
    }

    @Override
    public void pasarTurno() {
        this.duracion--;
    }

    @Override
    public boolean finalizo() {
        return (this.duracion == 0);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof EfectoFlash);
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
