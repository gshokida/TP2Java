package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadHumanoide;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadVehiculo;

import java.util.LinkedList;

public class Frenzy extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Frenzy() {
        nombre = "Frenzy";
        puntosDeVida = 400;
        bando = BandoDecepticons.getInstance();
        efectos = new LinkedList<>();
        int ataqueNormal = 10;
        int distanciaAtaqueNormal = 5;
        int velocidadNormal = 2;
        int ataqueTransformado = 25;
        int distanciaAtaqueTransformado = 2;
        int velocidadTransformado = 6;

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, new TipoUnidadHumanoide());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado, velocidadTransformado, new TipoUnidadVehiculo());

    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
