package fiuba.algo3.algoformers.view2;

import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import javafx.scene.Scene;
import javafx.scene.control.Button;

/**
 * Created by Rodrigo on 15/06/2016.
 */
public interface Ventana  {

    Scene getEscena();

    void agregarBoton(Button boton);

}
