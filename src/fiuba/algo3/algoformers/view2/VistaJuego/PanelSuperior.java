package fiuba.algo3.algoformers.view2.VistaJuego;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by Rodrigo on 20/06/2016.
 */
public class PanelSuperior {

    private Label jugador1;
    private Label jugador2;
    private HBox panelSuperior;

    public PanelSuperior (){

        jugador1 = new Label();

        jugador2 = new Label();

        panelSuperior = new HBox(266);

        panelSuperior.setPadding(new Insets(40,0,0,0));

        panelSuperior.getChildren().addAll(jugador1,jugador2);

        panelSuperior.setAlignment(Pos.CENTER);

    }

    public HBox getPanelSuperior(){

        return panelSuperior;

    }


    public void setJugador1(Jugador jugador1) {

        //Crear getter de Nombres para Jugador 1 y Jugador 2
        this.jugador1.setText(jugador1.getNombre());

    }

    public void setJugador2(Jugador jugador2) {

        this.jugador2.setText(jugador2.getNombre());

    }



}
