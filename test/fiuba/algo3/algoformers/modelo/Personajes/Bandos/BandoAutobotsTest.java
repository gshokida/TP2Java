package fiuba.algo3.algoformers.modelo.Personajes.Bandos;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Hennico on 29/5/2016.
 */
public class BandoAutobotsTest {
    @Test
    public void bandoAutobot_esMismoBandoQue_bandoAutobot() {
        Bando bando = BandoAutobots.getInstance();

        assertTrue(bando.esMismoBando(BandoAutobots.getInstance()));
    }

    @Test
    public void bandoAutobot_noEsMismoBandoQue_bandoDecepticon() {
        Bando bando = BandoAutobots.getInstance();

        assertTrue(!bando.esMismoBando(BandoDecepticons.getInstance()));
    }
}