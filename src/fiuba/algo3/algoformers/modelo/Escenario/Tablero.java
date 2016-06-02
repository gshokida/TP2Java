package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Contenidos.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Contenidos.HoloSpark;
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
    int posxElementoMedio;
    int posyElementoMedio;

    public  Tablero (int filas, int columnas) {
        if (!((filas %2 != 0) && (columnas %2 != 0))) {
            throw new TableroParInvalidoException();
        }
        tablero = new Casillero[filas][columnas];
        posx = filas;
        posy = columnas;
        posxElementoMedio = (filas -1)/2;
        posyElementoMedio = (columnas -1)/2;
        for(int i = 0; i < filas; i++)
            for(int j = 0; j < columnas; j++) {
                tablero[i][j] = new Casillero();
                tablero[i][j].setContenido(ContenidoVacio.getInstance());
            }
        setContenido(HoloSpark.instancia(), posxElementoMedio, posyElementoMedio);
    }

    public boolean tieneTamanio(int i) {
        return ((posx * posy)== i);
    }

    public int medio() {
        return (posxElementoMedio * posyElementoMedio);
    }

    public Casillero devolverElementoMedio (){
        return (tablero [posxElementoMedio] [posyElementoMedio]);
    }
    //METODO SOLO PARA TEST

    public void llenarCasilleroDelMedio ( Casillero casillero) {
        tablero [posxElementoMedio] [posyElementoMedio] = casillero;
    }

    public void setContenido(Contenido contenido, int x, int y) {
        tablero[x][y].setContenido(contenido);
    }

    public void setPersonaje(AlgoFormer algoFormer, int x, int y) {
        algoFormer.setPosicion(x,y);
        setContenido(algoFormer,x,y);
    }

    public Contenido getContenido(int x, int y) {
        return (tablero[x][y].getContenido());
    }

    public void moverPersonaje(AlgoFormer algoFormer, int posx, int posy) throws ImposibleMoverseCasilleroOcupadoException {
        if (casilleroOcupado(posx,posy))
            throw new ImposibleMoverseCasilleroOcupadoException();
        int posx_origen = algoFormer.getPosicionX();
        int posy_origen = algoFormer.getPosicionY();
        setPersonaje(algoFormer,posx,posy);
        tablero[posx_origen][posy_origen].setContenido(ContenidoVacio.getInstance());
    }

    public boolean casilleroOcupado(int x, int y) {
        return (tablero[x][y].estaOcupado());
    }
}
