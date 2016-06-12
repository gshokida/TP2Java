package fiuba.algo3.algoformers.view.Eventos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by Hennico on 12/6/2016.
 */
public class EventoImprimirNombreEnConsola implements EventHandler<MouseEvent> {
    private String nombre;

    public EventoImprimirNombreEnConsola(String nombre) {
        this.nombre = nombre;
    }

    public void handle(MouseEvent event) {
        System.out.println("Nombre precionado: " + nombre);
        event.consume();
    }
}
