package fiuba.algo3.algoformers.modelo.Personajes.Bandos;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Hennico on 29/5/2016.
 */
public class BandoDecepticonsTest {
    @Test
    public void bandoDecepticons_esMismoBandoQue_bandoDecepticons() {
        Bando bando = BandoDecepticons.getInstance();

        assertTrue(bando.esMismoBando(BandoDecepticons.getInstance()));
    }

    @Test
    public void bandoDecepticons_noEsMismoBandoQue_bandoAutobots() {
        Bando bando = BandoDecepticons.getInstance();

        assertTrue(!bando.esMismoBando(BandoAutobots.getInstance()));
    }
}