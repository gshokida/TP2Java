package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Ratchet extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Ratchet() {
        nombre = "Ratchet";
        puntosDeVida = 150;
        bando = BandoAutobots.getInstance();
        int ataqueNormal = 5;
        int distanciaAtaqueNormal = 5;
        int velocidadNormal = 1;
        int ataqueTransformado = 35;
        int distanciaAtaqueTransformado = 2;
        int velocidadTransformado = 8;

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, TipoUnidadTerrestre.getInstance());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado, velocidadTransformado, TipoUnidadAerea.getInstance());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
