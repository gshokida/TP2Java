package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Megatron extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    private static int ataqueNormal = 10;
    private static int distanciaAtaqueNormal = 3;
    private static int velocidadNormal = 1;

    private static int ataqueTransformado = 55;
    private static int distanciaAtaqueTransformado = 2;
    private static int velocidadTransformado = 8;

    public Megatron() {
        nombre = "Megatron";
        puntosDeVida = 550;
        bando = BandoDecepticons.instancia();

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado ,velocidadTransformado, TipoUnidadAerea.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }
}
