package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.AtaqueAChispaSupremaNoValidoException;
import fiuba.algo3.algoformers.modelo.Errores.AtaqueAContenidoVacioNoValidoException;
import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ChispaSuprema;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bumblebee;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gaston.tulipani on 03/06/2016.
 */
public class AtaqueTest {
    @Test
    public void atacarA_conCasilleroDestinoConAlgoFormer_ADistanciaMenorALaDistanciaMaxima_restaVidaDelAlgoFormerAtacado() {
        AlgoFormer algoFormerAtacante = new Optimus();
        AlgoFormer algoFormerAtacado = new Megatron();
        int distanciaDeAtaqueMaxima = 5;
        int puntosDeAtaque = 10;
        int puntosDeVidaInicial = algoFormerAtacado.getPuntosDeVida();

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaDeAtaqueMaxima - 1,0));

        casilleroOrigen.setContenido(algoFormerAtacante);
        casilleroDestino.setContenido(algoFormerAtacado);

        Ataque ataque = new Ataque(casilleroOrigen, distanciaDeAtaqueMaxima, puntosDeAtaque, algoFormerAtacante.getBando());

        try {
            ataque.atacarA(casilleroDestino);
        }
        catch (DistanciaExcedidaException error) {
            fail();
        }
        catch (AtaqueAContenidoVacioNoValidoException error) {
            fail();
        }
        catch (AtaqueAChispaSupremaNoValidoException error) {
            fail();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        }

        assertEquals(algoFormerAtacado.getPuntosDeVida(), puntosDeVidaInicial - puntosDeAtaque);
    }

    @Test
    public void atacarA_conCasilleroDestinoConAlgoFormer_ADistanciaMayorALaDistanciaMaxima_lanzaError() {
        AlgoFormer algoFormerAtacante = new Optimus();
        AlgoFormer algoFormerAtacado = new Megatron();
        int distanciaDeAtaqueMaxima = 5;
        int puntosDeAtaque = 10;

        Casillero casilleroOrigen = new Casillero(new Posicion(0, 0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaDeAtaqueMaxima + 1, 0));

        casilleroOrigen.setContenido(algoFormerAtacante);
        casilleroDestino.setContenido(algoFormerAtacado);

        Ataque ataque = new Ataque(casilleroOrigen, distanciaDeAtaqueMaxima, puntosDeAtaque, algoFormerAtacante.getBando());
        try {
            ataque.atacarA(casilleroDestino);
            fail();
        }
        catch (DistanciaExcedidaException error) {
            succes();
        }
        catch (AtaqueAContenidoVacioNoValidoException error) {
            fail();
        }
        catch (AtaqueAChispaSupremaNoValidoException error) {
            fail();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        }
    }

    @Test
    public void atacarA_conCasilleroDestinoConContenidoVacio_lanzaError() {
        AlgoFormer algoFormerAtacante = new Optimus();
        int distanciaDeAtaqueMaxima = 5;
        int puntosDeAtaque = 10;

        Casillero casilleroOrigen = new Casillero(new Posicion(0, 0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaDeAtaqueMaxima - 1, 0));

        casilleroOrigen.setContenido(algoFormerAtacante);

        Ataque ataque = new Ataque(casilleroOrigen, distanciaDeAtaqueMaxima, puntosDeAtaque, algoFormerAtacante.getBando());
        try {
            ataque.atacarA(casilleroDestino);
            fail();
        }
        catch (DistanciaExcedidaException error) {
            fail();
        }
        catch (AtaqueAContenidoVacioNoValidoException error) {
            succes();
        }
        catch (AtaqueAChispaSupremaNoValidoException error) {
            fail();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        }
    }

    @Test
    public void atacarA_conCasilleroDestinoConChispaSuprema_lanzaError() {
        AlgoFormer algoFormerAtacante = new Optimus();
        int distanciaDeAtaqueMaxima = 5;
        int puntosDeAtaque = 10;

        Casillero casilleroOrigen = new Casillero(new Posicion(0, 0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaDeAtaqueMaxima - 1, 0));

        casilleroOrigen.setContenido(algoFormerAtacante);
        casilleroDestino.setContenido(ChispaSuprema.getInstance());

        Ataque ataque = new Ataque(casilleroOrigen, distanciaDeAtaqueMaxima, puntosDeAtaque, algoFormerAtacante.getBando());
        try {
            ataque.atacarA(casilleroDestino);
            fail();
        }
        catch (DistanciaExcedidaException error) {
            fail();
        }
        catch (AtaqueAContenidoVacioNoValidoException error) {
            fail();
        }
        catch (AtaqueAChispaSupremaNoValidoException error) {
            succes();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        }
    }

    @Test
    public void atacarA_conCasilleroDestinoConAlgoFormerDelMismoBando_lanzaError() {
        AlgoFormer algoFormerAtacante = new Optimus();
        AlgoFormer algoFormerAtacado = new Bumblebee();
        int distanciaDeAtaqueMaxima = 5;
        int puntosDeAtaque = 10;

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaDeAtaqueMaxima - 1,0));

        casilleroOrigen.setContenido(algoFormerAtacante);
        casilleroDestino.setContenido(algoFormerAtacado);

        Ataque ataque = new Ataque(casilleroOrigen, distanciaDeAtaqueMaxima, puntosDeAtaque, algoFormerAtacante.getBando());

        try {
            ataque.atacarA(casilleroDestino);
        }
        catch (DistanciaExcedidaException error) {
            fail();
        }
        catch (AtaqueAContenidoVacioNoValidoException error) {
            fail();
        }
        catch (AtaqueAChispaSupremaNoValidoException error) {
            fail();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            succes();
        }
    }

    private void succes() {
        assertTrue(true);
    }
}