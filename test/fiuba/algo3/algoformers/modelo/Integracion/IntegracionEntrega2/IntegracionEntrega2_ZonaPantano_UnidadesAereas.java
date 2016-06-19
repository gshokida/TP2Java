package fiuba.algo3.algoformers.modelo.Integracion.IntegracionEntrega2;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.HumanoideNoPuedeAtravesarPantanoException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Errores.NoPuedeTransformarseEnHumanoideException;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Pantano;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Movimiento;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Ratchet;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by gaston.tulipani on 09/06/2016.
 */
public class IntegracionEntrega2_ZonaPantano_UnidadesAereas {
    @Test
    public void ratchetAlternoNoSufrePantano_atraviesaUnCasillero_verificoPosicionFinal() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieFinal_pantano = new Pantano();
        Transformacion transformacion = new Transformacion(tablero.getCasillero(posicionInicio), algoFormer);

        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio), algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_pantano);

        try {
            transformacion.aplicarTransformacion();
            tablero.setAlgoformer(algoFormer,posicionInicio);
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException | NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void ratchetAlternoNoSufrePantano_atraviesaDosCasilleros_verificoPosicionFinal() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestino = new Posicion(0, 2);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_espinas = new Pantano();
        SuperficieTerrestre superficieFinal_espinas = new Pantano();
        Transformacion transformacion = new Transformacion(tablero.getCasillero(posicionInicio), algoFormer);

        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio), algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia).setSuperficieTerreste(superficieIntermedia_espinas);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            transformacion.aplicarTransformacion();
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia));
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException | NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(tablero.getCasillero(posicionDestino).getAlgoformer(), algoFormer);
    }

    @Test
    public void megatronAlternoNoSufrePantano_atraviesaUnCasillero_verificoPosicionFinal() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Megatron();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieFinal_pantano = new Pantano();
        Transformacion transformacion = new Transformacion(tablero.getCasillero(posicionInicio), algoFormer);

        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio), algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_pantano);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            transformacion.aplicarTransformacion();
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | HumanoideNoPuedeAtravesarPantanoException | NoPuedeTransformarseEnHumanoideException e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void megatronAlternoNoSufrePantano_atraviesaDosCasilleros_verificoPosicionFinal() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestino = new Posicion(0, 2);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_espinas = new Pantano();
        SuperficieTerrestre superficieFinal_espinas = new Pantano();
        Transformacion transformacion = new Transformacion(tablero.getCasillero(posicionInicio), algoFormer);

        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio), algoFormer);
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia).setSuperficieTerreste(superficieIntermedia_espinas);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);

        try {
            tablero.setAlgoformer(algoFormer,posicionInicio);
            transformacion.aplicarTransformacion();
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia));
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | NoPuedeTransformarseEnHumanoideException | HumanoideNoPuedeAtravesarPantanoException e) {
            fail();
        }

        assertEquals(tablero.getCasillero(posicionDestino).getAlgoformer(), algoFormer);
    }
}
