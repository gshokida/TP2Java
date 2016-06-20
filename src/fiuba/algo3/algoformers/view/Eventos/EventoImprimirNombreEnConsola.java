package fiuba.algo3.algoformers.view.Eventos;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by Hennico on 12/6/2016.
 */
public class EventoImprimirNombreEnConsola implements EventHandler<MouseEvent> {
    private String nombre;

    public EventoImprimirNombreEnConsola(String nombre) {
        this.nombre = nombre;
    }

    public void handle(MouseEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Nombre algobot");
        alert.setHeaderText("El nombre del algobot clickeado es:");
        alert.setContentText(nombre);

        alert.showAndWait();
        event.consume();
    }
}
