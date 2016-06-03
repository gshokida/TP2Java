package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class Turno {
    Jugador jugador;

    public Turno (Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return this.jugador;
    }
}
