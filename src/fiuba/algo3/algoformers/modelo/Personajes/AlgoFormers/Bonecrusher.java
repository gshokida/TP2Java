package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Bonecrusher extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    private static int ataqueNormal = 30;
    private static int distanciaAtaqueNormal = 3;
    private static int velocidadNormal = 1;

    private static int ataqueTransformado = 30;
    private static int distanciaAtaqueTransformado = 3;
    private static int velocidadTransformado = 8;

    public Bonecrusher() {
        nombre = "Bonecrusher";
        puntosDeVida = 200;
        bando = BandoDecepticons.instancia();

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado, velocidadTransformado, TipoUnidadTerrestre.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
