package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaEntreAlgoFormersExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bonecrusher;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Frenzy;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BonecrusherTest {
    @Test
    public void nuevaInstancia_nombre_valeBumblebee() {
        Bonecrusher algoFormer = new Bonecrusher();

        assertEquals(algoFormer.getNombre(), "Bonecrusher");
    }

    @Test
    public void nuevaInstancia_puntosDeVida_valeDoscientos() {
        Bonecrusher algoFormer = new Bonecrusher();

        assertEquals(algoFormer.getPuntosDeVida(), 200);
    }

    @Test
    public void nuevaInstancia_ataque_valeTreinta() {
        Bonecrusher algoFormer = new Bonecrusher();

        assertEquals(algoFormer.getAtaque(), 30);
    }

    @Test
    public void nuevaInstancia_distanciaDeAtaque_valeTres() {
        Bonecrusher algoFormer = new Bonecrusher();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void nuevaInstancia_velocidad_valeUno() {
        Bonecrusher algoFormer = new Bonecrusher();

        assertEquals(algoFormer.getVelocidad(), 1);
    }

    @Test
    public void cambiarModo_unaVez_dejaVidaEnDoscientos() {
        Bonecrusher algoFormer = new Bonecrusher();

        algoFormer.transformar();

        assertEquals(algoFormer.getPuntosDeVida(), 200);
    }

    @Test
    public void cambiarModo_unaVez_cambiaAtaqueATreinta() {
        Bonecrusher algoFormer = new Bonecrusher();

        algoFormer.transformar();

        assertEquals(algoFormer.getAtaque(), 30);
    }

    @Test
    public void cambiarModo_unaVez_cambiaDistanciaDeAtaqueATres() {
        Bonecrusher algoFormer = new Bonecrusher();

        algoFormer.transformar();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void cambiarModo_unaVez_cambiaVelocidadAOcho() {
        Bonecrusher algoFormer = new Bonecrusher();

        algoFormer.transformar();

        assertEquals(algoFormer.getVelocidad(), 8);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaAtaqueATreinta() {
        Bonecrusher algoFormer = new Bonecrusher();

        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getAtaque(), 30);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaDistanciaDeAtaqueATres() {
        Bonecrusher algoFormer = new Bonecrusher();

        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 3);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaVelocidadAUno() {
        Bonecrusher algoFormer = new Bonecrusher();

        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getVelocidad(), 1);
    }

    @Test
    public void cambiarModo_TresVeces_cambiaVelocidadAOcho() {
        Bonecrusher algoFormer = new Bonecrusher();

        algoFormer.transformar();
        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getVelocidad(), 8);
    }

    @Test
    public void nuevaInstancia_tipoUnidad_esTerrestre() {
        Bonecrusher algoFormer = new Bonecrusher();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void cambiarModo_tipoUnidad_esTerrestre() {
        Bonecrusher algoFormer = new Bonecrusher();

        algoFormer.transformar();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void atacar_restaVidaDeEnemigo_elValorDeAtaque() {
        Bonecrusher bonecrusher = new Bonecrusher();
        Optimus optimus = new Optimus();
        int vidaInicialOptimus = optimus.getPuntosDeVida();

        try {
            bonecrusher.atacar(optimus);
        } catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        } catch (DistanciaEntreAlgoFormersExcedidaException e) {
            fail();
        }

        assertEquals(optimus.getPuntosDeVida(), vidaInicialOptimus - bonecrusher.getAtaque());
    }

    @Test
    public void atacar_cuandoLaUnidadEsUnAliado_daError () {
        Bonecrusher bonecrusher = new Bonecrusher();
        Frenzy frenzy = new Frenzy();

        try {
            bonecrusher.atacar(frenzy);
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