package fiuba.algo3.algoformers.modelo.Personajes.Efectos.EfectosInstantaneo;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by german.shokida on 6/6/2016.
 */
public class EfectoEspinas extends EfectoInstantaneo {
    private int porcentajeDeVidaARestar;

    public EfectoEspinas(int porcentajeDeVidaARestar) {
        this.porcentajeDeVidaARestar = porcentajeDeVidaARestar;
    }

    @Override
    protected void aplicarse(AlgoFormer afectado) {
        double vidaRestante = (afectado.getPuntosDeVida() * (100 - porcentajeDeVidaARestar)) / 100;
        afectado.setPuntosDeVida(vidaRestante);
    }
}
