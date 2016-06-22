package fiuba.algo3.algoformers.view2.Control;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Jugador;
import fiuba.algo3.algoformers.view2.VistaJuego.PanelInferior;

/**
 * Created by Rodrigo on 22/06/2016.
 */
public class ObservadorTurnoSecuencia implements ObservadorTurnos {

    private PanelInferior panel;


    public ObservadorTurnoSecuencia (PanelInferior panel){

        this.panel = panel;


    }


    @Override
    public void update(String nombreJugadorActual, int numeroDeTurnoActual) {

    }

    @Override
    public void update(Jugador jugadorActual) {

        panel.actualizarOpcionesJugadores (jugadorActual);

    }
}
