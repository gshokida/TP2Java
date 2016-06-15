package fiuba.algo3.algoformers.modelo.Integracion.IntegracionEntrega2;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Espinas;
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
public class IntegracionEntrega2_ZonaEspinas_UnidadesAereas {
    @Test
    public void ratchetAlternoNoSufreEspinas_atraviesaUnCasillero_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 150, 0D);
    }

    @Test
    public void ratchetAlternoNoSufreEspinas_atraviesaDosCasilleros_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestino = new Posicion(0, 2);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_espinas = new Espinas();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia).setSuperficieTerreste(superficieIntermedia_espinas);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 150, 0D);
    }

    @Test
    public void megatronAlternoNoSufreEspinas_atraviesaUnCasillero_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Megatron();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 550, 0D);
    }

    @Test
    public void megatronAlternoNoSufreEspinas_atraviesaDosCasilleros_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestino = new Posicion(0, 2);
        AlgoFormer algoFormer = new Megatron();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_espinas = new Espinas();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia).setSuperficieTerreste(superficieIntermedia_espinas);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 550, 0D);
    }
}
