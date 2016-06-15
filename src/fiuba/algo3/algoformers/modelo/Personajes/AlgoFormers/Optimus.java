package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadHumanoide;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadVehiculo;

import java.util.LinkedList;

public class Optimus extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Optimus() {
        nombre = "Optimus Prime";
        puntosDeVida = 500;
        bando = BandoAutobots.getInstance();
        efectosAtaque = new LinkedList<>();
        efectosMovimiento = new LinkedList<>();
        efectosDefensivo = new LinkedList<>();
        int ataqueNormal = 50;
        int distanciaAtaqueNormal = 2;
        int velocidadNormal = 2;
        int ataqueTransformado = 15;
        int distanciaAtaqueTransformado = 4;
        int velocidadTransformado = 5;

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, new TipoUnidadHumanoide());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado ,velocidadTransformado, new TipoUnidadVehiculo());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }


}
