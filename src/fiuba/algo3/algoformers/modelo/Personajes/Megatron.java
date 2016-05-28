package fiuba.algo3.algoformers.modelo.Personajes;

public class Megatron extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Megatron() {
        nombre = "Megatron";
        puntosDeVida = 550;

        estado = new AlgoformerEstado(10, 3, 1, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(55, 2 ,8, TipoUnidadTerrestre.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }
}
