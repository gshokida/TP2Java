package fiuba.algo3.algoformers.modelo.Personajes.Efectos.Ataques;

import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Efecto;

/**
 * Created by german.shokida on 14/6/2016.
 */
public abstract class EfectoAtaque implements Efecto {
    public abstract double aplicarEfecto (double ataque);

    public abstract boolean esAcumulableCon(EfectoAtaque efecto);

    protected boolean esAcumulableCon(EfectoDobleCanion efecto){
        return true;
    }
    protected boolean esAcumulableCon(EfectoTormentaPsionica efecto){
        return true;
    }
}
