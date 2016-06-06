package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Bonecrusher;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.ModoAlterno;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BonecrusherTest {
    @Test
    public void nuevaInstancia_nombre_valeBumblebee() {
        Bonecrusher algoFormer = new Bonecrusher();

        assertEquals(algoFormer.getNombre(), "Bonecrusher");
    }

    @Test
    public void nuevaInstancia_puntosDeVida_valeDoscientos() {
        Bonecrusher algoFormer = new Bonecrusher();

        assertEquals(algoFormer.getPuntosDeVida(), 200, 0D);
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

        assertEquals(algoFormer.getPuntosDeVida(), 200, 0D);
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
    public void cambiarModo_modo_esModoAlterno() {
        Bonecrusher algoFormer = new Bonecrusher();

        algoFormer.transformar();

        assertTrue(algoFormer.esModo(ModoAlterno.getInstance()));
    }

    @Test
    public void recibirAtaqueDeBandoEnemigo_restaVida_elValorDeAtaque() {
        Bonecrusher bonecrusher = new Bonecrusher();
        double vidaInicialBonecrusher = bonecrusher.getPuntosDeVida();
        int puntosDeAtaque = 10;

        bonecrusher.recibirAtaque(puntosDeAtaque);

        assertEquals(bonecrusher.getPuntosDeVida(), vidaInicialBonecrusher - puntosDeAtaque, 0D);
    }
}