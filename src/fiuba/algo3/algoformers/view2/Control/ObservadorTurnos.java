package fiuba.algo3.algoformers.view2.Control;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Jugador;

/**
 * Created by Rodrigo on 22/06/2016.
 */
public interface ObservadorTurnos {


    void update(String nombreJugadorActual, int numeroDeTurnoActual);

    void update(Jugador juegadorActual);


}
