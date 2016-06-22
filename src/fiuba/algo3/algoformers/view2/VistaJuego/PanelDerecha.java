package fiuba.algo3.algoformers.view2.VistaJuego;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.view2.Control.ObservadorTurnoInformacion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by Rodrigo on 22/06/2016.
 */
public class PanelDerecha {

    private Label turnoNumero;
    private  Label juega;
    private VBox panelDerecha;


    public PanelDerecha (Juego juego){

        panelDerecha = new VBox(20);

        Label turnos = new Label("Turnos");
         turnoNumero = new Label("Turno"+juego.getControlDeTurnos().getNumeroTurno());
         juega = new Label("Juega: " +juego.getControlDeTurnos().getJugadorTurnoActual().getNombre());

        Button ayuda = new Button("Info");

        panelDerecha.setAlignment(Pos.CENTER);
        panelDerecha.setPadding(new Insets(0,20,0,0));
        panelDerecha.getChildren().addAll(turnos, turnoNumero, juega,ayuda);

        ObservadorTurnoInformacion observadorInformacion = new ObservadorTurnoInformacion(this);

        juego.getControlDeTurnos().agregarSubscriptor(observadorInformacion);


    }

    public VBox getPanelDerecha(){

        return panelDerecha;

    }

    public void actualizarPanel(String nombreJugadorActual, int numeroTurnoActual){

        turnoNumero.setText("Turno " +numeroTurnoActual);
        juega.setText("Juega: " + nombreJugadorActual);



    }




}
