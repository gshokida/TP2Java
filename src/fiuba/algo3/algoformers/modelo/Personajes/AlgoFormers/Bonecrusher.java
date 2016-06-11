package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadHumanoide;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadVehiculo;

import java.util.LinkedList;

public class Bonecrusher extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Bonecrusher() {
        nombre = "Bonecrusher";
        puntosDeVida = 200;
        bando = BandoDecepticons.getInstance();
        efectos = new LinkedList<>();
        int ataqueNormal = 30;
        int distanciaAtaqueNormal = 3;
        int velocidadNormal = 1;
        int ataqueTransformado = 30;
        int distanciaAtaqueTransformado = 3;
        int velocidadTransformado = 8;

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, new TipoUnidadHumanoide());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado, velocidadTransformado, new TipoUnidadVehiculo());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
