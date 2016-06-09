package fiuba.algo3.algoformers.modelo.Integracion.IntegracionEntrega2;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseEfectoPresente;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.NebulosaAndromeda;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.Nube;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Movimiento;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Ratchet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by gaston.tulipani on 09/06/2016.
 */
public class IntegracionEntrega2_ZonaNebulosaAndromeda {
    @Test
    public void ratchetAlternoIngresaSinProblemas_verificoPosicionFinal() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea superficieInicial = new Nube();
        SuperficieAerea superficieFinal = new NebulosaAndromeda();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial);
        tablero.getCasillero(posicionDestino).setSuperficieAerea(superficieFinal);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void ratchetAlternoIngresaYNoSePuedeMover_lanzaError() {
        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea superficieInicial_nube = new Nube();
        SuperficieAerea superficieIntermedia_nebulosaAndromeda = new NebulosaAndromeda();
        SuperficieAerea superficieFinal_nube = new Nube();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial_nube);
        tablero.getCasillero(posicionIntermedia).setSuperficieAerea(superficieIntermedia_nebulosaAndromeda);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieAerea(superficieFinal_nube);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia)); //me muevo al casillero con NebulosaAndromeda y sufro efecto
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente e) {
            success();
        }
    }

    @Test
    public void ratchetAlternoIngresa_pasaUnTurnoYNoSePuedeMover_lanzaError() {
        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea superficieInicial_nube = new Nube();
        SuperficieAerea superficieIntermedia_nebulosaAndromeda = new NebulosaAndromeda();
        SuperficieAerea superficieFinal_nube = new Nube();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial_nube);
        tablero.getCasillero(posicionIntermedia).setSuperficieAerea(superficieIntermedia_nebulosaAndromeda);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieAerea(superficieFinal_nube);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia)); //me muevo al casillero con NebulosaAndromeda y sufro efecto
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionIntermedia), algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente e) {
            success();
        }
    }

    @Test
    public void ratchetAlternoIngresa_pasanDosTurnoYNoSePuedeMover_lanzaError() {
        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea superficieInicial_nube = new Nube();
        SuperficieAerea superficieIntermedia_nebulosaAndromeda = new NebulosaAndromeda();
        SuperficieAerea superficieFinal_nube = new Nube();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial_nube);
        tablero.getCasillero(posicionIntermedia).setSuperficieAerea(superficieIntermedia_nebulosaAndromeda);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieAerea(superficieFinal_nube);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia)); //me muevo al casillero con NebulosaAndromeda y sufro efecto
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        algoFormer.pasarTurno();
        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionIntermedia), algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente e) {
            success();
        }
    }

    @Test
    public void ratchetAlternoIngresa_pasanTresTurnosYSePuedeMover_verificoPosicionFinal() {
        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea superficieInicial_nube = new Nube();
        SuperficieAerea superficieIntermedia_nebulosaAndromeda = new NebulosaAndromeda();
        SuperficieAerea superficieFinal_nube = new Nube();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial_nube);
        tablero.getCasillero(posicionIntermedia).setSuperficieAerea(superficieIntermedia_nebulosaAndromeda);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieAerea(superficieFinal_nube);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia)); //me muevo al casillero con NebulosaAndromeda y sufro efecto
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        algoFormer.pasarTurno();
        algoFormer.pasarTurno();
        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionIntermedia), algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void megatronAlternoIngresaSinProblemas_verificoPosicionFinal() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Megatron();
        SuperficieAerea superficieInicial = new Nube();
        SuperficieAerea superficieFinal = new NebulosaAndromeda();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial);
        tablero.getCasillero(posicionDestino).setSuperficieAerea(superficieFinal);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestino));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestino).getAlgoformer());
    }

    @Test
    public void megatronAlternoIngresaYNoSePuedeMover_lanzaError() {
        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Megatron();
        SuperficieAerea superficieInicial_nube = new Nube();
        SuperficieAerea superficieIntermedia_nebulosaAndromeda = new NebulosaAndromeda();
        SuperficieAerea superficieFinal_nube = new Nube();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial_nube);
        tablero.getCasillero(posicionIntermedia).setSuperficieAerea(superficieIntermedia_nebulosaAndromeda);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieAerea(superficieFinal_nube);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia)); //me muevo al casillero con NebulosaAndromeda y sufro efecto
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente e) {
            success();
        }
    }

    @Test
    public void megatronAlternoIngresa_pasaUnTurnoYNoSePuedeMover_lanzaError() {
        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Megatron();
        SuperficieAerea superficieInicial_nube = new Nube();
        SuperficieAerea superficieIntermedia_nebulosaAndromeda = new NebulosaAndromeda();
        SuperficieAerea superficieFinal_nube = new Nube();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial_nube);
        tablero.getCasillero(posicionIntermedia).setSuperficieAerea(superficieIntermedia_nebulosaAndromeda);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieAerea(superficieFinal_nube);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia)); //me muevo al casillero con NebulosaAndromeda y sufro efecto
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionIntermedia), algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente e) {
            success();
        }
    }

    @Test
    public void megatronAlternoIngresa_pasanDosTurnoYNoSePuedeMover_lanzaError() {
        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Megatron();
        SuperficieAerea superficieInicial_nube = new Nube();
        SuperficieAerea superficieIntermedia_nebulosaAndromeda = new NebulosaAndromeda();
        SuperficieAerea superficieFinal_nube = new Nube();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial_nube);
        tablero.getCasillero(posicionIntermedia).setSuperficieAerea(superficieIntermedia_nebulosaAndromeda);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieAerea(superficieFinal_nube);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia)); //me muevo al casillero con NebulosaAndromeda y sufro efecto
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        algoFormer.pasarTurno();
        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionIntermedia), algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente e) {
            success();
        }
    }

    @Test
    public void megatronAlternoIngresa_pasanTresTurnosYSePuedeMover_verificoPosicionFinal() {
        Tablero tablero = new Tablero(5,5);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Megatron();
        SuperficieAerea superficieInicial_nube = new Nube();
        SuperficieAerea superficieIntermedia_nebulosaAndromeda = new NebulosaAndromeda();
        SuperficieAerea superficieFinal_nube = new Nube();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial_nube);
        tablero.getCasillero(posicionIntermedia).setSuperficieAerea(superficieIntermedia_nebulosaAndromeda);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieAerea(superficieFinal_nube);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionIntermedia)); //me muevo al casillero con NebulosaAndromeda y sufro efecto
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        algoFormer.pasarTurno();
        algoFormer.pasarTurno();
        algoFormer.pasarTurno();
        Movimiento movimiento2 = new Movimiento(tablero.getCasillero(posicionIntermedia), algoFormer.getVelocidad());

        try {
            movimiento2.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    private void success() {
        assertTrue(true);
    }
}
