package fiuba.algo3.algoformers.modelo.Integracion.IntegracionEntrega2;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.HumanoideNoPuedeAtravesarPantanoException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Movimiento;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by gaston.tulipani on 09/06/2016.
 */
public class IntegracionEntrega2_ZonaRocosa {
    @Test
    public void optimusHumanoideAtraviesaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre rocosa = new TierraRocosa();
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }


        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void optimusAlternoAtraviesaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre rocosa = new TierraRocosa();
        algoFormer.transformar();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void bumblebeeHumanoideAtraviesaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieTerrestre rocosa = new TierraRocosa();
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }


        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void bumblebeeAlternoAtraviesaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre rocosa = new TierraRocosa();
        algoFormer.transformar();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void ratchetHumanoideAtraviesaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoFinal = new Posicion(0, 1);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre rocosa = new TierraRocosa();
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void ratchetAlternoAtraviesaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre rocosa = new TierraRocosa();
        algoFormer.transformar();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void megatronHumanoideAtraviesaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoFinal = new Posicion(0, 1);
        AlgoFormer algoFormer = new Megatron();
        SuperficieTerrestre rocosa = new TierraRocosa();
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void megatronAlternoAtraviesaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Megatron();
        SuperficieTerrestre rocosa = new TierraRocosa();
        algoFormer.transformar();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void bonecrusherHumanoideAtraviesaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoFinal = new Posicion(0, 1);
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre rocosa = new TierraRocosa();
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);

        try {

            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void bonecrusherAlternoAtraviesaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre rocosa = new TierraRocosa();
        algoFormer.transformar();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        try {

            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void frenzyHumanoideAtraviesaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre rocosa = new TierraRocosa();
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void frenzyAlternoAtraviesaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre rocosa = new TierraRocosa();
        algoFormer.transformar();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }
}
