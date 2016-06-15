package fiuba.algo3.algoformers.modelo.Integracion.IntegracionEntrega2;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.Nube;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.TormentaPsionica;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Ataque;
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
public class IntegracionEntrega2_ZonaTormentaPsionica {
    @Test
    public void ratchetAlternoSufreTormentaPsionica_atacaAMegatron_verificoPoderDeAtaqueDisminuyo40Porciento() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionTormenta = new Posicion(0, 1);
        Posicion posicionEnemigo = new Posicion(0, 2);
        AlgoFormer algoFormer = new Ratchet();
        AlgoFormer algoFormerEnemigo= new Megatron();
        SuperficieAerea superficieInicial = new Nube();
        SuperficieAerea superficieTormenta = new TormentaPsionica();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial);
        tablero.getCasillero(posicionTormenta).setSuperficieAerea(superficieTormenta);
        tablero.setAlgoformer(algoFormer,posicionInicio);
        tablero.setAlgoformer(algoFormerEnemigo,posicionEnemigo);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionTormenta)); //Ratchet sufre la TormentaPsionica
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        algoFormer.pasarTurno();
        Ataque ataque = new Ataque(tablero.getCasillero(posicionTormenta));

        try {
            ataque.atacarA(tablero.getCasillero(posicionEnemigo));
        } catch (DistanciaExcedidaException | NoSePermiteElFuegoAmistosoException e) {
            fail();
        }

        assertEquals(algoFormerEnemigo.getPuntosDeVida(), 529, 0D);
    }

    @Test
    public void megatronAlternoSufreTormentaPsionica_atacaARatchet_verificoPoderDeAtaqueDisminuyo40Porciento() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionTormenta = new Posicion(0, 1);
        Posicion posicionEnemigo = new Posicion(0, 2);
        AlgoFormer algoFormer = new Megatron();
        AlgoFormer algoFormerEnemigo= new Ratchet();
        SuperficieAerea superficieInicial = new Nube();
        SuperficieAerea superficieTormenta = new TormentaPsionica();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial);
        tablero.getCasillero(posicionTormenta).setSuperficieAerea(superficieTormenta);
        tablero.setAlgoformer(algoFormer,posicionInicio);
        tablero.setAlgoformer(algoFormerEnemigo,posicionEnemigo);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionTormenta)); //Megatron sufre la TormentaPsionica
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        algoFormer.pasarTurno();
        Ataque ataque = new Ataque(tablero.getCasillero(posicionTormenta));

        try {
            ataque.atacarA(tablero.getCasillero(posicionEnemigo));
        } catch (DistanciaExcedidaException | NoSePermiteElFuegoAmistosoException e) {
            fail();
        }

        assertEquals(algoFormerEnemigo.getPuntosDeVida(), 117, 0D);
    }

    @Test
    public void ratchetAlternoSufreDosTormentasPsionicas_atacaAMegatron_verificoPoderDeAtaqueSoloDisminuyo40Porciento() {
        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionTormenta = new Posicion(0, 1);
        Posicion posicionTormenta2 = new Posicion(0, 2);
        Posicion posicionEnemigo = new Posicion(0, 3);
        AlgoFormer algoFormer = new Ratchet();
        AlgoFormer algoFormerEnemigo= new Megatron();
        SuperficieAerea superficieInicial = new Nube();
        SuperficieAerea superficieTormenta1 = new TormentaPsionica();
        SuperficieAerea superficieTormenta2 = new TormentaPsionica();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial);
        tablero.getCasillero(posicionTormenta).setSuperficieAerea(superficieTormenta1);
        tablero.getCasillero(posicionTormenta2).setSuperficieAerea(superficieTormenta2);
        tablero.setAlgoformer(algoFormer,posicionInicio);
        tablero.setAlgoformer(algoFormerEnemigo,posicionEnemigo);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionTormenta)); //Ratchet sufre la TormentaPsionica
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionTormenta), algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionTormenta2)); //Ratchet sufre nuevamente TormentaPsionica
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        algoFormer.pasarTurno();
        Ataque ataque = new Ataque(tablero.getCasillero(posicionTormenta2));

        try {
            ataque.atacarA(tablero.getCasillero(posicionEnemigo));
        } catch (DistanciaExcedidaException | NoSePermiteElFuegoAmistosoException e) {
            fail();
        }

        assertEquals(algoFormerEnemigo.getPuntosDeVida(), 529, 0D);
    }

    @Test
    public void megatronAlternoSufreDosTormentasPsionicas_atacaARatchet_verificoPoderDeAtaqueSoloDisminuyo40Porciento() {
        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionTormenta = new Posicion(0, 1);
        Posicion posicionTormenta2 = new Posicion(0, 2);
        Posicion posicionEnemigo = new Posicion(0, 3);
        AlgoFormer algoFormer = new Megatron();
        AlgoFormer algoFormerEnemigo= new Ratchet();
        SuperficieAerea superficieInicial = new Nube();
        SuperficieAerea superficieTormenta1 = new TormentaPsionica();
        SuperficieAerea superficieTormenta2 = new TormentaPsionica();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial);
        tablero.getCasillero(posicionTormenta).setSuperficieAerea(superficieTormenta1);
        tablero.getCasillero(posicionTormenta2).setSuperficieAerea(superficieTormenta2);
        tablero.setAlgoformer(algoFormer,posicionInicio);
        tablero.setAlgoformer(algoFormerEnemigo,posicionEnemigo);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionTormenta)); //Megatron sufre la TormentaPsionica
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionTormenta), algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionTormenta2)); //Megatron sufre nuevamente TormentaPsionica
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        }

        algoFormer.pasarTurno();
        Ataque ataque = new Ataque(tablero.getCasillero(posicionTormenta2));

        try {
            ataque.atacarA(tablero.getCasillero(posicionEnemigo));
        } catch (DistanciaExcedidaException | NoSePermiteElFuegoAmistosoException e) {
            fail();
        }

        assertEquals(algoFormerEnemigo.getPuntosDeVida(), 117, 0D);
    }
}
