package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.AtaqueAChispaSupremaNoValidoException;
import fiuba.algo3.algoformers.modelo.Errores.AtaqueAContenidoVacioNoValidoException;
import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Accion;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;

/**
 * Created by gaston.tulipani on 04/06/2016.
 */
public class Ataque implements Accion {
    private Casillero casilleroOrigen;
    private int distanciaDeAtaqueMaxima;
    private int puntosDeAtaque;
    private Bando bandoAtacante;

    public Ataque(Casillero casilleroOrigen, int distanciaDeAtaqueMaxima, int puntosDeAtaque, Bando bandoAtacante) {
        this.casilleroOrigen = casilleroOrigen;
        this.distanciaDeAtaqueMaxima = distanciaDeAtaqueMaxima;
        this.puntosDeAtaque = puntosDeAtaque;
        this.bandoAtacante = bandoAtacante;
    }

    public void atacarA(Casillero casilleroDestino) throws DistanciaExcedidaException, AtaqueAContenidoVacioNoValidoException, AtaqueAChispaSupremaNoValidoException, NoSePermiteElFuegoAmistosoException {
        int distancia = casilleroOrigen.getPosicion().obtenerDistanciaHasta(casilleroDestino.getPosicion());
        if (distancia > distanciaDeAtaqueMaxima)
            throw new DistanciaExcedidaException();
        casilleroDestino.getContenido().recibirAtaque(puntosDeAtaque,bandoAtacante);
    }
}
