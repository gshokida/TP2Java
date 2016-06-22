package fiuba.algo3.algoformers.view2.VistaJuego;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Movimiento;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.ControlDeTurnos;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Jugador;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.view2.Control.ObservadorTurnoSecuencia;
import fiuba.algo3.algoformers.view2.Eventos.EventoAtacar;
import fiuba.algo3.algoformers.view2.Eventos.EventoMoverse;
import fiuba.algo3.algoformers.view2.Eventos.EventoTransformarse;
import fiuba.algo3.algoformers.view2.Utilidades.PopUp;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * Created by Rodrigo on 20/06/2016.
 */
public class PanelInferior implements Paneles{

    private HBox panelInferior;
    private Button botonTemporal;
    private Button moverJugador1 ;
    private Button atacarJugador1 ;
    private Button transformarJugador1 ;
    private Button moverJugador2 ;
    private Button atacarJugador2 ;
    private Button transformarJugador2 ;
    private Button botonPersonaje ;
    private Button botonPersonaje2;
    private Juego juego;
    private ControlDeTurnos controlTurnos;
    private Movimiento movimiento;
    private boolean movio;
    private VBox box1;
    private VBox box3;



    public PanelInferior (Juego juego, ContenedorAlgoformerPosicion contenedorAlgoformerPosicion, PanelCentralMapa mapa){

        this.juego = juego;

        panelInferior = new HBox(100);

        botonPersonaje = new Button();

        botonPersonaje.setShape(new Circle(100));
        botonPersonaje.setMinSize(200,200);
        botonPersonaje.setMaxSize(200,200);

        botonPersonaje2 = new Button();

        botonPersonaje2.setShape(new Circle(100));
        botonPersonaje2.setMinSize(200,200);
        botonPersonaje2.setMaxSize(200,200);

        box1 = new VBox(20);
        VBox box2 = new VBox(20);
        box3 = new VBox(20);

        botonTemporal  = new Button("Temporal");
        moverJugador1 = new Button("MOVER");
        atacarJugador1 = new Button("ATACAR");
        transformarJugador1 = new Button("TRANSFORMAR");
        moverJugador2 = new Button("MOVER");
        atacarJugador2 = new Button("ATACAR");
        transformarJugador2 = new Button("TRANSFORMAR");

        box1.getChildren().addAll(moverJugador1,atacarJugador1,transformarJugador1);
        box2.getChildren().addAll(botonTemporal);
        box3.getChildren().addAll(moverJugador2,atacarJugador2,transformarJugador2);


        panelInferior.getChildren().addAll(botonPersonaje,box1,box2,box3,botonPersonaje2);
        movio = false;

        ObservadorTurnoSecuencia obsTurnosSecuencia = new ObservadorTurnoSecuencia(this);
        juego.getControlDeTurnos().agregarSubscriptor(obsTurnosSecuencia);

        comportamiento(contenedorAlgoformerPosicion, mapa);

    }

    public  HBox getPanelInferior (){

        return panelInferior;

    }

    private  void comportamiento (ContenedorAlgoformerPosicion contenedorAlgoformerPosicion, PanelCentralMapa mapa){

        moverJugador1.setOnAction(new EventoMoverse(juego,mapa, contenedorAlgoformerPosicion,movio,movimiento));

        atacarJugador1.setOnAction(new EventoAtacar(juego,mapa, contenedorAlgoformerPosicion));

        transformarJugador1.setOnAction(new EventoTransformarse(juego, contenedorAlgoformerPosicion));

        moverJugador2.setOnAction(new EventoMoverse(juego,mapa, contenedorAlgoformerPosicion,movio,movimiento));

        atacarJugador2.setOnAction(new EventoAtacar(juego,mapa, contenedorAlgoformerPosicion));

        transformarJugador2.setOnAction(new EventoTransformarse(juego, contenedorAlgoformerPosicion));

    }


    public void actualizarOpcionesJugadores(Jugador jugadorActual) {

        if (juego.getJugador1().getNombre() == jugadorActual.getNombre()) {

            box1.setDisable(false);
            box3.setDisable(true);

        }else{

            box3.setDisable(false);
            box1.setDisable(true);
        }

    }

    @Override
    public void actualizarAlgoformers(AlgoFormer algoFormer) {

    }
}
