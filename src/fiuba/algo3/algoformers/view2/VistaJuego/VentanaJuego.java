package fiuba.algo3.algoformers.view2.VistaJuego;




import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.view2.Ventana;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;



/**
 * Created by Rodrigo on 15/06/2016.
 */
public class VentanaJuego implements Ventana {

    private PanelInferior panelInferior;
    private PanelSuperior panelSuperior;
    private BorderPane border;
    private Scene scene;
    private Juego juego;
    private PanelCentralMapa mapa;
    private PosicionOriginal posicionOriginal;
    private PanelDerecha panelDerecha;

    public VentanaJuego (){

        posicionOriginal = new PosicionOriginal();
        border = new BorderPane();
        panelSuperior = new PanelSuperior();

        scene = new Scene(border, 1024,800);
        scene.getStylesheets().addAll(this.getClass().getResource("Estilos/boton.css").toExternalForm(),
            this.getClass().getResource("Estilos/optimus.css").toExternalForm());

    }



    @Override
    public Scene getEscena() {
        return scene;
    }

    @Override
    public void agregarBoton(Button boton) {
        boton.setText("<-");
        VBox box = new VBox();
        box.getChildren().addAll(boton);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(0,0,0,10));
        border.setLeft(box);

    }

    public void setJuego(Juego juego) {

        this.juego = juego;

        mapa = new PanelCentralMapa(juego, posicionOriginal);

        border.setCenter(mapa.getGrilla());
        panelInferior = new PanelInferior(juego, posicionOriginal, mapa);
        border.setBottom(panelInferior.getPanelInferior());
        border.setTop(panelSuperior.getPanelSuperior());

        panelSuperior.setJugador1 (juego.getJugador1());
        panelSuperior.setJugador2 (juego.getJugador2());

        panelDerecha = new PanelDerecha(juego);

        border.setRight(panelDerecha.getPanelDerecha());


    }

}
