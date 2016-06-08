package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseEfectoPresente;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Accion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;

/**
 * Created by gaston.tulipani on 03/06/2016.
 */
public class Movimiento implements Accion {
    private int movimientosRestantes;
    private Casillero casilleroActual;
    private int costoMoviemiento;

    public Movimiento(Casillero casilleroOrigen, int distanciaTotal) {
        this.movimientosRestantes = distanciaTotal;
        this.casilleroActual = casilleroOrigen;
        this.costoMoviemiento = 1;
    }


    public Movimiento(Casillero casilleroOrigen, int distanciaTotal, int costoDeMoviemiento) {
        this.movimientosRestantes = distanciaTotal;
        this.casilleroActual = casilleroOrigen;
        this.costoMoviemiento = costoDeMoviemiento;
    }



    public void moverHasta(Casillero casilleroDestino) throws DistanciaExcedidaException, ImposibleMoverseCasilleroOcupadoException, ImposibleMoverseEfectoPresente {
        if (!casilleroDestino.getAlgoformer().equals(NoOcupado.getInstance()))
            throw new ImposibleMoverseCasilleroOcupadoException();
        int distancia = casilleroActual.getPosicion().obtenerDistanciaHasta(casilleroDestino.getPosicion());
        if (distancia > movimientosRestantes)
            throw new DistanciaExcedidaException();
        if (!casilleroActual.getAlgoformer().sePuedeMover())
            throw new ImposibleMoverseEfectoPresente();
        movimientosRestantes -= (distancia*this.costoMoviemiento);

        casilleroDestino.setAlgoformer(casilleroActual.getAlgoformer());
        casilleroActual.setAlgoformer(NoOcupado.getInstance());
    }

    public boolean quedanMovimientos() {
        return movimientosRestantes > 0;
    }
}
