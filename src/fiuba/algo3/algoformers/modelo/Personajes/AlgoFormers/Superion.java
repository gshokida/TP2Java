package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Efecto;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

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

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, new TipoUnidadTerrestre());
    }

    public void transformar() {

    }

    @Override
    public void pasarTurno() {
        for(Efecto efecto : this.efectosAtaque)
            efecto.pasarTurno();
        for(Efecto efecto : this.efectosMovimiento)
            efecto.pasarTurno();
        for(Efecto efecto : this.efectosDefensivo)
            efecto.pasarTurno();

        limpiarEfectos();

        this.duracion--;

    }
}
