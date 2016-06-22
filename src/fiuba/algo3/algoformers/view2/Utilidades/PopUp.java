package fiuba.algo3.algoformers.view2.Utilidades;

import javafx.scene.control.Alert;

/**
 * Created by Rodrigo on 22/06/2016.
 */
public class PopUp {

   private  Alert alerta;

   public PopUp (){

   alerta = new Alert(Alert.AlertType.WARNING);

       alerta.setResizable(true);
       alerta.getDialogPane().setPrefSize(400,200);
   }

    public void setTextoAlerta (String titulo,String alerta){

        this.alerta.setTitle(titulo);
        this.alerta.setHeaderText(alerta);

    }

    public void mostrarAlerta(){

        this.alerta.showAndWait();

    }

    public void cambiarAlertaInformacion (){

        this.alerta.setAlertType(Alert.AlertType.INFORMATION);

    }

}
