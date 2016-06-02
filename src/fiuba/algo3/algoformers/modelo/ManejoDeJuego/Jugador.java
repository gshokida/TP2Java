package fiuba.algo3.algoformers.modelo.ManejoDeJuego;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;

import java.util.List;

/**
 * Created by Rodrigo on 27/05/2016.
 */
public class Jugador {
    String nombre;
    boolean turno;
    Bando bando;
    List<AlgoFormer> listaPersonajes;

    public void addNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean seLlama(String nombre) {
        return this.nombre == nombre;
    }


    public void esSuTurno(boolean b) {
        this.turno = b;
    }

    public boolean puedeJugar() {
        return turno;
    }

    public void setBando(Bando bando) {
        this.bando = bando;
    }

    public Bando getBando() {
        return bando;
    }


    public void agregarAlgoformers(List<AlgoFormer> personajes) {
        listaPersonajes = personajes;
    }

    public void prepararParaJugar(List<AlgoFormer> algoformers, Bando bando) {
        agregarAlgoformers(algoformers);
        setBando(bando);
    }
}
