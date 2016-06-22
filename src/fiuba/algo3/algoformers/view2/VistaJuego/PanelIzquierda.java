package fiuba.algo3.algoformers.view2.VistaJuego;

import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by Rodrigo on 22/06/2016.
 */
public class PanelIzquierda implements Paneles {

    private VBox box;
    private Label nombre;
    private Label vida;
    private Label movimiento;
    private Label ataque;
    private Label bando;
    private ContenedorAlgoformerPosicion algoformerPosicion;


    public PanelIzquierda (){

        box = new VBox(20);

        nombre = new Label("Algoformer");
        vida = new Label("Vida");
        movimiento = new Label("Velocidad");
        ataque = new Label("Ataque");
       // bando = new Label("Ninguno");

        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(0,0,0,20));

        box.getChildren().addAll(nombre,vida,movimiento,ataque);
        algoformerPosicion = new ContenedorAlgoformerPosicion();

    }


    public VBox getPanelIzquierdo(){

        return box;

    }


    public void setBotonVolver (Button boton){

        box.getChildren().addAll(boton);

    }


    @Override
    public void actualizarAlgoformers(AlgoFormer algoFormer) {

        if (!algoFormer.equals(NoOcupado.getInstance())) {
            nombre.setText(algoFormer.getNombre());
            vida.setText("Vida: " + algoFormer.getPuntosDeVida());
            movimiento.setText("Velocidad" + algoFormer.getVelocidad());
            ataque.setText("Ataque: " + algoFormer.getAtaque());
        }else {

            nombre.setText("Algoformer");
            vida.setText("Vida");
            movimiento.setText("Velocidad");
            ataque.setText("Ataque");


        }
    }
}
