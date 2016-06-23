package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadHumanoide;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by german.shokida on 22/6/2016.
 */
public class Superion extends AlgoFormer {
    private int duracion = 3;
    private List<AlgoFormer> algoFormers;

    public Superion(List<AlgoFormer> algoFormers) {
        nombre = "Superion";
        puntosDeVida = 0;
        bando = BandoDecepticons.getInstance();
        efectosAtaque = new LinkedList<>();
        efectosMovimiento = new LinkedList<>();
        efectosDefensivo = new LinkedList<>();
        int ataqueNormal = 100;
        int distanciaAtaqueNormal = 2;
        int velocidadNormal = 3;

        this.algoFormers = algoFormers;

        for (AlgoFormer algo : algoFormers)
            this.puntosDeVida += algo.getPuntosDeVida();

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, new TipoUnidadHumanoide());
    }

    public void transformar() {

    }
}
