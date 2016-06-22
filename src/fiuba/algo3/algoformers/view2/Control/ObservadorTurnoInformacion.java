package fiuba.algo3.algoformers.view2.Control;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Jugador;
import fiuba.algo3.algoformers.view2.VistaJuego.PanelDerecha;

/**
 * Created by Rodrigo on 22/06/2016.
 */
public class ObservadorTurnoInformacion implements ObservadorTurnos{

    private PanelDerecha panelDerecha;


    public ObservadorTurnoInformacion (PanelDerecha panelDerecha){

        this.panelDerecha = panelDerecha;

    }


    @Override
    public void update(String nombreJugadorActual, int numeroDeTurnoActual) {

        panelDerecha.actualizarPanel(nombreJugadorActual, numeroDeTurnoActual);


    }

    @Override
    public void update(Jugador juegadorActual) {

    }
}
