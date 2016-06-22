package fiuba.algo3.algoformers.view2.Utilidades;


import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import javafx.scene.control.Button;

/**
 * Created by Rodrigo on 15/06/2016.
 */
public class Baldosa extends Button {

    Posicion posicion;
    Button baldosa;


    public Baldosa(int x, int y){
        baldosa = new Button();
        String style = "boton";
        baldosa.setId(style);
        baldosa.setMinSize(48, 48);
        baldosa.setMaxSize(48, 48);
        posicion = new Posicion(x,y);
    }


    public Button getBaldosa (){

        return baldosa;

    }


    public void setEstilo(String estilo) {

        baldosa.setId(estilo);


    }

    public Posicion getPosicion() {

        return  posicion;

    }
}
