package fiuba.algo3.algoformers.view2.VistaJuego.Imagenes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * Created by Hennico on 12/6/2016.
 */
public class ImageHelper {

    public static String path = "file:src/fiuba/algo3/algoformers/view2/VistaJuego/Imagenes/";


    public BackgroundImage getImagen (String nombreImagen){


        Image image = new Image(path+nombreImagen+".png");
        BackgroundImage imagen = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        return imagen;
    }




}
