package fiuba.algo3.algoformers.view2.Eventos;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeTransformarseEnHumanoideException;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;
import fiuba.algo3.algoformers.view2.VistaJuego.ContenedorAlgoformerPosicion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by Rodrigo on 22/06/2016.
 */
public class EventoTransformarse implements EventHandler<ActionEvent> {


    private ContenedorAlgoformerPosicion contenedorAlgoformerPosicion;
    private Juego juego;

    public EventoTransformarse (Juego juego, ContenedorAlgoformerPosicion contenedorAlgoformerPosicion){

        this.juego = juego;
        this.contenedorAlgoformerPosicion = contenedorAlgoformerPosicion;
    }



    @Override
    public void handle(ActionEvent event) {

        if (contenedorAlgoformerPosicion.getAlgoFormer().equals(NoOcupado.getInstance())){
            System.out.println("Accion Invalida");
        }else {

            Transformacion transformar = new Transformacion(juego.getTablero().getCasillero(contenedorAlgoformerPosicion.getPosicion()), contenedorAlgoformerPosicion.getAlgoFormer());

            try {
                transformar.aplicarTransformacion();
                juego.getControlDeTurnos().pasarTurno();
                System.out.println("Transformandose");
            } catch (NoPuedeTransformarseEnHumanoideException e1) {
                System.out.println("WachinEstasEmpantanado");
            }

        }
    }
}
