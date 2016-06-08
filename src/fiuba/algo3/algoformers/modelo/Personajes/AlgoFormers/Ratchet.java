package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.ModoAlterno;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.ModoHumanoide;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

import java.util.LinkedList;

public class Ratchet extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Ratchet() {
        nombre = "Ratchet";
        puntosDeVida = 150;
        bando = BandoAutobots.getInstance();
        efectosDeAtaque = new LinkedList<>();
        efectosDeMovimiento = new LinkedList<>();
        int ataqueNormal = 5;
        int distanciaAtaqueNormal = 5;
        int velocidadNormal = 1;
        int ataqueTransformado = 35;
        int distanciaAtaqueTransformado = 2;
        int velocidadTransformado = 8;

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, TipoUnidadTerrestre.getInstance(), ModoHumanoide.getInstance());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado, velocidadTransformado, TipoUnidadAerea.getInstance(), ModoAlterno.getInstance());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
