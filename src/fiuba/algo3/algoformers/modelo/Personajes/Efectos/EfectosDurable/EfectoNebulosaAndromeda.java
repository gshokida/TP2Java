package fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by Familia on 07/06/2016.
 */
public class EfectoNebulosaAndromeda extends EfectoTemporal {
    private int velocidadAnterior;

    public EfectoNebulosaAndromeda (int duracion) {
        super(duracion);
    }

    protected void aplicarse() {
        AlgoFormer afectado = getAfectado();
        this.velocidadAnterior = afectado.getVelocidad();
        afectado.setVelocidad(0);
    }

    protected void revertirse() {
        AlgoFormer afectado = getAfectado();
        afectado.setVelocidad(this.velocidadAnterior);
    }
    /*
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
    */
}
