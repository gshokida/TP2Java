package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

public class Bumblebee extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Bumblebee() {
        nombre = "Bumblebee";
        puntosDeVida = 350;
        bando = BandoAutobots.instancia();
        int ataqueNormal = 40;
        int distanciaAtaqueNormal = 1;
        int velocidadNormal = 2;
        int ataqueTransformado = 20;
        int distanciaAtaqueTransformado = 3;
        int velocidadTransformado = 5;

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado, velocidadTransformado, TipoUnidadTerrestre.instancia());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
