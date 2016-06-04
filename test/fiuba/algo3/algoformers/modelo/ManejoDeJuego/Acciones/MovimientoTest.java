package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gaston.tulipani on 03/06/2016.
 */
public class MovimientoTest {
    @Test
    public void moverHasta_conCasilleroDestinoADistanciaMenorALaDistanciaMaxima_poneConenidoEnDestino() {
        int distanciaMaxima = 5;
        AlgoFormer algoFormer = new Optimus();

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaMaxima - 1,0));

        casilleroOrigen.setContenido(algoFormer);

        Movimiento movimiento = new Movimiento(casilleroOrigen, distanciaMaxima);

        try {
            movimiento.moverHasta(casilleroDestino);
        }
        catch (DistanciaExcedidaException ex) {
            fail();
        }

        assertEquals(casilleroDestino.getContenido(), algoFormer);
    }

    @Test
    public void moverHasta_conCasilleroDestinoADistanciaMenorALaDistanciaMaxima_vaciaPrimerCasillero() {
        int distanciaMaxima = 5;
        AlgoFormer algoFormer = new Optimus();

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaMaxima - 1,0));

        casilleroOrigen.setContenido(algoFormer);
        Movimiento movimiento = new Movimiento(casilleroOrigen, distanciaMaxima);

        try {
            movimiento.moverHasta(casilleroDestino);
        }
        catch (DistanciaExcedidaException ex) {
            fail();
        }

        assertEquals(casilleroOrigen.getContenido(), ContenidoVacio.getInstance());
    }


    @Test
    public void moverHasta_conCasilleroDestinoADistanciaMayorALaDistanciaMaxima_lanzaError() {
        int distanciaMaxima = 5;

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaMaxima + 1,0));

        Movimiento movimiento = new Movimiento(casilleroOrigen, distanciaMaxima);

        try {
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (DistanciaExcedidaException ex) {
            succes();
        }
    }

    @Test
    public void moverHasta_haciendoVariasEscalas_superandoDistanciaMaximaDesdeOrigenHastaDestinoFinal_lanzaError() {
        int distanciaMaxima = 5;

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestinoIntermedio = new Casillero(new Posicion(2,0));
        Casillero casilleroDestinoFinal = new Casillero(new Posicion(distanciaMaxima + 1, 0));

        Movimiento movimiento = new Movimiento(casilleroOrigen, distanciaMaxima);

        try {
            movimiento.moverHasta(casilleroDestinoIntermedio);
        }
        catch (DistanciaExcedidaException error) {
            fail();
        }

        try {
            movimiento.moverHasta(casilleroDestinoFinal);
            fail();
        }
        catch (DistanciaExcedidaException ex) {
            succes();
        }
    }

    @Test
    public void nuevoMovimiento_quedanMovimientos_esVerdadero(){
        int distanciaMaxima = 5;

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Movimiento movimiento = new Movimiento(casilleroOrigen, distanciaMaxima);

        assertTrue(movimiento.quedanMovimientos());
    }

    @Test
    public void quedanMovimientos_cuandoSeMovioDistanciaMenorAMaxima_esVerdadero() {
        int distanciaMaxima = 5;

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaMaxima - 1,0));

        Movimiento movimiento = new Movimiento(casilleroOrigen, distanciaMaxima);

        try {
            movimiento.moverHasta(casilleroDestino);
        }
        catch (DistanciaExcedidaException error) {
            fail();
        }

        assertTrue(movimiento.quedanMovimientos());
    }

    @Test
    public void quedanMovimientos_cuandoSeMovioDistanciaMaxima_esFalso() {
        int distanciaMaxima = 5;

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaMaxima,0));

        Movimiento movimiento = new Movimiento(casilleroOrigen, distanciaMaxima);

        try {
            movimiento.moverHasta(casilleroDestino);
        }
        catch (DistanciaExcedidaException error) {
            fail();
        }

        assertFalse(movimiento.quedanMovimientos());
    }

    private void succes() {
        assertTrue(true);
    }
}
