package fiuba.algo3.algoformers.modelo.Personajes.Efectos.Ataques;

/**
 * Created by german.shokida on 15/6/2016.
 */
public class EfectoTormentaPsionica extends EfectoAtaque {
    @Override
    public double aplicarEfecto(double ataque) {
        return ataque;
    }

    @Override
    public boolean esAcumulableCon(EfectoAtaque efecto) {
        return efecto.esAcumulableCon(this);
    }

    @Override
    public void pasarTurno() {

    }

    @Override
    public boolean finalizo() {
        return false;
    }

    @Override
    protected boolean esAcumulableCon(EfectoTormentaPsionica efecto){
        return false;
    }
}
