package fiuba.algo3.algoformers.view2.Utilidades;


import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.view2.VistaJuego.Estilos.Imagenes.ImageHelper;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * Created by Rodrigo on 15/06/2016.
 */
public class Baldosa extends Button {

    private Posicion posicion;
    private Button baldosa;
    private Pane fondo;


    public Baldosa(int x, int y){


        baldosa = new Button();
        fondo = new Pane();

                baldosa.setMinSize(48, 48);
        baldosa.setMaxSize(48, 48);
        baldosa.setBackground(new Background(new ImageHelper().getImagen("invisible")));
        fondo.setBackground(new Background(new ImageHelper().getImagen("tierra")));
        fondo.getChildren().addAll(baldosa);

        posicion = new Posicion(x,y);


    }


    public Button getBaldosa (){

        return baldosa;

    }

    public Pane getFondo (){

        return fondo;

    }


    public void setImagen(String estilo) {


        baldosa.setBackground(new Background(new ImageHelper().getImagen(estilo)));


    }


    public  void setFondo (String fondo){

        this.fondo.setBackground(new Background(new ImageHelper().getImagen(fondo)));

    }

    public Posicion getPosicion() {

        return  posicion;

    }
}
