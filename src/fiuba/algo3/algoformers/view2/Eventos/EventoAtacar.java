package fiuba.algo3.algoformers.view2.Eventos;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Ataque;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;
import fiuba.algo3.algoformers.view2.VistaJuego.ContenedorAlgoformerPosicion;
import fiuba.algo3.algoformers.view2.VistaJuego.PanelCentralMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by Rodrigo on 22/06/2016.
 */
public class EventoAtacar  implements EventHandler<ActionEvent> {


    private ContenedorAlgoformerPosicion contenedorAlgoformerPosicion;
    private Juego juego;
    private PanelCentralMapa mapa;


    public EventoAtacar (Juego juego, PanelCentralMapa mapa, ContenedorAlgoformerPosicion contenedorAlgoformerPosicion){

        this.juego = juego;
        this.mapa = mapa;
        this.contenedorAlgoformerPosicion = contenedorAlgoformerPosicion;




    }



    @Override
    public void handle(ActionEvent event) {
        if (contenedorAlgoformerPosicion.getAlgoFormer().equals(NoOcupado.getInstance())){
            System.out.println("Accion Invalida");
        }else {


            Ataque ataque = new Ataque(juego.getTablero().getCasillero(contenedorAlgoformerPosicion.getPosicion()));


            try {
                ataque.atacarA(juego.getTablero().getCasillero(mapa.getPosicionBaldosa()));
                juego.getControlDeTurnos().pasarTurno();

            } catch (NoSePermiteElFuegoAmistosoException e1) {
                System.out.println("FuegoAmigoNO");
            } catch (DistanciaExcedidaException e1) {
                System.out.println("DistanciaExecidaNO");
            }
        }
    }
}
