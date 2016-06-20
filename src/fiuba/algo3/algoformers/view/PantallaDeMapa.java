package fiuba.algo3.algoformers.view;

import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.view.imagenes.ImageHelper;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * Created by Hennico on 11/6/2016.
 */
public class PantallaDeMapa extends BorderPane {
    private BorderPane[][] contenidos;
    private double tamanio;
    private Label nombreJugadorActivo;

    public PantallaDeMapa(Juego juego) {
        this.tamanio = 32d;

        generarContenidos(juego.getFilas(), juego.getColumnas(), juego.getTablero());
        this.setCenter(generarGrilla(juego));

        nombreJugadorActivo.setText(juego.getControlDeTurnos().getTurno().getJugador().getNombre());
    }

    private HBox generarGrilla(Juego juego) {
        int ancho = juego.getFilas();
        int alto = juego.getColumnas();

        VBox[] vertical = new VBox[ancho+1];
        for (int i = 1; i < ancho+1; i++) {
            HBox[] horizontal = new HBox[alto];

            for (int j = 0; j < alto; j++) {
                HBox cajaUnidad = new HBox(contenidos[i-1][j]);

                cajaUnidad.setPrefWidth(tamanio + 2.5d);
                cajaUnidad.setPrefHeight(tamanio + 2.5d);
                cajaUnidad.setAlignment(Pos.CENTER);

                horizontal[j] = cajaUnidad;
            }

            vertical[i] = new VBox(horizontal);
        }

        nombreJugadorActivo = new Label("");

        vertical[0] = new VBox(nombreJugadorActivo);
        vertical[0].setPrefHeight(640);
        vertical[0].setPrefWidth(160);
        vertical[0].setAlignment(Pos.CENTER);

        BackgroundImage fondo = new BackgroundImage(new Image(ImageHelper.getImagePath("BarraMenu.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vertical[0].setBackground(new Background(fondo));

        HBox pantalla = new HBox(vertical);
        pantalla.setAlignment(Pos.CENTER);

        return pantalla;
    }

    private void generarContenidos(int ancho, int alto, Tablero tablero) {
        contenidos = new BorderPane[ancho][alto];

        for (int i = 0; i < ancho; i++)
            for (int j = 0; j < alto; j++)
                contenidos[i][j] = new ViewCasillero(tablero.getCasillero(new Posicion(i,j)));
    }

    public static void activarPantala(Juego juego) {
        Main.cambiarEsena(new PantallaDeMapa(juego));
    }
}
