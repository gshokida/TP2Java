package fiuba.algo3.algoformers.modelo.Personajes.Bandos;

/**
 * Created by Hennico on 29/5/2016.
 */
public class BandoAutobots implements Bando {



    private static BandoAutobots unicaInstancia = new BandoAutobots();




    private BandoAutobots() {

    }

    public static BandoAutobots instancia() {
        return unicaInstancia;
    }

    public boolean esMismoBando(Bando bando) {
        return this.equals(bando);
    }


}
