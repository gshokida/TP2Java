package fiuba.algo3.algoformers.view2.VistaJuego;


import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.Contenido;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
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
public class PanelCentralMapa {

    private GridPane grilla;
    private Posicion posicion;
    private Baldosa baldosas [][];
    private Juego juego;
    private ObservadorAlgoformer observadorAlgoformer;
    private ObservadorContenido observadorContenido;
    private ObservadorSuperficies observadorSuperficies;





    public PanelCentralMapa(Juego juego, PosicionOriginal posicionOriginal){

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
                    cargarPosicion(posicionOriginal);
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

    private void cargarPosicion (PosicionOriginal posicionOriginal) {

        posicionOriginal.setAlgoFormer(juego.getTablero().getCasillero(getPosicionBaldosa()).getAlgoformer());
        posicionOriginal.setPosicion(getPosicionBaldosa());
        System.out.println(posicionOriginal.getAlgoFormer());
        System.out.println("Posicion" + posicionOriginal.getPosicion().getX()+"y"+ posicionOriginal.getPosicion().getY());

    }

    private void comenzarMapa (){

        for (int i = 0; i < juego.getColumnas(); i++) {
            for (int j = 0; j < juego.getFilas(); j++) {

               if(juego.getTablero().getCasillero(baldosas [i] [j].getPosicion()).getAlgoformer().getNombre() == "Optimus Prime"){

                    baldosas [i] [j].setEstilo("optimus");

               }
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



    }

    public void actualizarVista(SuperficieTerrestre superficie, Posicion posicion) {



    }

    public void actualizarVista(AlgoFormer algoformer, Posicion posicion) {

        if (algoformer.getNombre() == "Optimus Prime") {
            baldosas[posicion.getX()][posicion.getY()].getBaldosa().setId("optimus");
        }
        if (algoformer == NoOcupado.getInstance()){
            baldosas[posicion.getX()][posicion.getY()].getBaldosa().setId("boton");
        }
    }

    public void actualizarVista(Contenido contenido, Posicion posicion) {



    }



}
