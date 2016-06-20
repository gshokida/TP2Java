package fiuba.algo3.algoformers.view;

import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.TormentaPsionica;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Pantano;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.view.Eventos.EventoImprimirNombreEnConsola;
import fiuba.algo3.algoformers.view.imagenes.ImageHelper;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Created by Hennico on 18/6/2016.
 */
public class ViewCasillero extends BorderPane {
    private static Image imgPastoFonfo = new Image(ImageHelper.getImagePath("PastoFondo.png"));
    private static Image imgPantano = new Image(ImageHelper.getImagePath("Pantano.png"));
    private static Image imgTerrenoRocoso = new Image(ImageHelper.getImagePath("TerrenoRocoso.png"));
    private static Image imgTormentaPsionica = new Image(ImageHelper.getImagePath("TormentaPsionica.png"));

    private static Image imgOwlowiscious = new Image(ImageHelper.getImagePath("owlowiscious.gif"));
    private static Image imgTwilight = new Image(ImageHelper.getImagePath("twilight.gif"));

    private ImageView fondo;
    private ImageView contenido;
    private ImageView cielo;

    private Casillero casillero;

    public ViewCasillero(Casillero casillero) {
        fondo = new ImageView();
        contenido = new ImageView();
        cielo = new ImageView();
        this.casillero = casillero;

        ImageView[] images = new ImageView[] {fondo, contenido, cielo};
        setCenter(new Pane(images));

        actualizarCasillero();
    }

    private void actualizarCasillero() {
        SuperficieTerrestre superTerrestre = casillero.getSuperficieTerreste();
        SuperficieAerea superficieAerea = casillero.getSuperficieAerea();
        AlgoFormer algoFormer = casillero.getAlgoformer();

        if (superTerrestre instanceof TierraRocosa)
            fondo.setImage(imgTerrenoRocoso);
        else if (superTerrestre instanceof Pantano)
            fondo.setImage(imgPantano);
        else
            fondo.setImage(imgPastoFonfo);

        if (superficieAerea instanceof TormentaPsionica)
            cielo.setImage(imgTormentaPsionica);

        if (!(algoFormer instanceof NoOcupado)) {
            generarAlgoformer(algoFormer);
        }
    }


    private void generarAlgoformer(AlgoFormer algoFormer) {
        if (algoFormer.getBando().esMismoBando(BandoAutobots.getInstance()))
            contenido.setImage(imgOwlowiscious);
        else
            contenido.setImage(imgTwilight);

        contenido.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventoImprimirNombreEnConsola(algoFormer.getNombre()));
    }
}
