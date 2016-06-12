package fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosDurable;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by German on 11/06/2016.
 */
public class EfectoDobleCanion extends EfectoDurable {
    static int hashSeed = 0;
    private int hashCode;
    private int multiplicador = 2;
    private int duracion;
    private double ataqueAgregado = 0;

    public EfectoDobleCanion(int duracion){
        this.duracion = duracion;
        this.hashCode = EfectoNebulosaAndromeda.hashSeed;
        EfectoDobleCanion.hashSeed++;
    }

    @Override
    public void aplicarEfecto(AlgoFormer algoformer) {
        if (this.ataqueAgregado == 0) {
            this.ataqueAgregado = algoformer.getAtaque();
            algoformer.multiplicarAtaque(this.multiplicador);
        }
    }

    @Override
    public void revertirEfecto(AlgoFormer algoFormer) {
        //algoFormer.dividirAtaque(this.multiplicador);
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
        return (o instanceof EfectoDobleCanion);
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
