package fiuba.algo3.algoformers.modelo.Personajes;

public class Optimus extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Optimus() {
        nombre = "Optimus Prime";
        puntosDeVida = 500;

        estado = new AlgoformerEstado(50, 2, 2, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(15, 4 ,5, TipoUnidadTerrestre.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
