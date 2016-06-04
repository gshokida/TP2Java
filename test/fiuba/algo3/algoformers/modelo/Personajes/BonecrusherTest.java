package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bonecrusher;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
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

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.getInstance()));
    }

    @Test
    public void cambiarModo_tipoUnidad_esTerrestre() {
        Bonecrusher algoFormer = new Bonecrusher();

        algoFormer.transformar();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.getInstance()));
    }

    @Test
    public void recibirAtaqueDeBandoEnemigo_restaVida_elValorDeAtaque() {
        Bonecrusher bonecrusher = new Bonecrusher();
        Bando bandoBonecrusher = bonecrusher.getBando();
        Bando bandoEnemigo = ((bandoBonecrusher == BandoAutobots.getInstance()) ? BandoDecepticons.getInstance() : BandoAutobots.getInstance());
        int vidaInicialBonecrusher = bonecrusher.getPuntosDeVida();
        int puntosDeAtaque = 10;

        try {
            bonecrusher.recibirAtaque(puntosDeAtaque,bandoEnemigo);
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        }

        assertEquals(bonecrusher.getPuntosDeVida(), vidaInicialBonecrusher - puntosDeAtaque);
    }

    @Test
    public void recibirAtaqueDeMismoBando_lanzaError() {
        Bonecrusher bonecrusher = new Bonecrusher();
        Bando bandoBonecrusher = bonecrusher.getBando();
        int puntosDeAtaque = 10;

        try {
            bonecrusher.recibirAtaque(puntosDeAtaque,bandoBonecrusher);
            fail();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            success();
        }
    }

    private void success() {
        assertTrue(true);
    }
}