package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.HoloSpark;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Errores.TableroParInvalidoException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class Tablero {
    Casillero tablero [] [];
    int posx;
    int posy;

    public  Tablero (int filas, int columnas) {
        if (!((filas %2 != 0) && (columnas %2 != 0))) {
            throw new TableroParInvalidoException();
        }

        tablero = new Casillero[filas][columnas];
        posx = filas;
        posy = columnas;

        for(int i = 0; i < filas; i++)
            for(int j = 0; j < columnas; j++)
                tablero[i][j] = new Casillero(new Posicion(i,j));

        Posicion posicionHoloSpark = new Posicion((filas - 1) / 2, (columnas - 1) / 2);

        setContenido(HoloSpark.instancia(), posicionHoloSpark);
    }

    public void setContenido(Contenido contenido, Posicion posicion) {
        tablero[posicion.getX()][posicion.getY()].setContenido(contenido);
    }

    public void setPersonaje(AlgoFormer algoFormer, Posicion posicion) {
        algoFormer.setPosicion(posicion);
        setContenido(algoFormer, posicion);
    }

    public Casillero getCasillero(Posicion posicion) {
        return tablero[posicion.getX()][posicion.getY()];
    }

    public void moverPersonaje(AlgoFormer algoFormer, Posicion nuevaPosicion) throws ImposibleMoverseCasilleroOcupadoException {
        if (casilleroOcupado(nuevaPosicion))
            throw new ImposibleMoverseCasilleroOcupadoException();

        Posicion posicionOrigen = algoFormer.getPosicion();
        setPersonaje(algoFormer, nuevaPosicion);

        tablero[posicionOrigen.getX()][posicionOrigen.getY()].setContenido(ContenidoVacio.getInstance());
    }

    public boolean casilleroOcupado(Posicion posicion) {
        return (tablero[posicion.getX()][posicion.getY()].estaOcupado());
    }
}
