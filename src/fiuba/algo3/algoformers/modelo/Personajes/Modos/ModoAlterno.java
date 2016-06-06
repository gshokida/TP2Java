package fiuba.algo3.algoformers.modelo.Personajes.Modos;

/**
 * Created by gaston.tulipani on 06/06/2016.
 */
public class ModoAlterno implements Modo {
    private static ModoAlterno unicaInstancia = new ModoAlterno();

    private ModoAlterno() {}

    public static ModoAlterno getInstance() {
        return unicaInstancia;
    }

    public boolean esModo(Modo modo) {
        return modo == unicaInstancia;
    }
}
