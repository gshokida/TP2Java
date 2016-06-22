package fiuba.algo3.algoformers.view2.VistaJuego;


import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ChispaSuprema;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.Contenido;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.NebulosaAndromeda;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Pantano;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;
import fiuba.algo3.algoformers.view2.Control.ObservadorAlgoformer;
import fiuba.algo3.algoformers.view2.Control.ObservadorContenido;
import fiuba.algo3.algoformers.view2.Control.ObservadorSuperficies;
import fiuba.algo3.algoformers.view2.Mapa.Baldosa;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

/**
 * Created by Rodrigo on 20/06/2016.
 */
public class PanelCentralMapa implements Paneles {

    private GridPane grilla;
    private Posicion posicion;
    private Baldosa baldosas [][];
    private Juego juego;
    private ObservadorAlgoformer observadorAlgoformer;
    private ObservadorContenido observadorContenido;
    private ObservadorSuperficies observadorSuperficies;





    public PanelCentralMapa(Juego juego, ContenedorAlgoformerPosicion contenedorAlgoformerPosicion){

        this.juego = juego;

        baldosas = new Baldosa[juego.getColumnas()][juego.getFilas()];

        grilla = new GridPane();

        observadorAlgoformer = new ObservadorAlgoformer(this);
        observadorContenido = new ObservadorContenido(this);
        observadorSuperficies = new ObservadorSuperficies(this);


        for (int i = 0; i < juego.getColumnas(); i++) {
            for (int j = 0; j < juego.getFilas(); j++) {

                Baldosa baldosa= new Baldosa(i,j);

                baldosa.getBaldosa().setOnMouseClicked(e->{ if (e.getClickCount()==1) {
                    this.posicion = baldosa.getPosicion();
                }else{
                    cargarPosicion(contenedorAlgoformerPosicion);
                }
                });

                baldosas [i] [j] = baldosa;
                GridPane.setRowIndex(baldosa.getBaldosa(), i);
                GridPane.setColumnIndex(baldosa.getBaldosa(), j);
                grilla.getChildren().add(baldosa.getBaldosa());

            }
        }

        grilla.setAlignment(Pos.CENTER);

        comenzarMapa();
        cargarSubscriptores();

    }

    private void cargarPosicion (ContenedorAlgoformerPosicion contenedorAlgoformerPosicion) {

        contenedorAlgoformerPosicion.setAlgoFormer(juego.getTablero().getCasillero(getPosicionBaldosa()).getAlgoformer());
        contenedorAlgoformerPosicion.setPosicion(getPosicionBaldosa());
        contenedorAlgoformerPosicion.actualizarAlgoformer();
        System.out.println(contenedorAlgoformerPosicion.getAlgoFormer());
        System.out.println("Posicion" + contenedorAlgoformerPosicion.getPosicion().getX()+"y"+ contenedorAlgoformerPosicion.getPosicion().getY());

    }

    private void comenzarMapa (){

        for (int i = 0; i < juego.getColumnas(); i++) {
            for (int j = 0; j < juego.getFilas(); j++) {


                verificarCasillero(juego.getTablero().getCasillero(baldosas[i][j].getPosicion()).getAlgoformer(),baldosas[i][j].getPosicion());
                verificarCasillero(juego.getTablero().getCasillero(baldosas[i][j].getPosicion()).getContenido(), baldosas[i][j].getPosicion());


            }
        }


    }

    private void cargarSubscriptores () {

        for (int i = 0; i < juego.getColumnas(); i++) {
            for (int j = 0; j < juego.getFilas(); j++) {
                juego.getTablero().getCasillero(baldosas [i] [j].getPosicion()).agregarSubscriptor(observadorAlgoformer);
                juego.getTablero().getCasillero(baldosas [i] [j].getPosicion()).agregarSubscriptor(observadorContenido);
                juego.getTablero().getCasillero(baldosas [i] [j].getPosicion()).agregarSubscriptor(observadorSuperficies);
            }
        }
    }

    public GridPane getGrilla(){

        return grilla;

    }

    public Posicion getPosicionBaldosa (){

        return posicion;

    }


    public void actualizarVista(SuperficieAerea superficie, Posicion posicion) {

        verificarCasillero(superficie,posicion);

    }

    public void actualizarVista(SuperficieTerrestre superficie, Posicion posicion) {

        verificarCasillero(superficie,posicion);

    }

    public void actualizarVista(AlgoFormer algoformer, Posicion posicion) {

       verificarCasillero(algoformer,posicion);

    }

    public void actualizarVista(Contenido contenido, Posicion posicion) {

        verificarCasillero(contenido,posicion);

    }


   private void verificarCasillero(AlgoFormer algoformer,Posicion posicion){

       if (algoformer == NoOcupado.getInstance()){
           baldosas[posicion.getX()][posicion.getY()].getBaldosa().setId("boton");
       }
       if (algoformer.getNombre() == "Optimus Prime") {
           baldosas[posicion.getX()][posicion.getY()].getBaldosa().setId("optimus");
       }
       if (algoformer.getNombre() == "Megatron"){
           baldosas[posicion.getX()][posicion.getY()].getBaldosa().setId("optimus");
       }


   }

    private void verificarCasillero(Contenido contenido,Posicion posicion){

        if (contenido.esLaChispaSuprema(ChispaSuprema.getInstance())){

            baldosas [posicion.getX()] [posicion.getY()].getBaldosa().setId("optimus");

        }

    }

    private void verificarCasillero(SuperficieAerea superficie,Posicion posicion){

       if (superficie instanceof NebulosaAndromeda){

           baldosas [posicion.getX()] [posicion.getY()].getBaldosa().setId("optimus");

       }

    }

    private void verificarCasillero(SuperficieTerrestre superficie,Posicion posicion){

        if (superficie instanceof Pantano){

            baldosas [posicion.getX()] [posicion.getY()].getBaldosa().setId("optimus");

        }

    }


    @Override
    public void actualizarAlgoformers(AlgoFormer algoFormer) {

    }
}
