package fiuba.algo3.algoformers.view;

import fiuba.algo3.algoformers.view.Eventos.EventoCambiarTamanioDePantalla;
import fiuba.algo3.algoformers.view.Eventos.EventoImprimirNombreEnConsola;
import fiuba.algo3.algoformers.view.imagenes.ImageHelper;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

/**
 * Created by Hennico on 11/6/2016.
 */
public class PantallaDeMapa extends BorderPane {
    private Pane[][] contenidos;
    private double tamanio;

    public PantallaDeMapa(int ancho, int alto, double tamanio) {
        this.tamanio = tamanio;
        generarContenidos(ancho, alto);

        this.setCenter(generarGrilla(ancho, alto));

        Image pastoFondo = new Image(ImageHelper.getImagePath("PastoFondo.png"));
        BackgroundImage fondo = new BackgroundImage(pastoFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(fondo));
    }

    private HBox generarGrilla(int ancho, int alto) {
        VBox[] vertical = new VBox[ancho+1];
        for (int i = 1; i < ancho+1; i++) {
            HBox[] horizontal = new HBox[alto];

            for (int j = 0; j < alto; j++) {
                HBox cajaUnidad = new HBox(contenidos[i-1][j]);

                cajaUnidad.setPrefWidth(tamanio);
                cajaUnidad.setPrefHeight(tamanio);
                cajaUnidad.setAlignment(Pos.CENTER);

                horizontal[j] = cajaUnidad;
            }

            vertical[i] = new VBox(horizontal);
        }

        Button button = new Button("Maximisar");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventoCambiarTamanioDePantalla());
        vertical[0] = new VBox(button);
        vertical[0].setPrefHeight(640);
        vertical[0].setPrefWidth(160);
        vertical[0].setAlignment(Pos.CENTER);

        BackgroundImage fondo = new BackgroundImage(new Image(ImageHelper.getImagePath("BarraMenu.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vertical[0].setBackground(new Background(fondo));

        HBox pantalla = new HBox(vertical);
        pantalla.setAlignment(Pos.CENTER);

        return pantalla;
    }

    private void generarContenidos(int ancho, int alto) {
        contenidos = new Pane[ancho][alto];

        for (int i = 0; i < ancho; i++)
            for (int j = 0; j < alto; j++)
                contenidos[i][j] = generarPanel();

        Image owlowiscious = new Image(ImageHelper.getImagePath("owlowiscious.gif"));
        Image twilight = new Image(ImageHelper.getImagePath("twilight.gif"));

        contenidos[      0][0] = generarPanel(generarImageView(owlowiscious, "Enemigo 1"));
        contenidos[ancho/2][0] = generarPanel(generarImageView(owlowiscious, "Enemigo 2"));
        contenidos[ancho-1][0] = generarPanel(generarImageView(owlowiscious, "Enemigo 3"));

        contenidos[      0][alto-1] = generarPanel(generarImageView(twilight, "Enemigo 4"));
        contenidos[ancho/2][alto-1] = generarPanel(generarImageView(twilight, "Enemigo 5"));
        contenidos[ancho-1][alto-1] = generarPanel(generarImageView(twilight, "Enemigo 6"));
    }

    private Pane generarPanel(Node... nodes) {
        Pane pane = new Pane(nodes);

        pane.setPrefHeight(tamanio);
        pane.setPrefWidth(tamanio);

        return pane;
    }

    private ImageView generarImageView(Image imagen, String nombre) {
        ImageView actualImage = new ImageView(imagen);

        actualImage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventoImprimirNombreEnConsola(nombre));

        return actualImage;
    }

    public static void activarPantala(int ancho, int alto, double tamanio) {
        Main.cambiarEsena(new PantallaDeMapa(ancho, alto, tamanio));
    }
}
