package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Accion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by gaston.tulipani on 03/06/2016.
 */
public class Movimiento implements Accion {
    public Movimiento(AlgoFormer algoFormer, Posicion posicionDestino) throws DistanciaExcedidaException {
        if (algoFormer.getPosicion().obtenerDistanciaHasta(posicionDestino) > algoFormer.getVelocidad())
            throw new DistanciaExcedidaException();
        algoFormer.setPosicion(posicionDestino);
    }
}