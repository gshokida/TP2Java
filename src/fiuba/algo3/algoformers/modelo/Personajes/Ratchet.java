package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Ratchet extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Ratchet() {
        nombre = "Ratchet";
        puntosDeVida = 150;

        estado = new AlgoformerEstado(5, 5, 1, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(35, 2, 8, TipoUnidadAerea.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
