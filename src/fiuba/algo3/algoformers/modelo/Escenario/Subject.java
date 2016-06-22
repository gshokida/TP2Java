package fiuba.algo3.algoformers.modelo.Escenario;


import fiuba.algo3.algoformers.view2.Control.Observer;

/**
 * Created by Rodrigo on 21/06/2016.
 */
public interface Subject {

    void agregarSubscriptor (Observer observer);

    void borrarSubscriptor (Observer observer);

    void notificar ();

}