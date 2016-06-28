package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.HumanoideNoPuedeAtravesarPantanoException;
import fiuba.algo3.algoformers.modelo.Errores.NoPuedeRealizarCombinacionException;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Menasor;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Superion;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by german.shokida on 22/6/2016.
 */
public class Combinar {
    private int duracion;
    private Posicion posicion;
    private Tablero tablero;
    private List<AlgoFormer> algoformers;

    public Combinar(Tablero tablero, Posicion posicion, int duracion){
        this.duracion = duracion;
        this.tablero = tablero;
        this.posicion = posicion;
        this.algoformers = new LinkedList<>();
    }

    public void realizarCombinacion() throws NoPuedeRealizarCombinacionException {

        AlgoFormer algoformerActual = this.tablero.getCasillero(this.posicion).getAlgoformer();

        if (NoOcupado.getInstance().equals(algoformerActual)){
            throw new NoPuedeRealizarCombinacionException();
        } else {
            Bando bandoAlgoformer = algoformerActual.getBando();

            if (sePuedeRealizarLaCombinacion(bandoAlgoformer)) {
                AlgoFormer algoformerCombinado;

                obtenerAlgoformersParaTransformar(bandoAlgoformer);

                if (bandoAlgoformer.esMismoBando(BandoAutobots.getInstance())) {
                    algoformerCombinado = new Superion(this.algoformers);
                } else {
                    algoformerCombinado = new Menasor(this.algoformers);
                }

                try {
                    this.tablero.getCasillero(this.posicion).setAlgoformer(algoformerCombinado);
                } catch (HumanoideNoPuedeAtravesarPantanoException e) {

                }
            }
        }
    }

    private boolean sePuedeRealizarLaCombinacion(Bando bandoAlgoformer){
        boolean resultado = false;
        Posicion pos = new Posicion(this.posicion.getX(), this.posicion.getY());
        int algoformersEncontrados = 0;

        if (pos.getX() - 1 > 0) {
            pos.actualizarPosicion(pos.getX() - 1, pos.getY());
            if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                    algoformersEncontrados++;
                }
            }

            pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

