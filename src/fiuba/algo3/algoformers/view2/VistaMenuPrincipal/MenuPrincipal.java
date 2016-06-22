package fiuba.algo3.algoformers.view2.VistaMenuPrincipal;

import fiuba.algo3.algoformers.view2.Ventana;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


/**
 * Created by Rodrigo on 18/06/2016.
 */
public class MenuPrincipal implements Ventana {

    private Scene escena;
    private BorderPane border;


    public MenuPrincipal (){

        border = new BorderPane();

        Button pausa = new Button("PAUSA");
        Button continuar = new Button("CONTINUAR");

        HBox box = new HBox();
        box.setAlignment(Pos.BOTTOM_RIGHT);
        box.getChildren().addAll(pausa,continuar);

        border.setBottom(box);
        escena = new Scene(border, 1024, 900);


    }





    @Override
    public Scene getEscena() {
        return escena;
    }

    @Override
    public void agregarBoton(Button boton) {

        boton.setText("Nuevo Juego");
        border.setCenter(boton);

    }


}
