package fiuba.algo3.algoformers.modelo.Integracion.IntegracionEntrega2;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseEfectoPresente;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.Nube;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Movimiento;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Ratchet;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by gaston.tulipani on 09/06/2016.
 */
public class IntegracionEntrega2_ZonaNubes {
    @Test
    public void ratchetAlternoIngresaSinProblemas_atraviesaUnCasillero_verificoPosicionFinal() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea superficieInicial = new Nube();
        SuperficieAerea superficieFinal = new Nube();
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
    public void ratchetAlternoIngresaSinProblemas_atraviesaDosCasilleros_verificoPosicionFinal() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Ratchet();
        SuperficieAerea superficieInicial = new Nube();
        SuperficieAerea superficieIntermedia = new Nube();
        SuperficieAerea superficieFinal = new Nube();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieAerea(superficieIntermedia);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieAerea(superficieFinal);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }

    @Test
    public void megatronAlternoIngresaSinProblemas_atraviesaUnCasillero_verificoPosicionFinal() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestino = new Posicion(0, 1);
        AlgoFormer algoFormer = new Megatron();
        SuperficieAerea superficieInicial = new Nube();
        SuperficieAerea superficieFinal = new Nube();
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
    public void megatronAlternoIngresaSinProblemas_atraviesaDosCasilleros_verificoPosicionFinal() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicionInicio = new Posicion(0, 0);
        Posicion posicionDestinoIntermedio = new Posicion(0, 1);
        Posicion posicionDestinoFinal = new Posicion(0, 2);
        AlgoFormer algoFormer = new Megatron();
        SuperficieAerea superficieInicial = new Nube();
        SuperficieAerea superficieIntermedia = new Nube();
        SuperficieAerea superficieFinal = new Nube();
        Transformacion transformacion = new Transformacion(algoFormer);
        transformacion.aplicarTransformacion();
        algoFormer.pasarTurno();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicionInicio),algoFormer.getVelocidad());
        tablero.getCasillero(posicionInicio).setSuperficieAerea(superficieInicial);
        tablero.getCasillero(posicionDestinoIntermedio).setSuperficieAerea(superficieIntermedia);
        tablero.getCasillero(posicionDestinoFinal).setSuperficieAerea(superficieFinal);
        tablero.setAlgoformer(algoFormer,posicionInicio);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoIntermedio));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        try {
            movimiento.moverHasta(tablero.getCasillero(posicionDestinoFinal));
        } catch (DistanciaExcedidaException | ImposibleMoverseCasilleroOcupadoException | ImposibleMoverseEfectoPresente e) {
            fail();
        }

        assertEquals(algoFormer, tablero.getCasillero(posicionDestinoFinal).getAlgoformer());
    }
}
