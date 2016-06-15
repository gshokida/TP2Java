package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.*;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Accion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;

/**
 * Created by gaston.tulipani on 03/06/2016.
 */
public class Movimiento implements Accion {
    private int velocidadOriginal;
    private int movimientosRestantes;
    private Casillero casilleroActual;

    public Movimiento(Casillero casilleroOrigen, int distanciaMovimiento) {
        this.velocidadOriginal = distanciaMovimiento;
        this.movimientosRestantes = distanciaMovimiento;
        this.casilleroActual = casilleroOrigen;
    }

    public void moverHasta(Casillero casilleroDestino) throws DistanciaExcedidaException, ImposibleMoverseCasilleroOcupadoException {
        if (!casilleroDestino.getAlgoformer().equals(NoOcupado.getInstance()))
            throw new ImposibleMoverseCasilleroOcupadoException();
        int distancia = this.casilleroActual.getPosicion().obtenerDistanciaHasta(casilleroDestino.getPosicion());
        if (distancia > this.movimientosRestantes)
            throw new DistanciaExcedidaException();
        this.movimientosRestantes -= (distancia * costoMovimiento());
        casilleroDestino.setAlgoformer(this.casilleroActual.getAlgoformer());
        this.casilleroActual.setAlgoformer(NoOcupado.getInstance());
        this.casilleroActual = casilleroDestino;
    }

    private int costoMovimiento() {
        return ((velocidadOriginal == casilleroActual.getAlgoformer().getVelocidad()) ? 1 : 2);
    }

    public boolean quedanMovimientos() {
        return movimientosRestantes > (costoMovimiento() - 1);
    }
}
