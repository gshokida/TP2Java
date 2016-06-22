package fiuba.algo3.algoformers.view2.VistaMenuPrincipal;

import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
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
    private ChoiceBox<String> tamanioMapa;
    private int columnas;
    private int filas;
    private final int DEFAULT = 7;


    public VentanaNombrarJugador (){

        nombreJugador1 = new TextField("Jugador 1");
        nombreJugador2 = new TextField("Jugador 2");
        tamanioMapa = new ChoiceBox<>(FXCollections.observableArrayList("5x5", "7x7","9x9"));
        columnas = DEFAULT;
        filas = DEFAULT;



        final int[] tamanio = new int [] {5, 7, 9};
        tamanioMapa.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue observable, Number oldValue, Number newValue) {

                columnas = tamanio[newValue.intValue()];
                filas = tamanio[newValue.intValue()];


            }
        });


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

        HBox hbox = new HBox(5);
        Label selecionarTamanio = new Label("Seleccionar Tamanio Mapa: ");

        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(selecionarTamanio, tamanioMapa);

        VBox box = new VBox(20);
        box.getChildren().addAll(label, nombreJugador1,label2,nombreJugador2, hbox, cerrar);
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


    public int getColumnas(){
        return columnas;
    }

    public int getFilas (){
        return filas;
    }


}
