package fiuba.algo3.algoformers.view2.VistaMenuPrincipal.Sonidos;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rodrigo on 16/06/2016.
 */
public class Musica {

   List<String> musica;
    List<MediaPlayer> reproductor;
    MediaPlayer media;
    private MediaView mediaView;


    public Musica (){

        musica = new LinkedList<>();
        reproductor = new LinkedList<>();

    }



    public void reproducirMusica() {

        listaReproduccion();
        reproductor();

         mediaView = new MediaView(reproductor.get(0));
        mediaView.getMediaPlayer().play();

        for (int i = 0; i < reproductor.size(); i++) {
            final MediaPlayer player     = reproductor.get(i);
            final MediaPlayer nextPlayer = reproductor.get((i + 1) % reproductor.size());
            player.setOnEndOfMedia(new Runnable() {
                @Override public void run() {
                    player.stop();
                    mediaView.setMediaPlayer(nextPlayer);
                    nextPlayer.play();
                }
            });
        }
    }



    private void listaReproduccion() {

        musica.add("src/GUI/Recursos/Sonidos/ND.mp3");
        musica.add("src/GUI/Recursos/Sonidos/PR.mp3");
       musica.add("src/GUI/Recursos/Sonidos/LP.mp3");

    }

    private void reproductor() {

        for (String track : musica) {

            Media media = new Media(new File(track).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            reproductor.add(mediaPlayer);

        }

    }


    public void pausa() {

       media = mediaView.getMediaPlayer();
        media.pause();

    }

    public void continuar() {

        media = mediaView.getMediaPlayer();
        media.play();

    }
}
