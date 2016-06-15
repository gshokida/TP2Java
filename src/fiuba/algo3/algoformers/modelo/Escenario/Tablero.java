package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ChispaSuprema;
import fiuba.algo3.algoformers.modelo.Errores.TableroParInvalidoException;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.Contenido;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class Tablero {
    Casillero tablero [] [];
    int posx;
    int posy;

    public  Tablero (int filas, int columnas) {
        if (!((filas % 2 != 0) && (columnas % 2 != 0))) {
            throw new TableroParInvalidoException();
        }

        tablero = new Casillero[filas][columnas];
        posx = filas;
        posy = columnas;

        for(int i = 0; i < filas; i++)
            for(int j = 0; j < columnas; j++)
                tablero[i][j] = new Casillero(new Posicion(i,j));

        Posicion posicionChispaSuprema = new Posicion((filas - 1) / 2, (columnas - 1) / 2);

        setContenido(ChispaSuprema.getInstance(), posicionChispaSuprema);
    }

    public void setContenido(Contenido contenido, Posicion posicion) {
        tablero[posicion.getX()][posicion.getY()].setContenido(contenido);
    }

    public void setAlgoformer(AlgoFormer algoformer, Posicion posicion) {
        tablero[posicion.getX()][posicion.getY()].setAlgoformer(algoformer);
    }

    public Casillero getCasillero(Posicion posicion) {
        return tablero[posicion.getX()][posicion.getY()];
    }

    public boolean casilleroOcupado(Posicion posicion) {
        return (tablero[posicion.getX()][posicion.getY()].estaOcupado());
    }
}
