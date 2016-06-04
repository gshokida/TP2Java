package fiuba.algo3.algoformers.modelo.Escenario.Contenidos;

import fiuba.algo3.algoformers.modelo.Errores.AtaqueAChispaSupremaNoValidoException;
import fiuba.algo3.algoformers.modelo.Escenario.Contenido;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;

/**
 * Created by Rodrigo on 01/06/2016.
 */
public class ChispaSuprema implements Contenido{

    private static ChispaSuprema unicaInstancia = new ChispaSuprema();

    private ChispaSuprema() {

    }


    public static Contenido getInstance(){
        return unicaInstancia;
    }


    public boolean esLaChispaSuprema(Contenido contenido){
        return this.equals(contenido);
    }

    @Override
    public void recibirAtaque(int puntosDeAtaque, Bando bandoAtacante) throws AtaqueAChispaSupremaNoValidoException {
        throw new AtaqueAChispaSupremaNoValidoException();
    }
}
