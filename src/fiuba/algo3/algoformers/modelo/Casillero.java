package fiuba.algo3.algoformers.modelo;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class Casillero {
    private Contenido contenido;
    private SuperficieTerrestre superficieTerreste;

    public void setContenido(Contenido contenido){
        this.contenido = contenido;
    }

    public Contenido getContenido(){
        return this.contenido;
    }

    public void setSuperficieTerreste(SuperficieTerrestre superficieTerreste) {
        this.superficieTerreste = superficieTerreste;
    }

    public SuperficieTerrestre getSuperficieTerreste() {
        return this.superficieTerreste;
    }
}
