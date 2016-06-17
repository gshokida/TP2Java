package fiuba.algo3.algoformers.modelo.Integracion.IntegracionEntrega2;

import fiuba.algo3.algoformers.modelo.Errores.*;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Pantano;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Movimiento;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Rodrigo on 08/06/2016.
 */
public class IntegracionEntrega2_CasosEspeciales {
    @Test
    public void optimusAlternoNoIngresaAPantanoSinProblemas_seTransforma_lanzaError() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_pantano = new Pantano();
        SuperficieTerrestre superficieFinal_pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia).setSuperficieTerreste(superficieIntermedia_pantano);
        tablero.getCasillero(posicionFinal).setSuperficieTerreste(superficieFinal_pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            success();
        }

        algoFormer.pasarTurno();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();

        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionIntermedia));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }
    }

    @Test
    public void optimusHumanoideNoIngresaAPantano_seTransforma_sePuedeMover_verificoPosicionFinal() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre superficieInicio_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_pantano = new Pantano();
        SuperficieTerrestre superficieFinal_pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicio_rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(superficieIntermedia_pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            success();
        }

        algoFormer.pasarTurno();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionInicio), algoFormer);

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoIntermedio).getAlgoformer());
    }

    private void success() {
        assertTrue(true);
    }
}
