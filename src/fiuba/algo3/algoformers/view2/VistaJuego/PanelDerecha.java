package fiuba.algo3.algoformers.view2.VistaJuego;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by Rodrigo on 22/06/2016.
 */
public class PanelDerecha {

    private VBox panelDerecha;


    public PanelDerecha (Juego juego){

        panelDerecha = new VBox(20);

        Label label = new Label("Turnos");
        Label label1 = new Label("Turno"+juego.getControlDeTurnos().getNumeroTurno());
        Label label2 = new Label("Juega:" +juego.getControlDeTurnos().getJugadorTurnoActual().getNombre());

        Button ayuda = new Button("Info");

        panelDerecha.setAlignment(Pos.CENTER);
        panelDerecha.getChildren().addAll(label, label1, label2,ayuda);


    }

    public VBox getPanelDerecha(){

        return panelDerecha;

    }
}
