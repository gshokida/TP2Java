package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Frenzy;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FrenzyTest {
    @Test
    public void nuevaInstancia_nombre_valeBumblebee() {
        Frenzy algoFormer = new Frenzy();

        assertEquals(algoFormer.getNombre(), "Frenzy");
    }

    @Test
    public void nuevaInstancia_puntosDeVida_valeCuatrocientos() {
        Frenzy algoFormer = new Frenzy();

        assertEquals(algoFormer.getPuntosDeVida(), 400, 0D);
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

        assertEquals(algoFormer.getPuntosDeVida(), 400, 0D);
    }

    @Test
    public void cambiarModo_unaVez_cambiaAtaqueAVeinticinco() {
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

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.getInstance()));
    }

    @Test
    public void cambiarModo_tipoUnidad_esTerrestre() {
        Frenzy algoFormer = new Frenzy();

        algoFormer.transformar();

        assertTrue(algoFormer.esTipoUnidad(TipoUnidadTerrestre.getInstance()));
    }

    @Test
    public void recibirAtaqueDeBandoEnemigo_restaVida_elValorDeAtaque() {
        Frenzy frenzy = new Frenzy();
        double vidaInicialFrenzy = frenzy.getPuntosDeVida();
        int puntosDeAtaque = 10;

        frenzy.recibirAtaque(puntosDeAtaque);

        assertEquals(frenzy.getPuntosDeVida(), vidaInicialFrenzy - puntosDeAtaque, 0D);
    }
}