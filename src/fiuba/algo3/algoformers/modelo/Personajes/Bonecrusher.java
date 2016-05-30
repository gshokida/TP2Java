package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Bonecrusher extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Bonecrusher() {
        nombre = "Bonecrusher";
        puntosDeVida = 200;

        estado = new AlgoformerEstado(30, 3, 1, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(30, 3, 8, TipoUnidadTerrestre.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
