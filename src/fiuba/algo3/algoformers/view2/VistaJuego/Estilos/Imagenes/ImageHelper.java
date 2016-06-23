package fiuba.algo3.algoformers.view2.VistaJuego.Estilos.Imagenes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Hennico on 12/6/2016.
 */
public class ImageHelper {
    public static String path = "view2/VistaJuego/Estilos/Imagenes/";


    public ImageView getImagen (String nombreImagen){

       ImageView imageView = new ImageView(new Image(path + nombreImagen));

        return imageView;
    }




}
