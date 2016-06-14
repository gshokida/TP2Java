package fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Efecto;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by gaston.tulipani on 08/06/2016.
 */
public abstract class EfectoTemporal implements Efecto {
    private int duracion;
    private AlgoFormer afectado;

    protected EfectoTemporal(int duracion) {
        this.duracion = duracion;
    }

    public void aplicarEfecto(AlgoFormer afectado) {
        this.afectado = afectado;
        aplicarse();
    }

    public void revertirEfecto(AlgoFormer afectado) {
        this.afectado = afectado;
        revertirse();
    }

    protected abstract void aplicarse();
    protected abstract void revertirse();

    protected AlgoFormer getAfectado() {
        return afectado;
    }

    public void pasarTurno() {
        duracion--;
        if (duracion == 0)
            afectado.removerEfecto(this);
    }
}
