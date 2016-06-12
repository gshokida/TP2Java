package fiuba.algo3.algoformers.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PantallaPrincipal extends BorderPane {
    public PantallaPrincipal() {
        generarBotones();
    }

    private void generarBotones() {
        Button botonMover = new Button();
        botonMover.setText("Mover");

        VBox contenedorVertical = new VBox(botonMover);

        contenedorVertical.setAlignment(Pos.TOP_LEFT);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);
    }
}
