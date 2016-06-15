package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAeronave;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadHumanoide;

import java.util.LinkedList;

public class Megatron extends AlgoFormer {
    private AlgoformerEstado estadoInactivo;

    public Megatron() {
        nombre = "Megatron";
        puntosDeVida = 550;
        bando = BandoDecepticons.getInstance();
        efectosAtaque = new LinkedList<>();
        efectosMovimiento = new LinkedList<>();
        efectosDefensivo = new LinkedList<>();
        int ataqueNormal = 10;
        int distanciaAtaqueNormal = 3;
        int velocidadNormal = 1;
        int ataqueTransformado = 55;
        int distanciaAtaqueTransformado = 2;
        int velocidadTransformado = 8;

        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, new TipoUnidadHumanoide());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado ,velocidadTransformado, new TipoUnidadAeronave());
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }
}
