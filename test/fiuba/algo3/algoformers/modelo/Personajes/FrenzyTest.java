package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaEntreAlgoFormersExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bonecrusher;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Frenzy;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class FrenzyTest {
    @Test
    public void nuevaInstancia_nombre_valeBumblebee() {
        Frenzy algoFormer = new Frenzy();

        assertEquals(algoFormer.getNombre(), "Frenzy");
    }

    @Test
    public void nuevaInstancia_puntosDeVida_valeCuatrocientos() {
        Frenzy algoFormer = new Frenzy();

        assertEquals(algoFormer.getPuntosDeVida(), 400);
    }

    @Test
    public void nuevaInstancia_ataque_valeDies() {
        Frenzy algoFormer = new Frenzy();

        assertEquals(algoFormer.getAtaque(), 10);
    }

    @Test
    public void nuevaInstancia_distanciaDeAtaque_valeCinco() {
        Frenzy algoFormer = new Frenzy();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 5);
    }

    @Test
    public void nuevaInstancia_velocidad_valeDos() {
        Frenzy algoFormer = new Frenzy();

        assertEquals(algoFormer.getVelocidad(), 2);
    }

    @Test
    public void cambiarModo_unaVez_dejaVidaEnCuatrocientos() {
        Frenzy algoFormer = new Frenzy();

        algoFormer.transformar();

        assertEquals(algoFormer.getPuntosDeVida(), 400);
    }

    @Test
    public void cambiarModo_unaVez_cambiaAtaqueADies() {
        Frenzy algoFormer = new Frenzy();

        algoFormer.transformar();

        assertEquals(algoFormer.getAtaque(), 25);
    }

    @Test
    public void cambiarModo_unaVez_cambiaDistanciaDeAtaqueADos() {
        Frenzy algoFormer = new Frenzy();

        algoFormer.transformar();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 2);
    }

    @Test
    public void cambiarModo_unaVez_cambiaVelocidadASeis() {
        Frenzy algoFormer = new Frenzy();

        algoFormer.transformar();

        assertEquals(algoFormer.getVelocidad(), 6);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaAtaqueADies() {
        Frenzy algoFormer = new Frenzy();

        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getAtaque(), 10);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaDistanciaDeAtaqueACinco() {
        Frenzy algoFormer = new Frenzy();

        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 5);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaVelocidadADos() {
        Frenzy algoFormer = new Frenzy();

        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getVelocidad(), 2);
    }

    @Test
    public void cambiarModo_TresVeces_cambiaVelocidadASeis() {
        Frenzy algoFormer = new Frenzy();

        algoFormer.transformar();
        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getVelocidad(), 6);
    }

    @Test
    public void nuevaInstancia_tipoUnidad_esTerrestre() {
        Frenzy algoFormer = new Frenzy();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void cambiarModo_tipoUnidad_esTerrestre() {
        Frenzy algoFormer = new Frenzy();

        algoFormer.transformar();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void atacar_restaVidaDeEnemigo_elValorDeAtaque() {
        Frenzy frenzy = new Frenzy();
        Optimus optimus = new Optimus();
        int vidaInicialOptimus = optimus.getPuntosDeVida();

        Posicion posicionOptimus = new Posicion(1, 1);
        Posicion posicionFrenzy = new Posicion(2, 2);

        optimus.setPosicion(posicionOptimus);
        frenzy.setPosicion(posicionFrenzy);

        try {
            frenzy.atacar(optimus);
        } catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        } catch (DistanciaEntreAlgoFormersExcedidaException e) {
            fail();
        }

        assertEquals(optimus.getPuntosDeVida(), vidaInicialOptimus - frenzy.getAtaque());
    }

    @Test
    public void atacar_cuandoLaUnidadEsUnAliado_daError () {
        Frenzy frenzy = new Frenzy();
        Bonecrusher bonecrusher = new Bonecrusher();

        try {
            frenzy.atacar(bonecrusher);
            fail();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            success();
        } catch (DistanciaEntreAlgoFormersExcedidaException e) {
            fail();
        }
    }

    private void success() {
        assertTrue(true);
    }
}