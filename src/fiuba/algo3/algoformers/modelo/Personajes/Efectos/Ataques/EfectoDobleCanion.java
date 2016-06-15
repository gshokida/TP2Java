package fiuba.algo3.algoformers.modelo.Personajes.Efectos.Ataques;

/**
 * Created by german.shokida on 14/6/2016.
 */
public class EfectoDobleCanion extends EfectoAtaque {
    private int duracion;
    private int multiplicador = 2;

    public EfectoDobleCanion(int duracion) {
        this.duracion = duracion;
    }

    public int getDuracion() {
        return this.duracion;
    }

    @Override
    public double aplicarEfecto(double ataque) {
        return ataque * this.multiplicador;
    }

    @Override
    public boolean esAcumulableCon(EfectoAtaque efecto) {
        return efecto.esAcumulableCon(this);
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
