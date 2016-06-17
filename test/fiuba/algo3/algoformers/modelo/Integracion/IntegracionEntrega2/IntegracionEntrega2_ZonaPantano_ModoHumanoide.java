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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by gaston.tulipani on 09/06/2016.
 */
public class IntegracionEntrega2_ZonaPantano_ModoHumanoide {
    @Test
    public void optimusHumanoideNoPuedeIngresar() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            success();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionInicio).getAlgoformer());
    }

    @Test
    public void bumblebeeHumanoideNoPuedeIngresar() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            success();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionInicio).getAlgoformer());
    }

    @Test
    public void ratchetHumanoideNoPuedeIngresar() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (DistanciaExcedidaException | HumanoideNoPuedeAtravesarPantanoException e) {
            // Tiene velocidad 1
            success();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionInicio).getAlgoformer());
    }

    @Test
    public void megatronHumanoideNoPuedeIngresar() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Megatron();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (HumanoideNoPuedeAtravesarPantanoException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (DistanciaExcedidaException e) {
            //Tiene velocidad 1
            success();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionInicio).getAlgoformer());
    }

    @Test
    public void bonecrusherHumanoideNoPuedeIngresar() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (DistanciaExcedidaException | HumanoideNoPuedeAtravesarPantanoException e) {
            // Tiene velocidad 1
            success();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionInicio).getAlgoformer());
    }

    @Test
    public void frenzyHumanoideNoPuedeIngresar_verificoPosicionFinal() {

        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (HumanoideNoPuedeAtravesarPantanoException e) {
            success();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionInicio).getAlgoformer());
    }

    private void success() {
        assertTrue(true);
    }
}
