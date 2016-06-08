package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by Familia on 07/06/2016.
 */
public class EfectoNebulosaAndromeda implements EfectoSuperficieDurable {
    private int velocidadSacada = 0;
    private int duracion = 3;

    public EfectoNebulosaAndromeda () {
    }

    public int getDuracion() {
        return duracion;
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
}
