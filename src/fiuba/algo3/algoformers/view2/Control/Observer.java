package fiuba.algo3.algoformers.view2.Control;

import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.Contenido;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;

/**
 * Created by Rodrigo on 21/06/2016.
 */
public interface Observer {

    void update (AlgoFormer algoFormer, Posicion posicion);

    void update (Contenido contenido, Posicion posicion);

    void update (SuperficieAerea superficie, Posicion posicion);

    void update (SuperficieTerrestre superficie, Posicion posicion);


}
