package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.EstadoMovimientoNominal;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.ModoAlterno;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.ModoHumanoide;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

import java.util.LinkedList;

public class Megatron extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Megatron() {
        nombre = "Megatron";
        puntosDeVida = 550;
        bando = BandoDecepticons.getInstance();
        efectos = new LinkedList<>();
        int ataqueNormal = 10;
        int distanciaAtaqueNormal = 3;
        int velocidadNormal = 1;
        int ataqueTransformado = 55;
        int distanciaAtaqueTransformado = 2;
        int velocidadTransformado = 8;

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, TipoUnidadTerrestre.getInstance(), ModoHumanoide.getInstance());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado ,velocidadTransformado, TipoUnidadAerea.getInstance(), ModoAlterno.getInstance());

        this.estadoAlgoformer = EstadoMovimientoNominal.getUnicaInstancia();
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }
}
