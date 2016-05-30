package fiuba.algo3.algoformers.modelo.Escenario.Superficies;

/**
 * Created by german.shokida on 30/5/2016.
 */
public class NebulosaAndromeda implements SuperficieAerea {
    private static SuperficieAerea nebulosaAndromeda;

    private NebulosaAndromeda() {

    }

    public static SuperficieAerea getInstance() {
        if (NebulosaAndromeda.nebulosaAndromeda == null)
            NebulosaAndromeda.nebulosaAndromeda = new NebulosaAndromeda();

        return NebulosaAndromeda.nebulosaAndromeda;
    }
}
