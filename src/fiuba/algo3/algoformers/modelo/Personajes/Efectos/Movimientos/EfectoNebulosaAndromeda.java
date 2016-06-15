package fiuba.algo3.algoformers.modelo.Personajes.Efectos.Movimientos;

/**
 * Created by german.shokida on 14/6/2016.
 */
public class EfectoNebulosaAndromeda implements EfectoMovimiento {
    private int duracion;
    private int multiplicador = 0;

    public EfectoNebulosaAndromeda(int duracion){
        this.duracion = duracion;
    }

    public int getDuracion() {
        return this.duracion;
    }

    @Override
    public int aplicarEfecto(int velocidad) {
        return velocidad * this.multiplicador;
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
