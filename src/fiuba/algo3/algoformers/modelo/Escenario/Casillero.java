package fiuba.algo3.algoformers.modelo.Escenario;

import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class Casillero {
    private Contenido contenido;
    private SuperficieTerrestre superficieTerreste;
    private SuperficieAerea superficieAerea;


    public void setContenido(Contenido contenido){
        this.contenido = contenido;
    }

    public Contenido getContenido(){
        return contenido;
    }

    public void setSuperficieTerreste(SuperficieTerrestre superficieTerreste) {
        this.superficieTerreste = superficieTerreste;
    }

    public SuperficieTerrestre getSuperficieTerreste() {
        return superficieTerreste;
    }

    public void setSuperficieAerea(SuperficieAerea superficieAerea) {
        this.superficieAerea = superficieAerea;
    }

    public SuperficieAerea getSuperficieAerea() {
        return superficieAerea;
    }

    public boolean estaOcupado() {
        return (!getContenido().equals(ContenidoVacio.getInstance()));
    }
}
