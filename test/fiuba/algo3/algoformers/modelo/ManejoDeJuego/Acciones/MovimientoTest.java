package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Escenario.Casillero;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.NebulosaAndromeda;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Ratchet;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gaston.tulipani on 03/06/2016.
 */
public class MovimientoTest {
    @Test
    public void moverHasta_conCasilleroDestinoADistanciaMenorALaDistanciaMaxima_poneConenidoEnDestino() {
        AlgoFormer algoFormer = new Optimus();
        int distanciaMaxima = algoFormer.getVelocidad();

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaMaxima - 1,0));

        casilleroOrigen.setAlgoformer(algoFormer);

        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento.moverHasta(casilleroDestino);
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException ex) {
            fail();
        }

        assertEquals(casilleroDestino.getAlgoformer(), algoFormer);
    }

    @Test
    public void moverHasta_conCasilleroDestinoADistanciaMenorALaDistanciaMaxima_vaciaPrimerCasillero() {
        AlgoFormer algoFormer = new Optimus();
        int distanciaMaxima = algoFormer.getVelocidad();

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaMaxima - 1,0));

        casilleroOrigen.setAlgoformer(algoFormer);
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento.moverHasta(casilleroDestino);
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException ex) {
            fail();
        }

        assertEquals(casilleroOrigen.getContenido(), ContenidoVacio.getInstance());
    }


    @Test
    public void moverHasta_conCasilleroDestinoADistanciaMayorALaDistanciaMaxima_lanzaError() {
        AlgoFormer algoFormer = new Optimus();
        int distanciaMaxima = algoFormer.getVelocidad();

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaMaxima + 1,0));

        casilleroOrigen.setAlgoformer(algoFormer);
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (DistanciaExcedidaException ex) {
            succes();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }
    }

    @Test
    public void moverHasta_haciendoVariasEscalas_superandoDistanciaMaximaDesdeOrigenHastaDestinoFinal_lanzaError() {
        Tablero tablero = new Tablero(7,7);
        AlgoFormer algoFormer = new Optimus();
        algoFormer.transformar(); //No existe AlgoFormer con velocidad 3 sin transformar
        int distanciaMaxima = algoFormer.getVelocidad();

        Posicion posicionOrigen = new Posicion(0,0);
        Posicion posicionDestinoIntermedio = new Posicion(1,0);
        Posicion posicionDestinoIntermedioDos = new Posicion(2,0);
        Posicion posicionDestinoIntermedioTres = new Posicion(3,0);
        Posicion posicionDestinoIntermedioCuatro = new Posicion(4,0);
        Posicion posicionDestinoFinal = new Posicion(5, 0);
        Posicion posicionExcedida = new Posicion(6, 0);

        tablero.setAlgoformer(algoFormer, posicionOrigen);

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionOrigen), algoFormer);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedioDos));
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedioTres));
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedioCuatro));
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionExcedida));
            fail();
        }
        catch (DistanciaExcedidaException ex) {
            succes();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }
    }

    @Test
    public void nuevoMovimiento_quedanMovimientos_esVerdadero(){
        AlgoFormer algoFormer = new Optimus();
        int distanciaMaxima = algoFormer.getVelocidad();

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        casilleroOrigen.setAlgoformer(algoFormer);
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        assertTrue(movimiento.quedanMovimientos());
    }

    @Test
    public void quedanMovimientos_cuandoSeMovioDistanciaMenorAMaxima_esVerdadero() {
        AlgoFormer algoFormer = new Optimus();
        int distanciaMaxima = algoFormer.getVelocidad();

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaMaxima - 1,0));

        casilleroOrigen.setAlgoformer(algoFormer);
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento.moverHasta(casilleroDestino);
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }

        assertTrue(movimiento.quedanMovimientos());
    }

    @Test
    public void quedanMovimientos_cuandoSeMovioDistanciaMaxima_esFalso() {
        Tablero tablero = new Tablero(3,3);
        AlgoFormer algoFormer = new Optimus();
        int distanciaMaxima = algoFormer.getVelocidad();

        Posicion posicionOrigen = new Posicion(0,0);
        Posicion posicionDestinoIntermedio = new Posicion(1,0);
        Posicion posicionDestinoFinal = new Posicion(2,0);

        SuperficieTerrestre rocosa = new TierraRocosa();

        tablero.getCasillero(posicionOrigen).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);

        tablero.setAlgoformer(algoFormer,posicionOrigen);

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionOrigen), algoFormer);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }

        assertFalse(movimiento.quedanMovimientos());
    }

    @Test
    public void ratchetAlterno_EfectoNebulosaAndromeda_nuevoMovimiento_lanzaError(){
        AlgoFormer algoFormer = new Ratchet();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        SuperficieAerea nebulosaAndromeda = new NebulosaAndromeda();
        try {
            nebulosaAndromeda.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }
        int distanciaMaxima = algoFormer.getVelocidad();
        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        casilleroOrigen.setAlgoformer(algoFormer);
        Casillero casilleroDestino = new Casillero(new Posicion(1,0));
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            succes();
        }
    }

    @Test
    public void ratchetAlterno_EfectoNebulosaAndromeda_pasaTurno_nuevoMovimiento_lanzaError(){
        AlgoFormer algoFormer = new Ratchet();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        SuperficieAerea nebulosaAndromeda = new NebulosaAndromeda();
        try {
            nebulosaAndromeda.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }
        int distanciaMaxima = algoFormer.getVelocidad();
        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        casilleroOrigen.setAlgoformer(algoFormer);
        Casillero casilleroDestino = new Casillero(new Posicion(1,0));
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            succes();
        }

        algoFormer.pasarTurno();

        try {
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            succes();
        }
    }

    @Test
    public void ratchetAlterno_EfectoNebulosaAndromeda_pasaTurnoDosVeces_nuevoMovimiento_lanzaError(){
        AlgoFormer algoFormer = new Ratchet();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        SuperficieAerea nebulosaAndromeda = new NebulosaAndromeda();
        try {
            nebulosaAndromeda.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }
        int distanciaMaxima = algoFormer.getVelocidad();
        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        casilleroOrigen.setAlgoformer(algoFormer);
        Casillero casilleroDestino = new Casillero(new Posicion(1,0));
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            succes();
        }

        algoFormer.pasarTurno();

        try {
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            succes();
        }

        algoFormer.pasarTurno();

        try {
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            succes();
        }
    }

    @Test
    public void ratchetAlterno_EfectoNebulosaAndromeda_pasaTurnoTresVeces_nuevoMovimiento_verificoCasilleroDestino(){
        AlgoFormer algoFormer = new Ratchet();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        SuperficieAerea nebulosaAndromeda = new NebulosaAndromeda();
        try {
            nebulosaAndromeda.interactuar(algoFormer);
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }
        int distanciaMaxima = algoFormer.getVelocidad();
        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        casilleroOrigen.setAlgoformer(algoFormer);
        Casillero casilleroDestino = new Casillero(new Posicion(1,0));
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            succes();
        }

        algoFormer.pasarTurno();

        Movimiento movimiento2 = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento2.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            succes();
        }

        algoFormer.pasarTurno();

        Movimiento movimiento3 = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento3.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            succes();
        }

        algoFormer.pasarTurno();
        Movimiento movimiento4 = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento4.moverHasta(casilleroDestino);
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException error) {
            fail();
        }

        assertEquals(casilleroDestino.getAlgoformer(), algoFormer);
    }

    private void succes() {
        assertTrue(true);
    }
}
