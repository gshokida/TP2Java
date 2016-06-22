package fiuba.algo3.algoformers.view2.VistaJuego;

import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;

/**
 * Created by Rodrigo on 21/06/2016.
 */
public class PosicionOriginal {

    private AlgoFormer algoFormer;
    private Posicion posicion;

    public PosicionOriginal(){

        algoFormer = NoOcupado.getInstance();
        posicion = new Posicion(0, 0);

    }

    public void setPosicion(Posicion posicion){
        this.posicion = posicion;

    }

    public void setAlgoFormer(AlgoFormer algoFormer){

        this.algoFormer = algoFormer;

    }

    public Posicion getPosicion(){
        return posicion;

    }

    public AlgoFormer getAlgoFormer(){

       return  algoFormer;

    }


}
