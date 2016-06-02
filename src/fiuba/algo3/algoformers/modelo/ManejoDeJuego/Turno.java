package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class Turno {
    static int MIN= 1;
    int turno;
    Jugador jugador1;
    Jugador jugador2;

    public Turno () {
        jugador1 = null;
        jugador2 = null;
    }

    //PRE: Debe haber dos Jugadores ya agregados. TEMPORAL
    public void inicializar() {
        turno = MIN;
        alternarTurnos();
    }

    public void agregarJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public void agregarJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public void avanzarTurno() {
        turno++;
        alternarTurnos();
    }

    private void alternarTurnos(){
        if ((turno & 1) == 0){
            jugador1.esSuTurno(false);
            jugador2.esSuTurno(true);
        } else {
            jugador1.esSuTurno(true);
            jugador2.esSuTurno(false);
        }
    }
}
