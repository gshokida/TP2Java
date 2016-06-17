package fiuba.algo3.algoformers.modelo.Integracion.IntegracionEntrega2;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.HumanoideNoPuedeAtravesarPantanoException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Pantano;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Movimiento;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gaston.tulipani on 09/06/2016.
 */
public class IntegracionEntrega2_ZonaPantano_ModoAlterno {
    @Test
    public void optimusAlternoIngresaSinProblemas_verificoPosicionFinal() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void optimusAlternoIngresaYSeMueveSoloUnPaso_meQuedanMovimientos() {

        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_pantano = new Pantano();
        SuperficieTerrestre superficieFinal_pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia).setSuperficieTerreste(superficieIntermedia_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(superficieFinal_pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia)); //me muevo al casillero con Pantano y sufro efecto
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertTrue(movimiento.quedanMovimientos());
    }

    @Test
    public void optimusAlternoIngresaYSeMueveDosPasos_noMeQuedanMovimientos() {

        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia_1 = new Posicion(0, 1);
        Posicion posicionIntermedia_2 = new Posicion(0, 2);
        Posicion posicionDestinoFinal = new Posicion(0, 3);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_1_pantano = new Pantano();
        SuperficieTerrestre superficieIntermedia_2_pantano = new Pantano();
        SuperficieTerrestre superficieFinalFinal_pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia_1).setSuperficieTerreste(superficieIntermedia_1_pantano);
        tablero.getCasillero(posicionIntermedia_2).setSuperficieTerreste(superficieIntermedia_2_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(superficieFinalFinal_pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia_1)); //me muevo al casillero con Pantano y sufro efecto
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia_2));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
            fail();
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            success();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }
    }

    @Test
    public void bumblebeeAlternoIngresaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void bumblebeeAlternoIngresaYSeMueveSoloUnPaso_meQuedanMovimientos() {

        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_pantano = new Pantano();
        SuperficieTerrestre superficieFinal_pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia).setSuperficieTerreste(superficieIntermedia_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(superficieFinal_pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia)); //me muevo al casillero con Pantano y sufro efecto
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertTrue(movimiento.quedanMovimientos());
    }

    @Test
    public void bumblebeeAlternoIngresaYSeMueveDosPasos_noMeQuedanMovimientos() {

        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia_1 = new Posicion(0, 1);
        Posicion posicionIntermedia_2 = new Posicion(0, 2);
        Posicion posicionDestinoFinal = new Posicion(0, 3);
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_1_pantano = new Pantano();
        SuperficieTerrestre superficieIntermedia_2_pantano = new Pantano();
        SuperficieTerrestre superficieFinalFinal_pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia_1).setSuperficieTerreste(superficieIntermedia_1_pantano);
        tablero.getCasillero(posicionIntermedia_2).setSuperficieTerreste(superficieIntermedia_2_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(superficieFinalFinal_pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia_1)); //me muevo al casillero con Pantano y sufro efecto
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia_2));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
            fail();
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            success();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }
    }

    @Test
    public void bonecrusherAlternoIngresaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void bonecrusherAlternoIngresaYSeMueveSoloUnPaso_meQuedanMovimientos() {

        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_pantano = new Pantano();
        SuperficieTerrestre superficieFinal_pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia).setSuperficieTerreste(superficieIntermedia_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(superficieFinal_pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia)); //me muevo al casillero con Pantano y sufro efecto
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertTrue(movimiento.quedanMovimientos());
    }

    @Test
    public void bonecrusherAlternoIngresaYSeMueveSoloDosPasos_meQuedanMovimientos() {

        Tablero tablero = new Tablero(7,7);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia_1 = new Posicion(0, 1);
        Posicion posicionIntermedia_2 = new Posicion(0, 2);
        Posicion posicionDestinoFinal = new Posicion(0, 3);
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_1_pantano = new Pantano();
        SuperficieTerrestre superficieIntermedia_2_pantano = new Pantano();
        SuperficieTerrestre superficieFinalFinal_pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia_1).setSuperficieTerreste(superficieIntermedia_1_pantano);
        tablero.getCasillero(posicionIntermedia_2).setSuperficieTerreste(superficieIntermedia_2_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(superficieFinalFinal_pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia_1)); //me muevo al casillero con Pantano y sufro efecto
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia_2));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertTrue(movimiento.quedanMovimientos());
    }

    @Test
    public void bonecrusherAlternoIngresaYSeMueveTresPasos_noMeQuedanMovimientos() {

        Tablero tablero = new Tablero(7,7);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia_1 = new Posicion(0, 1);
        Posicion posicionIntermedia_2 = new Posicion(0, 2);
        Posicion posicionIntermedia_3 = new Posicion(0, 3);
        Posicion posicionDestinoFinal = new Posicion(0, 4);
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_1_pantano = new Pantano();
        SuperficieTerrestre superficieIntermedia_2_pantano = new Pantano();
        SuperficieTerrestre superficieIntermedia_3_pantano = new Pantano();
        SuperficieTerrestre superficieFinalFinal_pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia_1).setSuperficieTerreste(superficieIntermedia_1_pantano);
        tablero.getCasillero(posicionIntermedia_2).setSuperficieTerreste(superficieIntermedia_2_pantano);
        tablero.getCasillero(posicionIntermedia_3).setSuperficieTerreste(superficieIntermedia_3_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(superficieFinalFinal_pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia_1)); //me muevo al casillero con Pantano y sufro efecto
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia_2));
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia_3));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertFalse(movimiento.quedanMovimientos());
    }

    @Test
    public void frenzyAlternoIngresaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void frenzyAlternoIngresaYSeMueveSoloUnPaso_meQuedanMovimientos() {

        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_pantano = new Pantano();
        SuperficieTerrestre superficieFinal_pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia).setSuperficieTerreste(superficieIntermedia_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(superficieFinal_pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia)); //me muevo al casillero con Pantano y sufro efecto
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertTrue(movimiento.quedanMovimientos());
    }

    @Test
    public void frenzyAlternoIngresaYSeMueveDosPasos_noMeQuedanMovimientos() {

        Tablero tablero = new Tablero(7,7);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia_1 = new Posicion(0, 1);
        Posicion posicionIntermedia_2 = new Posicion(0, 2);
        Posicion posicionDestinoFinal = new Posicion(0, 3);
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_1_pantano = new Pantano();
        SuperficieTerrestre superficieIntermedia_2_pantano = new Pantano();
        SuperficieTerrestre superficieFinalFinal_pantano = new Pantano();
        algoFormer.transformar();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia_1).setSuperficieTerreste(superficieIntermedia_1_pantano);
        tablero.getCasillero(posicionIntermedia_2).setSuperficieTerreste(superficieIntermedia_2_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(superficieFinalFinal_pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia_1)); //me muevo al casillero con Pantano y sufro efecto
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia_2));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertFalse(movimiento.quedanMovimientos());
    }

    private void success() {
        assertTrue(true);
    }
}
