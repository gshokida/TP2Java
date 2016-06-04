package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Errores.AtaqueAChispaSupremaNoValidoException;
import fiuba.algo3.algoformers.modelo.Errores.AtaqueAContenidoVacioNoValidoException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Familia on 04/06/2016.
 */
public class ContenidoVacioTest {
    @Test
    public void contenidoVacio_recibirAtaqueDeBandoAutobots_lanzaError() {
        Contenido contenidoVacio = ContenidoVacio.getInstance();
        int puntosDeAtaque = 10;
        Bando bandoAtacante = BandoAutobots.getInstance();

        try {
            contenidoVacio.recibirAtaque(puntosDeAtaque, bandoAtacante);
            fail();
        }
        catch (AtaqueAContenidoVacioNoValidoException error) {
            success();
        }
        catch (AtaqueAChispaSupremaNoValidoException error) {
            fail();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        }
    }

    @Test
    public void chispaSuprema_recibirAtaqueDeBandoDecepticons_lanzaError() {
        Contenido contenidoVacio = ContenidoVacio.getInstance();
        int puntosDeAtaque = 10;
        Bando bandoAtacante = BandoDecepticons.getInstance();

        try {
            contenidoVacio.recibirAtaque(puntosDeAtaque, bandoAtacante);
            fail();
        }
        catch (AtaqueAContenidoVacioNoValidoException error) {
            success();
        }
        catch (AtaqueAChispaSupremaNoValidoException error) {
            fail();
        }
        catch (NoSePermiteElFuegoAmistosoException error) {
            fail();
        }
    }

    private void success() {
        assertTrue(true);
    }
}