            if (pos.getY() - 1 > 0) {
                pos.actualizarPosicion(pos.getX() - 1, pos.getY() - 1);
                if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                    if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                        algoformersEncontrados++;
                    }
                }
            }

            pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

            if (pos.getY() + 1 < this.tablero.getColumnas()) {
                pos.actualizarPosicion(pos.getX() - 1, pos.getY() + 1);
                if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                    if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                        algoformersEncontrados++;
                    }
                }
            }
        }

        pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

        if (pos.getX() + 1 < this.tablero.getFilas()) {
            pos.actualizarPosicion(pos.getX() + 1, pos.getY());
            if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                    algoformersEncontrados++;
                }
            }

            pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

            if (pos.getY() - 1 > 0) {
                pos.actualizarPosicion(pos.getX() + 1, pos.getY() - 1);
                if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                    if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                        algoformersEncontrados++;
                    }
                }
            }

            pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

            if (pos.getY() + 1 < this.tablero.getColumnas()) {
                pos.actualizarPosicion(pos.getX() + 1, pos.getY() + 1);
                if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                    if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                        algoformersEncontrados++;
                    }
                }
            }
        }

        pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

        if (pos.getY() - 1 > 0) {
            pos.actualizarPosicion(pos.getX(), pos.getY() - 1);
            if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                    algoformersEncontrados++;
                }
            }
        }

        pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

        if (pos.getY() + 1 < this.tablero.getColumnas()) {
            pos.actualizarPosicion(pos.getX(), pos.getY() + 1);
            if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                    algoformersEncontrados++;
                }
            }
        }

        if(algoformersEncontrados == 2)
            resultado = true;

        return resultado;
    }

    private void obtenerAlgoformersParaTransformar(Bando bandoAlgoformer){
        Posicion pos = new Posicion(this.posicion.getX(), this.posicion.getY());

        this.algoformers.add(this.tablero.getCasillero(pos).getAlgoformer());
        try {
            this.tablero.getCasillero(pos).setAlgoformer(NoOcupado.getInstance());
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {

        }

        if (pos.getX() - 1 > 0) {
            pos.actualizarPosicion(pos.getX() - 1, pos.getY());
            if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                    this.algoformers.add(this.tablero.getCasillero(pos).getAlgoformer());
                    try {
                        this.tablero.getCasillero(pos).setAlgoformer(NoOcupado.getInstance());
                    } catch (HumanoideNoPuedeAtravesarPantanoException e) {

                    }
                }
            }

            pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

            if (pos.getY() - 1 > 0) {
                pos.actualizarPosicion(pos.getX() - 1, pos.getY() - 1);
                if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                    if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                        this.algoformers.add(this.tablero.getCasillero(pos).getAlgoformer());
                        try {
                            this.tablero.getCasillero(pos).setAlgoformer(NoOcupado.getInstance());
                        } catch (HumanoideNoPuedeAtravesarPantanoException e) {

                        }
                    }
                }
            }

            pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

            if (pos.getY() + 1 < this.tablero.getColumnas()) {
                pos.actualizarPosicion(pos.getX() - 1, pos.getY() + 1);
                if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                    if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                        this.algoformers.add(this.tablero.getCasillero(pos).getAlgoformer());
                        try {
                            this.tablero.getCasillero(pos).setAlgoformer(NoOcupado.getInstance());
                        } catch (HumanoideNoPuedeAtravesarPantanoException e) {

                        }
                    }
                }
            }
        }

        pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

        if (pos.getX() + 1 < this.tablero.getFilas()) {
            pos.actualizarPosicion(pos.getX() + 1, pos.getY());
            if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                    this.algoformers.add(this.tablero.getCasillero(pos).getAlgoformer());
                    try {
                        this.tablero.getCasillero(pos).setAlgoformer(NoOcupado.getInstance());
                    } catch (HumanoideNoPuedeAtravesarPantanoException e) {

                    }
                }
            }

            pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

            if (pos.getY() - 1 > 0) {
                pos.actualizarPosicion(pos.getX() + 1, pos.getY() - 1);
                if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                    if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                        this.algoformers.add(this.tablero.getCasillero(pos).getAlgoformer());
                        try {
                            this.tablero.getCasillero(pos).setAlgoformer(NoOcupado.getInstance());
                        } catch (HumanoideNoPuedeAtravesarPantanoException e) {

                        }
                    }
                }
            }

            pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

            if (pos.getY() + 1 < this.tablero.getColumnas()) {
                pos.actualizarPosicion(pos.getX() + 1, pos.getY() + 1);
                if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                    if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                        this.algoformers.add(this.tablero.getCasillero(pos).getAlgoformer());
                        try {
                            this.tablero.getCasillero(pos).setAlgoformer(NoOcupado.getInstance());
                        } catch (HumanoideNoPuedeAtravesarPantanoException e) {

                        }
                    }
                }
            }
        }

        pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

        if (pos.getY() - 1 > 0) {
            pos.actualizarPosicion(pos.getX(), pos.getY() - 1);
            if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                    this.algoformers.add(this.tablero.getCasillero(pos).getAlgoformer());
                    try {
                        this.tablero.getCasillero(pos).setAlgoformer(NoOcupado.getInstance());
                    } catch (HumanoideNoPuedeAtravesarPantanoException e) {

                    }
                }
            }
        }

        pos.actualizarPosicion(this.posicion.getX(), this.posicion.getY());

        if (pos.getY() + 1 < this.tablero.getColumnas()) {
            pos.actualizarPosicion(pos.getX(), pos.getY() + 1);
            if (!this.tablero.getCasillero(pos).getAlgoformer().equals(NoOcupado.getInstance())){
                if (this.tablero.getCasillero(pos).getAlgoformer().getBando().esMismoBando(bandoAlgoformer)) {
                    this.algoformers.add(this.tablero.getCasillero(pos).getAlgoformer());
                    try {
                        this.tablero.getCasillero(pos).setAlgoformer(NoOcupado.getInstance());
                    } catch (HumanoideNoPuedeAtravesarPantanoException e) {

                    }
                }
            }
        }
    }
}
