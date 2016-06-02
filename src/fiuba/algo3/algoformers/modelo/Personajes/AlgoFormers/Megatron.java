package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Megatron extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Megatron() {
        nombre = "Megatron";
        puntosDeVida = 550;
        bando = BandoDecepticons.instancia();

        estado = new AlgoformerEstado(10, 3, 1, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(55, 2 ,8, TipoUnidadAerea.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }
}
