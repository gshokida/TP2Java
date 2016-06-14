package fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by German on 12/06/2016.
 */
public class EfectoFlash extends EfectoTemporal {
    private int multiplicador = 3;

    public EfectoFlash(int duracion) {
        super(duracion);
    }

    protected void aplicarse() {
        AlgoFormer afectado = getAfectado();
        afectado.setVelocidad(afectado.getVelocidad() * this.multiplicador);
    }

    protected void revertirse() {
        AlgoFormer afectado = getAfectado();
        afectado.setVelocidad(afectado.getVelocidad() / this.multiplicador);
    }
}
