package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.*;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Accion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;

/**
 * Created by gaston.tulipani on 03/06/2016.
 */
public class Movimiento implements Accion {
    private AlgoFormer algoFormer;
    private int totalMovimientos;
    private Casillero casilleroActual;

    public Movimiento(Casillero casilleroOrigen, AlgoFormer algoFormer) {
        this.algoFormer = algoFormer;
        this.totalMovimientos = 0;
        this.casilleroActual = casilleroOrigen;
    }

    public void moverHasta(Casillero casilleroDestino) throws DistanciaExcedidaException, ImposibleMoverseCasilleroOcupadoException {
        if (!casilleroDestino.getAlgoformer().equals(NoOcupado.getInstance()))
            throw new ImposibleMoverseCasilleroOcupadoException();

        int distancia = this.casilleroActual.getPosicion().obtenerDistanciaHasta(casilleroDestino.getPosicion());

        if (distancia > this.getMovimientosRestantes())
            throw new DistanciaExcedidaException();

        this.totalMovimientos += (distancia);
        casilleroDestino.setAlgoformer(this.casilleroActual.getAlgoformer());
        this.casilleroActual.setAlgoformer(NoOcupado.getInstance());
        this.casilleroActual = casilleroDestino;
    }

    private int getMovimientosRestantes(){
        return this.algoFormer.getVelocidad() - this.totalMovimientos;
    }

    public boolean quedanMovimientos() {
        return this.algoFormer.getVelocidad() > this.totalMovimientos;
    }
}
