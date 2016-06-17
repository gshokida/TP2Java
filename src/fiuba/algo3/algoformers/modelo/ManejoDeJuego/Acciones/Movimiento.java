package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.*;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Accion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidad;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAeronave;

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

    public void moverHasta(Casillero casilleroDestino) throws DistanciaExcedidaException, ImposibleMoverseCasilleroOcupadoException, HumanoideNoPuedeAtravesarPantanoException {
        if (!casilleroDestino.getAlgoformer().equals(NoOcupado.getInstance()))
            throw new ImposibleMoverseCasilleroOcupadoException();

        if (this.casilleroActual.getPosicion().obtenerDistanciaHasta(casilleroDestino.getPosicion()) > 1){
            throw new DistanciaExcedidaException();
        }

        int costoMovimiento;

        if(this.algoFormer.esTipoUnidad(new TipoUnidadAeronave()))
            costoMovimiento = casilleroDestino.getSuperficieAerea().obtenerCostoMovimiento();
        else
            costoMovimiento = casilleroDestino.getSuperficieTerreste().obtenerCostoMovimiento();

        if (costoMovimiento > this.getMovimientosRestantes())
            throw new DistanciaExcedidaException();

        this.totalMovimientos += costoMovimiento;

        casilleroDestino.setAlgoformer(this.casilleroActual.getAlgoformer());
        this.casilleroActual.setAlgoformer(NoOcupado.getInstance());
        this.casilleroActual = casilleroDestino;
    }

    private int getMovimientosRestantes(){
        return this.algoFormer.getVelocidad() - this.totalMovimientos;
    }

    public boolean quedanMovimientos() {
        return this.totalMovimientos < this.algoFormer.getVelocidad();
    }
}


