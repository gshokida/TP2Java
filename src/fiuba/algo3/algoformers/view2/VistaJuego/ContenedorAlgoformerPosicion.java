package fiuba.algo3.algoformers.view2.VistaJuego;

import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rodrigo on 21/06/2016.
 */
public class ContenedorAlgoformerPosicion {

    private AlgoFormer algoFormer;
    private Posicion posicion;
    private List<Paneles> listaPaneles;

    public ContenedorAlgoformerPosicion(){

        algoFormer = NoOcupado.getInstance();
        posicion = new Posicion(0, 0);
        listaPaneles = new LinkedList<>();

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

    public void setPaneles (Paneles panel){

        listaPaneles.add(panel);

    }


    public void actualizarAlgoformer() {

        if (!listaPaneles.isEmpty()){

            for (Paneles panel : listaPaneles){

                panel.actualizarAlgoformers(algoFormer);

            }

        }


    }
}
