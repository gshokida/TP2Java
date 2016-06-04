package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ChispaSuprema;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bumblebee;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;
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
        int distanciaDeAtaqueMaxima = algoFormerAtacante.getDistanciaDeAtaque();
        int puntosDeAtaque = algoFormerAtacante.getAtaque();
        int puntosDeVidaInicial = algoFormerAtacado.getPuntosDeVida();

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaDeAtaqueMaxima - 1,0));

        casilleroOrigen.setAlgoformer(algoFormerAtacante);
        casilleroDestino.setAlgoformer(algoFormerAtacado);

        Ataque ataque = new Ataque(casilleroOrigen);

        try {
            ataque.atacarA(casilleroDestino);
        }
        catch (DistanciaExcedidaException | NoSePermiteElFuegoAmistosoException error) {
            fail();
        }

        assertEquals(algoFormerAtacado.getPuntosDeVida(), puntosDeVidaInicial - puntosDeAtaque);
    }

    @Test
    public void atacarA_conCasilleroDestinoConAlgoFormer_ADistanciaMayorALaDistanciaMaxima_lanzaError() {
        AlgoFormer algoFormerAtacante = new Optimus();
        AlgoFormer algoFormerAtacado = new Megatron();
        int distanciaDeAtaqueMaxima = algoFormerAtacante.getDistanciaDeAtaque();

        Casillero casilleroOrigen = new Casillero(new Posicion(0, 0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaDeAtaqueMaxima + 1, 0));

        casilleroOrigen.setAlgoformer(algoFormerAtacante);
        casilleroDestino.setAlgoformer(algoFormerAtacado);

        Ataque ataque = new Ataque(casilleroOrigen);
        try {
            ataque.atacarA(casilleroDestino);
            fail();
        }
        catch (DistanciaExcedidaException error) {
            succes();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        }
    }

    @Test
    public void atacarA_conCasilleroDestinoConContenidoVacio_noModificaAlgoFormeNoOcupado() {
        AlgoFormer algoFormerAtacante = new Optimus();
        int distanciaDeAtaqueMaxima = algoFormerAtacante.getDistanciaDeAtaque();

        Casillero casilleroOrigen = new Casillero(new Posicion(0, 0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaDeAtaqueMaxima - 1, 0));

        casilleroOrigen.setAlgoformer(algoFormerAtacante);

        Ataque ataque = new Ataque(casilleroOrigen);
        try {
            ataque.atacarA(casilleroDestino);
        }
        catch (DistanciaExcedidaException | NoSePermiteElFuegoAmistosoException error) {
            fail();
        }

        assertEquals(casilleroDestino.getAlgoformer(), NoOcupado.getInstance());
    }

    @Test
    public void atacarA_conCasilleroDestinoConContenidoVacio_noModificaContenidoVacio() {
        AlgoFormer algoFormerAtacante = new Optimus();
        int distanciaDeAtaqueMaxima = algoFormerAtacante.getDistanciaDeAtaque();

        Casillero casilleroOrigen = new Casillero(new Posicion(0, 0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaDeAtaqueMaxima - 1, 0));

        casilleroOrigen.setAlgoformer(algoFormerAtacante);

        Ataque ataque = new Ataque(casilleroOrigen);
        try {
            ataque.atacarA(casilleroDestino);
        }
        catch (DistanciaExcedidaException | NoSePermiteElFuegoAmistosoException error) {
            fail();
        }

        assertEquals(casilleroDestino.getContenido(), ContenidoVacio.getInstance());
    }

    @Test
    public void atacarA_conCasilleroDestinoConChispaSuprema_noModificaAlgoFormeNoOcupado() {
        AlgoFormer algoFormerAtacante = new Optimus();
        int distanciaDeAtaqueMaxima = algoFormerAtacante.getDistanciaDeAtaque();

        Casillero casilleroOrigen = new Casillero(new Posicion(0, 0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaDeAtaqueMaxima - 1, 0));

        casilleroOrigen.setAlgoformer(algoFormerAtacante);
        casilleroDestino.setContenido(ChispaSuprema.getInstance());

        Ataque ataque = new Ataque(casilleroOrigen);
        try {
            ataque.atacarA(casilleroDestino);
        }
        catch (DistanciaExcedidaException | NoSePermiteElFuegoAmistosoException error) {
            fail();
        }

        assertEquals(casilleroDestino.getAlgoformer(), NoOcupado.getInstance());
    }

    @Test
    public void atacarA_conCasilleroDestinoConChispaSuprema_noModificaChispaSuprema() {
        AlgoFormer algoFormerAtacante = new Optimus();
        int distanciaDeAtaqueMaxima = algoFormerAtacante.getDistanciaDeAtaque();

        Casillero casilleroOrigen = new Casillero(new Posicion(0, 0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaDeAtaqueMaxima - 1, 0));

        casilleroOrigen.setAlgoformer(algoFormerAtacante);
        casilleroDestino.setContenido(ChispaSuprema.getInstance());

        Ataque ataque = new Ataque(casilleroOrigen);
        try {
            ataque.atacarA(casilleroDestino);
        }
        catch (DistanciaExcedidaException | NoSePermiteElFuegoAmistosoException error) {
            fail();
        }

        assertEquals(casilleroDestino.getContenido(), ChispaSuprema.getInstance());
    }

    @Test
    public void atacarA_conCasilleroDestinoConAlgoFormerDelMismoBando_lanzaError() {
        AlgoFormer algoFormerAtacante = new Optimus();
        AlgoFormer algoFormerAtacado = new Bumblebee();
        int distanciaDeAtaqueMaxima = algoFormerAtacante.getDistanciaDeAtaque();

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaDeAtaqueMaxima - 1,0));

        casilleroOrigen.setAlgoformer(algoFormerAtacante);
        casilleroDestino.setAlgoformer(algoFormerAtacado);

        Ataque ataque = new Ataque(casilleroOrigen);

        try {
            ataque.atacarA(casilleroDestino);
        }
        catch (DistanciaExcedidaException error) {
            fail();
        } catch (NoSePermiteElFuegoAmistosoException error) {
            succes();
        }
    }

    private void succes() {
        assertTrue(true);
    }
}