package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeRealizarCombinacionException;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;
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



            if(bandoAlgoformer.esMismoBando(BandoAutobots.getInstance())){
                //new Superion(this.algoformers);
            } else {
                //new Menasor(this.algoformers);
            }
        }
    }

    private void obtenerAlgoformerParaTransformar(Bando bandoAlgoformer){
        int count = 0;
        Posicion posicionActual = new Posicion(this.posicion.getX(), this.posicion.getY());
    }
}
