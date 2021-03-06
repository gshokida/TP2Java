package fiuba.algo3.algoformers.view2.VistaJuego;




import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.NebulosaAndromeda;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.view2.Ventana;
import fiuba.algo3.algoformers.view2.VistaJuego.Imagenes.ImageHelper;
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
    private ContenedorAlgoformerPosicion contenedorAlgoformerPosicion;
    private PanelDerecha panelDerecha;
    private PanelIzquierda panelIzquierda;

    public VentanaJuego (){

        contenedorAlgoformerPosicion = new ContenedorAlgoformerPosicion();
        border = new BorderPane();
        panelSuperior = new PanelSuperior();
        panelIzquierda = new PanelIzquierda();

        border.setBackground(new Background(new ImageHelper().getImagen("ventanajuegobg")));

        contenedorAlgoformerPosicion.setPaneles(panelIzquierda);

        scene = new Scene(border, 1024,800);

    }



    @Override
    public Scene getEscena() {
        return scene;
    }

    @Override
    public void agregarBoton(Button boton) {
        boton.setText("<-");
        panelIzquierda.setBotonVolver(boton);
        border.setLeft(panelIzquierda.getPanelIzquierdo());

    }

    public void setJuego(Juego juego) {

        this.juego = juego;

        mapa = new PanelCentralMapa(juego, contenedorAlgoformerPosicion);

        border.setCenter(mapa.getGrilla());
        panelInferior = new PanelInferior(juego, contenedorAlgoformerPosicion, mapa);
        contenedorAlgoformerPosicion.setPaneles(panelInferior);

        border.setBottom(panelInferior.getPanelInferior());
        border.setTop(panelSuperior.getPanelSuperior());

        panelSuperior.setJugador1 (juego.getJugador1());
        panelSuperior.setJugador2 (juego.getJugador2());

        panelDerecha = new PanelDerecha(juego);

        border.setRight(panelDerecha.getPanelDerecha());



    }



}
