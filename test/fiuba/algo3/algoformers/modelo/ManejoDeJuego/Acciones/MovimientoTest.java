package fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.HumanoideNoPuedeAtravesarPantanoException;
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

        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            casilleroOrigen.setAlgoformer(algoFormer);

            movimiento.moverHasta(casilleroDestino);
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException ex) {
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

        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            casilleroOrigen.setAlgoformer(algoFormer);
            movimiento.moverHasta(casilleroDestino);
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException ex) {
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

        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            casilleroOrigen.setAlgoformer(algoFormer);
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (DistanciaExcedidaException ex) {
            success();
        } catch (ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }
    }

    @Test
    public void moverHasta_haciendoVariasEscalas_superandoDistanciaMaximaDesdeOrigenHastaDestinoFinal_lanzaError() {
        Tablero tablero = new Tablero(7,7);
        AlgoFormer algoFormer = new Optimus();
        algoFormer.transformar(); //No existe AlgoFormer con velocidad 3 sin transformar

        Posicion posicionOrigen = new Posicion(0,0);
        Posicion posicionDestinoIntermedio = new Posicion(1,0);
        Posicion posicionDestinoIntermedioDos = new Posicion(2,0);
        Posicion posicionDestinoIntermedioTres = new Posicion(3,0);
        Posicion posicionDestinoIntermedioCuatro = new Posicion(4,0);
        Posicion posicionDestinoFinal = new Posicion(5, 0);
        Posicion posicionExcedida = new Posicion(6, 0);


        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionOrigen), algoFormer);

        try {
            tablero.setAlgoformer(algoFormer, posicionOrigen);
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedioDos));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedioTres));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedioCuatro));
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionExcedida));
            fail();
        }
        catch (DistanciaExcedidaException ex) {
            success();
        } catch (ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }
    }

    @Test
    public void nuevoMovimiento_quedanMovimientos_esVerdadero(){
        AlgoFormer algoFormer = new Optimus();

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        try {
            casilleroOrigen.setAlgoformer(algoFormer);
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        assertTrue(movimiento.quedanMovimientos());
    }

    @Test
    public void quedanMovimientos_cuandoSeMovioDistanciaMenorAMaxima_esVerdadero() {
        AlgoFormer algoFormer = new Optimus();
        int distanciaMaxima = algoFormer.getVelocidad();

        Casillero casilleroOrigen = new Casillero(new Posicion(0,0));
        Casillero casilleroDestino = new Casillero(new Posicion(distanciaMaxima - 1,0));

        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            casilleroOrigen.setAlgoformer(algoFormer);
            movimiento.moverHasta(casilleroDestino);
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
            fail();
        }

        assertTrue(movimiento.quedanMovimientos());
    }

    @Test
    public void quedanMovimientos_cuandoSeMovioDistanciaMaxima_esFalso() {
        Tablero tablero = new Tablero(3,3);
        AlgoFormer algoFormer = new Optimus();

        Posicion posicionOrigen = new Posicion(0,0);
        Posicion posicionDestinoIntermedio = new Posicion(1,0);
        Posicion posicionDestinoFinal = new Posicion(2,0);

        SuperficieTerrestre rocosa = new TierraRocosa();

        tablero.getCasillero(posicionOrigen).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieTerreste(rocosa);



        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionOrigen), algoFormer);

        try {
            tablero.setAlgoformer(algoFormer,posicionOrigen);

            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));

            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
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
        Casillero casilleroDestino = new Casillero(new Posicion(1,0));
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            casilleroOrigen.setAlgoformer(algoFormer);
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            success();
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
        Casillero casilleroDestino = new Casillero(new Posicion(1,0));
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            casilleroOrigen.setAlgoformer(algoFormer);
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            success();
        }

        algoFormer.pasarTurno();

        try {
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            success();
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
        Casillero casilleroDestino = new Casillero(new Posicion(1,0));
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            casilleroOrigen.setAlgoformer(algoFormer);
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            success();
        }

        algoFormer.pasarTurno();

        try {
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            success();
        }

        algoFormer.pasarTurno();

        try {
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            success();
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
        Casillero casilleroDestino = new Casillero(new Posicion(1,0));
        Movimiento movimiento = new Movimiento(casilleroOrigen, algoFormer);

        try {
            casilleroOrigen.setAlgoformer(algoFormer);
            movimiento.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            success();
        }

        algoFormer.pasarTurno();

        Movimiento movimiento2 = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento2.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            success();
        }

        algoFormer.pasarTurno();

        Movimiento movimiento3 = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento3.moverHasta(casilleroDestino);
            fail();
        }
        catch (ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
            fail();
        }
        catch (DistanciaExcedidaException error) {
            success();
        }

        algoFormer.pasarTurno();
        Movimiento movimiento4 = new Movimiento(casilleroOrigen, algoFormer);

        try {
            movimiento4.moverHasta(casilleroDestino);
        }
        catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException error) {
            fail();
        }

        assertEquals(casilleroDestino.getAlgoformer(), algoFormer);
    }

    private void success() {
        assertTrue(true);
    }
}
