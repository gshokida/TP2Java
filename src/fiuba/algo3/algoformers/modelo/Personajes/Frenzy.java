package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Frenzy extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Frenzy() {
        nombre = "Frenzy";
        puntosDeVida = 400;

        estado = new AlgoformerEstado(10, 5, 2, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(25, 2, 6, TipoUnidadTerrestre.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
