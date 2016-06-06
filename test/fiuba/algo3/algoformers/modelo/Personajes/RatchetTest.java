package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Ratchet;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadAerea;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RatchetTest {
    @Test
    public void nuevaInstancia_nombre_valeBumblebee() {
        Ratchet algoFormer = new Ratchet();

        assertEquals(algoFormer.getNombre(), "Ratchet");
    }

    @Test
    public void nuevaInstancia_distanciaDeAtaque_valeCinco() {
        Ratchet algoFormer = new Ratchet();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 5);
    }

    @Test
    public void nuevaInstancia_velocidad_valeUno() {
        Ratchet algoFormer = new Ratchet();

        assertEquals(algoFormer.getVelocidad(), 1);
    }

    @Test
    public void nuevaInstancia_puntosDeVida_valeCientoCincuenta() {
        Ratchet algoFormer = new Ratchet();

        assertEquals(algoFormer.getPuntosDeVida(), 150, 0D);
    }

    @Test
    public void nuevaInstancia_ataque_valeCinco() {
        Ratchet algoFormer = new Ratchet();

        assertEquals(algoFormer.getAtaque(), 5);
    }

    @Test
    public void cambiarModo_unaVez_dejaVidaEnCientoCincuenta() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();

        assertEquals(algoFormer.getPuntosDeVida(), 150, 0D);
    }

    @Test
    public void cambiarModo_unaVez_cambiaAtaqueATreintaYCinco() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();

        assertEquals(algoFormer.getAtaque(), 35);
    }

    @Test
    public void cambiarModo_unaVez_cambiaDistanciaDeAtaqueADos() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 2);
    }

    @Test
    public void cambiarModo_unaVez_cambiaVelocidadAOcho() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();

        assertEquals(algoFormer.getVelocidad(), 8);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaDistanciaDeAtaqueACinco() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getDistanciaDeAtaque(), 5);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaAtaqueACinco() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getAtaque(), 5);
    }

    @Test
    public void cambiarModo_DosVeces_cambiaVelocidadAUno() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getVelocidad(), 1);
    }

    @Test
    public void cambiarModo_TresVeces_cambiaVelocidadAOcho() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();
        algoFormer.transformar();
        algoFormer.transformar();

        assertEquals(algoFormer.getVelocidad(), 8);
    }

    @Test
    public void nuevaInstancia_tipoUnidad_esTerrestre() {
        Ratchet algoFormer = new Ratchet();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.getInstance()));
    }

    @Test
    public void cambiarModo_tipoUnidad_esAerea() {
        Ratchet algoFormer = new Ratchet();

        algoFormer.transformar();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadAerea.getInstance()));
    }

    @Test
    public void recibirAtaqueDeBandoEnemigo_restaVida_elValorDeAtaque() {
        Ratchet ratchet = new Ratchet();
        double vidaInicialRatchet = ratchet.getPuntosDeVida();
        int puntosDeAtaque = 10;

        ratchet.recibirAtaque(puntosDeAtaque);

        assertEquals(ratchet.getPuntosDeVida(), vidaInicialRatchet - puntosDeAtaque, 0D);
    }
}