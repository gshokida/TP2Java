package fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by German on 11/06/2016.
 */
public class EfectoDobleCanion extends EfectoTemporal {
    private int multiplicador = 2;

    public EfectoDobleCanion(int duracion) {
        super(duracion); // Turnos que afecta;
    }

    protected void aplicarse() {
        AlgoFormer afectado = getAfectado();
        afectado.setAtaque(afectado.getAtaque() * this.multiplicador);
    }

    protected void revertirse() {
        AlgoFormer afectado = getAfectado();
        afectado.setAtaque(afectado.getAtaque() / this.multiplicador);
    }
}
