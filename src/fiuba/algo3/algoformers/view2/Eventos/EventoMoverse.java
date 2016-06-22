package fiuba.algo3.algoformers.view2.Eventos;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.HumanoideNoPuedeAtravesarPantanoException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Movimiento;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;
import fiuba.algo3.algoformers.view2.VistaJuego.ContenedorAlgoformerPosicion;
import fiuba.algo3.algoformers.view2.VistaJuego.PanelCentralMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by Rodrigo on 22/06/2016.
 */
public class EventoMoverse implements EventHandler<ActionEvent> {

    private ContenedorAlgoformerPosicion contenedorAlgoformerPosicion;
    private PanelCentralMapa mapa;
    private Boolean movio;
    private Movimiento movimiento;
    private Juego juego;

    public EventoMoverse(Juego juego, PanelCentralMapa mapa, ContenedorAlgoformerPosicion contenedorAlgoformerPosicion, Boolean movio, Movimiento movimiento){

        this.contenedorAlgoformerPosicion = contenedorAlgoformerPosicion;
        this.mapa = mapa;
        this.movio = movio;
        this.movimiento = movimiento;
        this.juego = juego;
    }


    @Override
    public void handle(ActionEvent event) {

        if (contenedorAlgoformerPosicion.getAlgoFormer().equals(NoOcupado.getInstance())) {
            System.out.println("Accion Invalida");
        }else {

            if (!movio) {

                movimiento = new Movimiento(juego.getTablero().getCasillero(contenedorAlgoformerPosicion.getPosicion()), contenedorAlgoformerPosicion.getAlgoFormer());
                movio = true;

            }

            if (movimiento.quedanMovimientos()) {

                try {
                    movimiento.moverHasta(juego.getTablero().getCasillero(mapa.getPosicionBaldosa()));
                    contenedorAlgoformerPosicion.setPosicion(mapa.getPosicionBaldosa());
                } catch (DistanciaExcedidaException e1) {
                    System.out.println("Distancia Exedida");
                } catch (ImposibleMoverseCasilleroOcupadoException e1) {
                    System.out.println("Casillero Ocupado");
                } catch (HumanoideNoPuedeAtravesarPantanoException e1) {
                    System.out.println("Humanoide No Atraviesa Pantano");
                }
            } else {

                movio = false;
                juego.getControlDeTurnos().pasarTurno();

            }
        }

    }
}
