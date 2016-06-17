package fiuba.algo3.algoformers.modelo.Personajes.Efectos.Movimientos;

/**
 * Created by german.shokida on 16/6/2016.
 */
public class EfectoPantano implements EfectoMovimiento {
    private int multiplicador = 0;

    public EfectoPantano(int duracion){

    }

    @Override
    public int aplicarEfecto(int velocidad) {
        return velocidad * this.multiplicador;
    }

    @Override
    public void pasarTurno() {
    }

    @Override
    public boolean finalizo() {
        return true;
    }
}