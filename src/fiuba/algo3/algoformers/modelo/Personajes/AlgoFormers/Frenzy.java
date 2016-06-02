package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Frenzy extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    private static int ataqueNormal = 10;
    private static int distanciaAtaqueNormal = 5;
    private static int velocidadNormal = 2;

    private static int ataqueTransformado = 25;
    private static int distanciaAtaqueTransformado = 2;
    private static int velocidadTransformado = 6;

    public Frenzy() {
        nombre = "Frenzy";
        puntosDeVida = 400;
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
