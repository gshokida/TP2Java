package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Accion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;

/**
 * Created by gaston.tulipani on 04/06/2016.
 */
public class Ataque implements Accion {
    private Casillero casilleroOrigen;

    public Ataque(Casillero casilleroOrigen) {
        this.casilleroOrigen = casilleroOrigen;
    }

    public void atacarA(Casillero casilleroDestino) throws DistanciaExcedidaException, NoSePermiteElFuegoAmistosoException {
        int distancia = casilleroOrigen.getPosicion().obtenerDistanciaHasta(casilleroDestino.getPosicion());

        if(!casilleroDestino.getAlgoformer().equals(NoOcupado.getInstance())) {
            if (distancia > casilleroOrigen.getAlgoformer().getDistanciaDeAtaque())
                throw new DistanciaExcedidaException();

            if (casilleroOrigen.getAlgoformer().getBando().esMismoBando(casilleroDestino.getAlgoformer().getBando()))
                throw new NoSePermiteElFuegoAmistosoException();

            // Se realiza el calculo con los bonus y/o efectos de las superficies
            casilleroDestino.getAlgoformer().recibirAtaque(casilleroOrigen.getAlgoformer().calcularAtaque());
        }
    }
}
