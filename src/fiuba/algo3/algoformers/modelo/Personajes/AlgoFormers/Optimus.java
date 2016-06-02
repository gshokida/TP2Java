package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Optimus extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    private static int ataqueNormal = 50;
    private static int distanciaAtaqueNormal = 2;
    private static int velocidadNormal = 2;

    private static int ataqueTransformado = 15;
    private static int distanciaAtaqueTransformado = 4;
    private static int velocidadTransformado = 5;

    public Optimus() {
        nombre = "Optimus Prime";
        puntosDeVida = 500;
        bando = BandoAutobots.instancia();

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado ,velocidadTransformado, TipoUnidadTerrestre.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }


}
