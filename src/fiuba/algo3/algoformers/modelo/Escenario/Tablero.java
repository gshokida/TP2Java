package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Contenidos.HoloSpark;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Optimus;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class Tablero {

    Casillero tablero [] [];
    int posx;
    int posy;
    int posxElementoMedio;
    int posyElementoMedio;

    public  Tablero (int x, int y){

        this.tablero = new Casillero[x][y];
        this.posx = x;
        this.posy = y;
        this.posxElementoMedio = (x-1)/2;
        this.posyElementoMedio = (y-1)/2;

        for(int i = 0; i < x; i++)
            for(int j = 0; j < y; j++) {
                this.tablero[i][j] = new Casillero();
                this.tablero[i][j].setContenido(ContenidoVacio.getInstance());
            }

        this.setContenido(HoloSpark.instancia(), posxElementoMedio, posyElementoMedio);
    }


    public boolean tieneTamanio(int i) {

        return ((this.posx * this.posy)== i);

    }

    public int medio() {

        return (this.posxElementoMedio * this.posyElementoMedio);

    }


    public Casillero devolverElementoMedio (){

        return (this.tablero [this.posxElementoMedio] [this.posyElementoMedio]);

    }

    //METODO SOLO PARA TEST

    public void llenarCasilleroDelMedio ( Casillero casillero) {

        this.tablero [this.posxElementoMedio] [this.posyElementoMedio] = casillero;

    }


    public void setContenido(Contenido contenido, int x, int y) {

        this.tablero[x][y].setContenido(contenido);

    }

    public void setPersonaje(AlgoFormer algoFormer, int x, int y) {
        algoFormer.setPosicion(x,y);
        this.setContenido(algoFormer,x,y);
    }

    public Contenido getContenido(int x, int y) {

        return (tablero[x][y].getContenido());

    }

    public void moverPersonaje(AlgoFormer algoFormer, int posx, int posy) throws ImposibleMoverseCasilleroOcupadoException {
        if (tablero[posx][posy].estaOcupado())
            throw new ImposibleMoverseCasilleroOcupadoException();
        int posx_origen = algoFormer.getPosicionX();
        int posy_origen = algoFormer.getPosicionY();
        setPersonaje(algoFormer,posx,posy);
        tablero[posx_origen][posy_origen].setContenido(ContenidoVacio.getInstance());
    }


}
