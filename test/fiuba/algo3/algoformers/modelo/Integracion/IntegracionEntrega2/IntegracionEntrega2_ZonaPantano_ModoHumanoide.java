package fiuba.algo3.algoformers.modelo.Integracion.IntegracionEntrega2;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by gaston.tulipani on 09/06/2016.
 */
public class IntegracionEntrega2_ZonaPantano_ModoHumanoide {
    @Test
    public void optimusHumanoideIngresaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void bumblebeeHumanoideIngresaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void ratchetHumanoideIngresaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void ratchetHumanoideIngresaYNoSePuedeMover_lanzaError() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre posicionInicio_rocosa = new TierraRocosa();
        SuperficieTerrestre posicionIntermedia_pantano = new Pantano();
        SuperficieTerrestre posicionFinal_pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(posicionInicio_rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(posicionIntermedia_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(posicionFinal_pantano);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionDestinoIntermedio),algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionDestinoFinal));
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (DistanciaExcedidaException e) {
            success();
        }
    }

    @Test
    public void megatronHumanoideIngresaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Megatron();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void megatronHumanoideIngresaYNoSePuedeMover_lanzaError() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Megatron();
        SuperficieTerrestre posicionInicio_rocosa = new TierraRocosa();
        SuperficieTerrestre posicionIntermedia_pantano = new Pantano();
        SuperficieTerrestre posicionFinal_pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(posicionInicio_rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(posicionIntermedia_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(posicionFinal_pantano);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionDestinoIntermedio),algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionDestinoFinal));
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (DistanciaExcedidaException e) {
            success();
        }
    }

    @Test
    public void bonecrusherHumanoideIngresaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void bonecrusherHumanoideIngresaYNoSePuedeMover_lanzaError() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre posicionInicio_rocosa = new TierraRocosa();
        SuperficieTerrestre posicionIntermedia_pantano = new Pantano();
        SuperficieTerrestre posicionFinal_pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(posicionInicio_rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(posicionIntermedia_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(posicionFinal_pantano);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionDestinoIntermedio),algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionDestinoFinal));
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (DistanciaExcedidaException e) {
            success();
        }
    }

    @Test
    public void frenzyHumanoideIngresaSinProblemas_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }


    /*
    @Test
    public void bumblebeeHumanoideIngresaYNoSePuedeMover_lanzaError() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieTerrestre posicionInicio_rocosa = new TierraRocosa();
        SuperficieTerrestre posicionIntermedia_pantano = new Pantano();
        SuperficieTerrestre posicionFinal_pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(posicionInicio_rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(posicionIntermedia_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(posicionFinal_pantano);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionDestinoIntermedio),algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionDestinoFinal));
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (DistanciaExcedidaException e) {
            success();
        }
    }

    @Test
    public void optimusHumanoideIngresaYNoSePuedeMover_lanzaError() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre posicionInicio_rocosa = new TierraRocosa();
        SuperficieTerrestre posicionIntermedia_pantano = new Pantano();
        SuperficieTerrestre posicionFinal_pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(posicionInicio_rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(posicionIntermedia_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(posicionFinal_pantano);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (DistanciaExcedidaException e) {
            success();
        }
    }

    @Test
    public void frenzyHumanoideIngresaYNoSePuedeMover_lanzaError() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre posicionInicio_rocosa = new TierraRocosa();
        SuperficieTerrestre posicionIntermedia_pantano = new Pantano();
        SuperficieTerrestre posicionFinal_pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(posicionInicio_rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(posicionIntermedia_pantano);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(posicionFinal_pantano);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionDestinoIntermedio),algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionDestinoFinal));
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (DistanciaExcedidaException e) {
            success();
        }
    }
    */
    private void success() {
        assertTrue(true);
    }
}
