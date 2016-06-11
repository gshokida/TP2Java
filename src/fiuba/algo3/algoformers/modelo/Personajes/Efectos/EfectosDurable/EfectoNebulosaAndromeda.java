package fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by Familia on 07/06/2016.
 */
public class EfectoNebulosaAndromeda extends EfectoSuperficieDurable {
    static int hashSeed = 0;

    private int hashCode;
    private int velocidadSacada = 0;
    private int duracion = 3;

    public EfectoNebulosaAndromeda () {
        this.hashCode = EfectoNebulosaAndromeda.hashSeed;
        EfectoNebulosaAndromeda.hashSeed++;
    }

    @Override
    public void aplicarEfecto(AlgoFormer algoformer) {
        if (this.velocidadSacada == 0) {
            this.velocidadSacada = algoformer.getVelocidad();
            algoformer.frenar(velocidadSacada);
        }
    }
    @Override
    public void revertirEfecto(AlgoFormer algoFormer) {
        algoFormer.acelerar(velocidadSacada);
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
        return (o instanceof EfectoNebulosaAndromeda);
    }
    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
