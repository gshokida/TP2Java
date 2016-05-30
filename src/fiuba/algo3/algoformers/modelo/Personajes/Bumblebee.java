package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Bumblebee extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Bumblebee() {
        nombre = "Bumblebee";
        puntosDeVida = 350;
        bando = BandoAutobots.instancia();

        estado = new AlgoformerEstado(40, 1, 2, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(20, 3, 5, TipoUnidadTerrestre.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
