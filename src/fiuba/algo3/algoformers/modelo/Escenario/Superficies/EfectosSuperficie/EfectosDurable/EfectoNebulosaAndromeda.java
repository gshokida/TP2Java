package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by Familia on 07/06/2016.
 */
public class EfectoNebulosaAndromeda implements EfectoSuperficieDurable {
    private int velocidadSacada;
    private int duracion;

    public EfectoNebulosaAndromeda () {
        this.duracion = 3;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public void aplicarEfecto(AlgoFormer algoformer) {
        this.velocidadSacada = algoformer.getVelocidad();
        algoformer.frenar();
    }

    @Override
    public void pasarTurno() {
        this.duracion--;
    }
}
