package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Errores.AtaqueAChispaSupremaNoValidoException;
import fiuba.algo3.algoformers.modelo.Errores.AtaqueAContenidoVacioNoValidoException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;

/**
 * Created by german.shokida on 27/5/2016.
 */
public interface Contenido {
     boolean esLaChispaSuprema(Contenido contenido);

     void recibirAtaque(int puntosDeAtaque, Bando bandoAtacante) throws AtaqueAContenidoVacioNoValidoException, AtaqueAChispaSupremaNoValidoException, NoSePermiteElFuegoAmistosoException;
}
