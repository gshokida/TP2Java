package fiuba.algo3.algoformers.view.Eventos;

import fiuba.algo3.algoformers.view.Main;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by Hennico on 12/6/2016.
 */
public class EventoCambiarTamanioDePantalla implements EventHandler<Event> {

    @Override
    public void handle(Event event) {
        Main.maximisar();
        event.consume();
    }
}
