package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Errores.AtaqueAChispaSupremaNoValidoException;
import fiuba.algo3.algoformers.modelo.Errores.AtaqueAContenidoVacioNoValidoException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ChispaSuprema;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Familia on 04/06/2016.
 */
public class ChispaSupremaTest {
    @Test
    public void chispaSuprema_recibirAtaqueDeBandoAutobots_lanzaError() {
        Contenido chispaSuprema = ChispaSuprema.getInstance();
        int puntosDeAtaque = 10;
        Bando bandoAtacante = BandoAutobots.getInstance();

        try {
            chispaSuprema.recibirAtaque(puntosDeAtaque, bandoAtacante);
            fail();
        }
        catch (AtaqueAChispaSupremaNoValidoException error) {
            success();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        }
        catch (AtaqueAContenidoVacioNoValidoException error) {
            fail();
        }
    }

    @Test
    public void chispaSuprema_recibirAtaqueDeBandoDecepticons_lanzaError() {
        Contenido chispaSuprema = ChispaSuprema.getInstance();
        int puntosDeAtaque = 10;
        Bando bandoAtacante = BandoDecepticons.getInstance();

        try {
            chispaSuprema.recibirAtaque(puntosDeAtaque, bandoAtacante);
            fail();
        }
        catch (AtaqueAChispaSupremaNoValidoException error) {
            success();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        }
        catch (AtaqueAContenidoVacioNoValidoException error) {
            fail();
        }
    }

    private void success() {
        assertTrue(true);
    }
}