package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Optimus extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Optimus() {
        nombre = "Optimus Prime";
        puntosDeVida = 500;
        bando = BandoAutobots.instancia();
        int ataqueNormal = 50;
        int distanciaAtaqueNormal = 2;
        int velocidadNormal = 2;
        int ataqueTransformado = 15;
        int distanciaAtaqueTransformado = 4;
        int velocidadTransformado = 5;

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado ,velocidadTransformado, TipoUnidadTerrestre.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }


}
