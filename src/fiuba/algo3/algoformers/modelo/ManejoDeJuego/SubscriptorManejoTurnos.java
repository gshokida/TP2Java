package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import fiuba.algo3.algoformers.view2.Control.ObservadorTurnos;
import fiuba.algo3.algoformers.view2.Control.Observer;

/**
 * Created by Rodrigo on 22/06/2016.
 */
public interface SubscriptorManejoTurnos {

    void agregarSubscriptor (ObservadorTurnos observer);

    void borrarSubscriptor (ObservadorTurnos observer);

    void notificar ();

}
