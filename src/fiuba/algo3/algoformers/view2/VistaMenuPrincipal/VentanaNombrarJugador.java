package fiuba.algo3.algoformers.view2.VistaMenuPrincipal;

import javafx.beans.binding.BooleanBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Rodrigo on 20/06/2016.
 */
public class VentanaNombrarJugador {


    private TextField nombreJugador1;
    private TextField nombreJugador2;
    private Boolean jugadoresFueronIngresados;


    public VentanaNombrarJugador (){
        nombreJugador1 = new TextField("Jugador 1");
        nombreJugador2 = new TextField("Jugador 2");
        jugadoresFueronIngresados = false;

    }


    public Boolean jugadoresFueronIngresados(){

        return jugadoresFueronIngresados;

    }



    public void display () {
        Stage ventana = new Stage();


        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Nombrar Jugadores");
        ventana.setMinWidth(500);

        Label label = new Label();
        label.setText("Ingresar Nombre Jugador 1");


        Label label2 = new Label();
        label2.setText("Ingresar Nombre Jugador 2");


        Button cerrar = new Button();
        cerrar.setText("Aceptar e Ir A Juego");
        cerrar.setOnAction(e -> {
            jugadoresFueronIngresados = true;
            ventana.close();
        });


        VBox box = new VBox(20);
        box.getChildren().addAll(label, nombreJugador1,label2,nombreJugador2,cerrar);
        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box);
        ventana.setScene(scene);
        ventana.showAndWait();

    }

    public String getNombreJugador1 (){

        return nombreJugador1.getText();

    }

    public String getNombreJugador2 (){

        return nombreJugador2.getText();

    }



}
