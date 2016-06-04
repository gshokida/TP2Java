package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Accion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;

/**
 * Created by gaston.tulipani on 03/06/2016.
 */
public class Movimiento implements Accion {
    private int movimientosRestantes;
    private Casillero casilleroActual;

    public Movimiento(Casillero casilleroOrigen, int distanciaTotal) {
        this.movimientosRestantes = distanciaTotal;
        this.casilleroActual = casilleroOrigen;
    }

    public void moverHasta(Casillero casilleroDestino) throws DistanciaExcedidaException, ImposibleMoverseCasilleroOcupadoException {
        int distancia = casilleroActual.getPosicion().obtenerDistanciaHasta(casilleroDestino.getPosicion());
        if (distancia > movimientosRestantes)
            throw new DistanciaExcedidaException();

        if (!casilleroDestino.getAlgoformer().equals(NoOcupado.getInstance()))
            throw new ImposibleMoverseCasilleroOcupadoException();

        movimientosRestantes -= distancia;

        casilleroDestino.setContenido(casilleroActual.getContenido());
        casilleroActual.setContenido(ContenidoVacio.getInstance());
    }

    public boolean quedanMovimientos() {
        return movimientosRestantes > 0;
    }
}
