package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Frenzy extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Frenzy() {
        nombre = "Frenzy";
        puntosDeVida = 400;
        bando = BandoDecepticons.instancia();

        estado = new AlgoformerEstado(10, 5, 2, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(25, 2, 6, TipoUnidadTerrestre.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
