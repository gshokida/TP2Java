package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Jugador;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class Turno {

    static int MIN= 1;
    int turno;
    Jugador jugador1;
    Jugador jugador2;


    public Turno (){

    }

    //PRE: Debe haber dos Jugadores ya agregados. TEMPORAL
    public void inicializar() {

        this.turno = this.MIN;
        this.alternarTurnos();

    }


    public void agregarJugador1(Jugador jugador1) {

        this.jugador1 = jugador1;

    }


    public void agregarJugador2(Jugador jugador2) {

        this.jugador2 = jugador2;

    }


    public void avanzarTurno() {

        this.turno++;
        this.alternarTurnos();

    }

    private void alternarTurnos(){

        if ((this.turno & 1) == 0){


            this.jugador1.esSuTurno(false);
            this.jugador2.esSuTurno(true);


        }else{

            this.jugador1.esSuTurno(true);
            this.jugador2.esSuTurno(false);

        }

    }




}
