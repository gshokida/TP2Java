package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoformerEstado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.EstadoMovimientoNominal;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.ModoAlterno;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.ModoHumanoide;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;

import java.util.LinkedList;
import java.util.List;

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
        fueDebilitado = false;
        estado = new AlgoformerEstado(ataqueNormal, distanciaAtaqueNormal, velocidadNormal, TipoUnidadTerrestre.getInstance(), ModoHumanoide.getInstance());
        estadoInactivo = new AlgoformerEstado(ataqueTransformado, distanciaAtaqueTransformado, velocidadTransformado, TipoUnidadTerrestre.getInstance(), ModoAlterno.getInstance());

        this.estadoAlgoformer = EstadoMovimientoNominal.getUnicaInstancia();
    }

    public void transformar() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estado;
        estado = auxiliar;
    }

}
