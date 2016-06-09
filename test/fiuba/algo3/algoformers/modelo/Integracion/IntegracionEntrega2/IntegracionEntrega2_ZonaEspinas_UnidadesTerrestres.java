package fiuba.algo3.algoformers.modelo.Integracion.IntegracionEntrega2;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseEfectoPresente;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Espinas;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Movimiento;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by gaston.tulipani on 09/06/2016.
 */
public class IntegracionEntrega2_ZonaEspinas_UnidadesTerrestres {
    @Test
    public void optimusHumanoideSufreEspinas_atraviesaUnCasillero_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 475, 0D);
    }

    @Test
    public void optimusHumanoideSufreEspinas_atraviesaDosCasilleros_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestino = new Posicion(0, 2);
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_espinas = new Espinas();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia).setSuperficieTerreste(superficieIntermedia_espinas);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 451.25, 0D);
    }

    @Test
    public void bumblebeeHumanoideSufreEspinas_atraviesaUnCasillero_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 332.5, 0D);
    }

    @Test
    public void bumblebeeHumanoideSufreEspinas_atraviesaDosCasilleros_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestino = new Posicion(0, 2);
        AlgoFormer algoFormer = new Bumblebee();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_espinas = new Espinas();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia).setSuperficieTerreste(superficieIntermedia_espinas);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 315.875, 0D);
    }

    @Test
    public void ratchetHumanoideSufreEspinas_atraviesaUnCasillero_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 142.5, 0D);
    }

    @Test
    public void megatronHumanoideSufreEspinas_atraviesaUnCasillero_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Megatron();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 522.5, 0D);
    }

    @Test
    public void bonecrusherHumanoideSufreEspinas_atraviesaUnCasillero_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Bonecrusher();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 190, 0D);
    }

    @Test
    public void frenzyHumanoideSufreEspinas_atraviesaUnCasillero_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 380, 0D);
    }

    @Test
    public void frenzyHumanoideSufreEspinas_atraviesaDosCasilleros_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestino = new Posicion(0, 2);
        AlgoFormer algoFormer = new Frenzy();
        SuperficieTerrestre superficieInicial_rocosa = new TierraRocosa();
        SuperficieTerrestre superficieIntermedia_espinas = new Espinas();
        SuperficieTerrestre superficieFinal_espinas = new Espinas();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieTerreste(superficieInicial_rocosa);
        tablero.getCasillero(posicionIntermedia).setSuperficieTerreste(superficieIntermedia_espinas);
        tablero.getCasillero(posicionDestino).setSuperficieTerreste(superficieFinal_espinas);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 361, 0D);
    }

    @Test
    public void optimusAlternoSufreEspinas_atraviesaUnCasillero_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Optimus();
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
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 475, 0D);
    }

    @Test
    public void optimusAlternoSufreEspinas_atraviesaDosCasilleros_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestino = new Posicion(0, 2);
        AlgoFormer algoFormer = new Optimus();
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
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 451.25, 0D);
    }

    @Test
    public void bumblebeeAlternoSufreEspinas_atraviesaUnCasillero_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Bumblebee();
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
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 332.5, 0D);
    }

    @Test
    public void bumblebeeAlternoSufreEspinas_atraviesaDosCasilleros_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestino = new Posicion(0, 2);
        AlgoFormer algoFormer = new Bumblebee();
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
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 315.875, 0D);
    }

    @Test
    public void bonecrusherAlternoSufreEspinas_atraviesaUnCasillero_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Bonecrusher();
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
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 190, 0D);
    }

    @Test
    public void bonecrusherAlternoSufreEspinas_atraviesaDosCasilleros_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestino = new Posicion(0, 2);
        AlgoFormer algoFormer = new Bonecrusher();
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
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 180.5, 0D);
    }

    @Test
    public void frenzyAlternoSufreEspinas_atraviesaUnCasillero_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Frenzy();
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
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 380, 0D);
    }

    @Test
    public void frenzyAlternoSufreEspinas_atraviesaDosCasilleros_verificoVida() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestino = new Posicion(0, 2);
        AlgoFormer algoFormer = new Frenzy();
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
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer.getPuntosDeVida(), 361, 0D);
    }
}
