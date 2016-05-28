package fiuba.algo3.algoformers.modelo.Esenario;

import fiuba.algo3.algoformers.modelo.Esenario.Casillero;

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
        this.posxElementoMedio = x/2;
        this.posyElementoMedio = y/2;

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

    //Habria que inicializar todos los casilleros del tablero.


}
