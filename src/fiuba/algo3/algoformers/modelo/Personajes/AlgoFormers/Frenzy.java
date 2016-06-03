package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Frenzy extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Frenzy() {
        nombre = "Frenzy";
        puntosDeVida = 400;
        bando = BandoDecepticons.instancia();
        int ataqueNormal = 10;
        int distanciaAtaqueNormal = 5;
        int velocidadNormal = 2;
        int ataqueTransformado = 25;
        int distanciaAtaqueTransformado = 2;
        int velocidadTransformado = 6;

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado, velocidadTransformado, TipoUnidadTerrestre.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
