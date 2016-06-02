package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Ratchet extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    private static int ataqueNormal = 5;
    private static int distanciaAtaqueNormal = 5;
    private static int velocidadNormal = 1;

    private static int ataqueTransformado = 35;
    private static int distanciaAtaqueTransformado = 2;
    private static int velocidadTransformado = 8;


    public Ratchet() {
        nombre = "Ratchet";
        puntosDeVida = 150;
        bando = BandoAutobots.instancia();

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado, velocidadTransformado, TipoUnidadAerea.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
