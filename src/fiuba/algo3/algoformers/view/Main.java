package fiuba.algo3.algoformers.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static Main instancia;

    private static double PANTALLA_ANCHO = 800D;
    private static double PANTALLA_ALTO = 600D;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        stage.setTitle("Algoformers ultimate action club");
        stage.setResizable(false);
        instancia = this;

        PantallaDeMapa.activarPantala(15,15,32D);
    }

    public static void cambiarEsena(BorderPane border) {
        instancia.stage.setScene(new Scene(border, PANTALLA_ANCHO, PANTALLA_ALTO));
        instancia.stage.show();
    }

    public static void maximisar() {
        instancia.stage.setMaximized(!instancia.stage.isMaximized());
    }

    public static void main(String[] args) {
        launch(args);
    }
}