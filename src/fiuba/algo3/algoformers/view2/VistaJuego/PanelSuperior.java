package fiuba.algo3.algoformers.view2.VistaJuego;

import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Jugador;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Created by Rodrigo on 20/06/2016.
 */
public class PanelSuperior implements Paneles {

    private Label jugador1;
    private Label jugador2;
    private HBox panelSuperior;

    public PanelSuperior (){

        jugador1 = new Label();

        jugador2 = new Label();

        jugador1.setFont(new Font("Transformers Movie", 30));
        jugador1.setStyle("-fx-text-fill:ghostwhite;");

        jugador2.setFont(new Font("Transformers Movie", 30));
        jugador2.setStyle("-fx-text-fill:ghostwhite;");



        panelSuperior = new HBox(266);

        panelSuperior.setPadding(new Insets(40,0,0,0));

        panelSuperior.getChildren().addAll(jugador1,jugador2);

        panelSuperior.setAlignment(Pos.CENTER);

    }

    public HBox getPanelSuperior(){

        return panelSuperior;

    }


    public void setJugador1(Jugador jugador1) {


        this.jugador1.setText(jugador1.getNombre());

    }

    public void setJugador2(Jugador jugador2) {

        this.jugador2.setText(jugador2.getNombre());

    }


    @Override
    public void actualizarAlgoformers(AlgoFormer algoFormer) {

    }
}
