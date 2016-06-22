package fiuba.algo3.algoformers.view2.Control;

import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.Contenido;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.view2.VistaJuego.VentanaMapa;

/**
 * Created by Rodrigo on 21/06/2016.
 */
public class ObservadorContenido implements Observer {

    VentanaMapa ventana;


    public ObservadorContenido (VentanaMapa ventana){

        this.ventana = ventana;

    }


    @Override
    public void update(AlgoFormer algoFormer, Posicion posicion) {

    }

    @Override
    public void update(Contenido contenido, Posicion posicion) {

        ventana.actualizarVista(contenido,posicion);

    }

    @Override
    public void update(SuperficieAerea superficie, Posicion posicion) {

    }

    @Override
    public void update(SuperficieTerrestre superficie, Posicion posicion) {

    }


}
