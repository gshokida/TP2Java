package fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosInstantaneo;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Efecto;

/**
 * Created by gaston.tulipani on 08/06/2016.
 */
public abstract class EfectoInstantaneo implements Efecto {

    public void aplicarEfecto(AlgoFormer afectado) {
        aplicarse(afectado);
        afectado.removerEfecto(this);
    }

    protected abstract void aplicarse(AlgoFormer afectado);
    public void revertirEfecto(AlgoFormer afectado) { }
    public void pasarTurno() {
        //throw new LosEfectosInstantaneosNoPasanDeTurnoError();
    }
}
