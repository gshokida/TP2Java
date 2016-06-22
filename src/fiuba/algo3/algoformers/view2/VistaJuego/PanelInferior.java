package fiuba.algo3.algoformers.view2.VistaJuego;

import fiuba.algo3.algoformers.modelo.Errores.*;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Accion;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Ataque;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Movimiento;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.ControlDeTurnos;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * Created by Rodrigo on 20/06/2016.
 */
public class PanelInferior {

    private HBox panelInferior;
    private Button botonTemporal;
    private Button botonTemporal2 ;
    private Button mover ;
    private Button atacar ;
    private Button transformar ;
    private Button botonPersonaje ;
    private Button botonPersonaje2;
    private Juego juego;
    private VentanaJuego mapa;
    private ControlDeTurnos controlTurnos;
    private Movimiento movimiento;
    private boolean movio;

    public PanelInferior (Juego juego, PosicionOriginal posicionOriginal, VentanaMapa mapa){

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

        VBox box1 = new VBox(20);
        VBox box2 = new VBox(20);
        VBox box3 = new VBox(20);

         botonTemporal  = new Button("Temporal");
         mover = new Button("MOVER");
         atacar = new Button("ATACAR");
         transformar = new Button("TRANSFORMAR");
         botonTemporal2 = new Button("Temporal");


        box1.getChildren().addAll(botonTemporal);
        box2.getChildren().addAll(mover,atacar,transformar);
        box3.getChildren().addAll(botonTemporal2);


        panelInferior.getChildren().addAll(botonPersonaje,box1,box2,box3,botonPersonaje2);
        movio = false;

        comportamiento(posicionOriginal, mapa);

    }

    public  HBox getPanelInferior (){

        return panelInferior;

    }

    //Cambiar la validacion a un metodo
    private  void comportamiento (PosicionOriginal posicionOriginal, VentanaMapa mapa){

        mover.setOnAction(e -> {

            if (posicionOriginal.getAlgoFormer().equals(NoOcupado.getInstance())) {
                System.out.println("Accion Invalida");
            }

            if (!movio){

                movimiento = new Movimiento(juego.getTablero().getCasillero(posicionOriginal.getPosicion()), posicionOriginal.getAlgoFormer());
                movio = true;

            }

            if (movimiento.quedanMovimientos()) {

                try {
                    movimiento.moverHasta(juego.getTablero().getCasillero(mapa.getPosicionBaldosa()));
                    posicionOriginal.setPosicion(mapa.getPosicionBaldosa());
                } catch (DistanciaExcedidaException e1) {
                    System.out.println("Distancia Exedida");
                } catch (ImposibleMoverseCasilleroOcupadoException e1) {
                    System.out.println("Casillero Ocupado");
                } catch (HumanoideNoPuedeAtravesarPantanoException e1) {
                    System.out.println("Humanoide No Atraviesa Pantano");
                }
            }else{

                movio = false;
                juego.getControlDeTurnos().pasarTurno();

            }

        });


        atacar.setOnAction(e -> {
            if (posicionOriginal.getAlgoFormer().equals(NoOcupado.getInstance())){
                System.out.println("Accion Invalida");
            }else {


                Ataque ataque = new Ataque(juego.getTablero().getCasillero(posicionOriginal.getPosicion()));


                try {
                    ataque.atacarA(juego.getTablero().getCasillero(mapa.getPosicionBaldosa()));
                    juego.getControlDeTurnos().pasarTurno();

                } catch (NoSePermiteElFuegoAmistosoException e1) {
                    System.out.println("FuegoAmigoNO");
                } catch (DistanciaExcedidaException e1) {
                    System.out.println("DistanciaExecidaNO");
                }
            }
        });

        transformar.setOnAction(e->{

            if (posicionOriginal.getAlgoFormer().equals(NoOcupado.getInstance())){
                System.out.println("Accion Invalida");
            }else {

                Transformacion transformar = new Transformacion(juego.getTablero().getCasillero(posicionOriginal.getPosicion()), posicionOriginal.getAlgoFormer());

                try {
                    transformar.aplicarTransformacion();
                    juego.getControlDeTurnos().pasarTurno();
                    System.out.println("Transformandose");
                } catch (NoPuedeTransformarseEnHumanoideException e1) {
                    System.out.println("WachinEstasEmpantanado");
                }

            }

        });
    }


    public void setControlTurnos(ControlDeTurnos controlDeTurnos) {

    this.controlTurnos = controlDeTurnos;

    }
}
