package fiuba.algo3.algoformers.modelo.Personajes.Modos;

/**
 * Created by gaston.tulipani on 06/06/2016.
 */
public class ModoHumanoide implements Modo {
    private static ModoHumanoide unicaInstancia = new ModoHumanoide();

    private ModoHumanoide() {}

    public static ModoHumanoide getInstance() {
        return unicaInstancia;
    }

    public boolean esModo(Modo modo) {
        return modo == unicaInstancia;
    }
}
