package fiuba.algo3.algoformers.modelo.Escenario;



import fiuba.algo3.algoformers.modelo.Errores.HumanoideNoPuedeAtravesarPantanoException;
import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.Contenido;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.Nube;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.NoOcupado;
import fiuba.algo3.algoformers.view2.Control.Observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by german.shokida on 27/5/2016.
 */
public class Casillero implements Subject {
    private Contenido contenido;
    private AlgoFormer algoformer;
    private SuperficieTerrestre superficieTerreste;
    private SuperficieAerea superficieAerea;
    private Posicion posicion;
    private List<Observer> subscritos;

    public Casillero(Posicion posicion) {
        this.contenido = ContenidoVacio.getInstance();
        this.algoformer = NoOcupado.getInstance();
        this.posicion = posicion;
        this.superficieTerreste = new TierraRocosa();
        this.superficieAerea = new Nube();
        subscritos = new LinkedList<>();
    }

    public void setContenido(Contenido contenido){
        this.contenido = contenido;
    }

    public Contenido getContenido(){
        return contenido;
    }

    public void setAlgoformer(AlgoFormer algoformer) throws HumanoideNoPuedeAtravesarPantanoException {
        if (algoformer.equals(NoOcupado.getInstance())){
            this.algoformer = algoformer;
        }
        else {
            try {
                this.superficieAerea.interactuar(algoformer);
            } catch (NoPuedeInteractuarConSuperficieException e) {
                try {
                    this.superficieTerreste.interactuar(algoformer);
                } catch (NoPuedeInteractuarConSuperficieException e1) {
                }
            }

            if(!this.contenido.equals(ContenidoVacio.getInstance())){
                this.contenido.interactuar(algoformer);
                this.contenido = ContenidoVacio.getInstance();
            }

            this.algoformer = algoformer;
        }
    }

    public AlgoFormer getAlgoformer(){
        return this.algoformer;
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
        return (!getContenido().equals(ContenidoVacio.getInstance()))||(!getAlgoformer().equals(NoOcupado.getInstance()));
    }

    public Posicion getPosicion() { return posicion; }

    @Override
    public void agregarSubscriptor(Observer observer) {
        subscritos.add(observer);
    }

    @Override
    public void borrarSubscriptor(Observer observer) {

         this.subscritos.remove(this.subscritos.indexOf(observer));

    }

    @Override
    public void notificar() {

        if (!subscritos.isEmpty()) {
            for (Observer observados : subscritos) {

                observados.update(algoformer, posicion);
                observados.update(contenido, posicion);
                observados.update(superficieTerreste, posicion);
                observados.update(superficieAerea, posicion);

            }
        }
    }
}
