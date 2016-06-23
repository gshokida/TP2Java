package fiuba.algo3.algoformers.view2;


import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.NebulosaAndromeda;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Pantano;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.view2.VistaJuego.VentanaJuego;
import fiuba.algo3.algoformers.view2.VistaMenuPrincipal.MenuPrincipal;
import fiuba.algo3.algoformers.view2.VistaMenuPrincipal.VentanaNombrarJugador;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    private VentanaNombrarJugador ventanaNombrarJugador;
    private MenuPrincipal menuPrincipal;
    private VentanaJuego ventanaJuego;
    private Stage stage;
    private Juego juego;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        stage.setResizable(false);

        Button boton1 = new Button(), boton2 = new Button();
        menuPrincipal = new MenuPrincipal();
        ventanaJuego = new VentanaJuego();

        ventanaNombrarJugador = new VentanaNombrarJugador();

        boton1.setOnAction(e-> stage.setScene(menuPrincipal.getEscena()));
        boton2.setOnAction(e-> {
            if (!ventanaNombrarJugador.jugadoresFueronIngresados()) {
                ventanaNombrarJugador.display();
                juego = ventanaNombrarJugador.getJuego();
            }

            juego.getTablero().getCasillero(new Posicion(juego.getFilas()-3, juego.getColumnas()-2)).setSuperficieAerea(new NebulosaAndromeda());
            juego.getTablero().getCasillero(new Posicion(juego.getFilas()-2, juego.getColumnas()-3)).setSuperficieTerreste(new Pantano());

            ventanaJuego.setJuego(juego);
            stage.setScene(ventanaJuego.getEscena());

        });

        menuPrincipal.agregarBoton(boton2);
        ventanaJuego.agregarBoton(boton1);

        stage.setScene(menuPrincipal.getEscena());
        stage.show();


    }

    public static void main(String[] args) {

        launch(args);

    }


}