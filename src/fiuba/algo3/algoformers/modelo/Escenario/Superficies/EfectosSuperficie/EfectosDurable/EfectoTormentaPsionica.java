package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by gaston.tulipani on 06/06/2016.
 */
public class EfectoTormentaPsionica extends EfectoSuperficieDurable {
    static int hashSeed = 0;

    private int hashCode;
    private int porcentaje = 40;
    private int ataqueSacado = 0;

    public EfectoTormentaPsionica() {
        this.hashCode = EfectoTormentaPsionica.hashSeed;
        EfectoTormentaPsionica.hashSeed++;
    }

    @Override
    public void aplicarEfecto(AlgoFormer algoformer){
        if (this.ataqueSacado == 0) {
            this.ataqueSacado = algoformer.getAtaque() * porcentaje / 100;
            algoformer.debilitar(ataqueSacado);
        }
    }
    @Override
    public void revertirEfecto(AlgoFormer algoFormer) {    }

    @Override
    public void pasarTurno() {    }
    @Override
    public boolean finalizo() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        return(o instanceof EfectoTormentaPsionica);
    }
    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
