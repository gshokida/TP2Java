package fiuba.algo3.algoformers.modelo.Personajes.Efectos.Defensivos;

/**
 * Created by german.shokida on 15/6/2016.
 */
public class EfectoBurbujaInmaculada implements EfectoDefensivo {
    private int duracion;
    private double multiplicador = 0;

    public EfectoBurbujaInmaculada(int duracion){
        this.duracion = duracion;
    }

    public int getDuracion(){
        return this.duracion;
    }

    @Override
    public double aplicarEfecto(double danio) {
        return danio * this.multiplicador;
    }

    @Override
    public void pasarTurno() {
        this.duracion--;
    }

    @Override
    public boolean finalizo() {
        return this.duracion <= 0;
    }
}
