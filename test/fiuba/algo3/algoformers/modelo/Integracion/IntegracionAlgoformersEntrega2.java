package fiuba.algo3.algoformers.modelo.Integracion;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseEfectoPresente;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Pantano;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Movimiento;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Rodrigo on 08/06/2016.
 */
public class IntegracionAlgoformersEntrega2 {

    @Test
    public void Zona_Rocosa_Optimus_Atraviesa_Sin_Problemas (){

        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(0, 1);
        Posicion posicion3 = new Posicion(0, 2);
        AlgoFormer optimus = new Optimus();
        SuperficieTerrestre rocosa = new TierraRocosa();



        tablero.getCasillero(posicion).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicion2).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicion3).setSuperficieTerreste(rocosa);

        tablero.setAlgoformer(optimus,posicion);

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicion),optimus.getVelocidad());

        try {
            movimiento.moverHasta(tablero.getCasillero(posicion2));
            success();

        } catch (DistanciaExcedidaException e) {
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente imposibleMoverseEfectoPresente) {
            fail();
        }


    }

    @Test
    public void Zona_Rocosa_Optimus_Alternativo_Atraviesa_Sin_Problemas (){

        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(0, 1);
        Posicion posicion3 = new Posicion(0, 2);
        AlgoFormer optimus = new Optimus();
        SuperficieTerrestre rocosa = new TierraRocosa();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicion),optimus.getVelocidad());


        optimus.transformar();

        tablero.getCasillero(posicion).setSuperficieTerreste(rocosa);
        tablero.setAlgoformer(optimus,posicion);
        tablero.getCasillero(posicion2).setSuperficieTerreste(rocosa);
        tablero.getCasillero(posicion3).setSuperficieTerreste(rocosa);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicion2));
            success();

        } catch (DistanciaExcedidaException e) {
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente imposibleMoverseEfectoPresente) {
            fail();
        }


    }

    @Test
    public void Zona_Pantano_Optimus_Alternativo_Atraviesa_Relentizado (){

        Tablero tablero = new Tablero(5,5);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(0, 1);
        Posicion posicion3 = new Posicion(0, 2);
        Posicion posicion4 = new Posicion(0, 3);
        Posicion posicion5 = new Posicion(0, 4);
        AlgoFormer optimus = new Optimus();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano1 = new Pantano();
        SuperficieTerrestre pantano2 = new Pantano();
        SuperficieTerrestre pantano3 = new Pantano();
        SuperficieTerrestre rocosa2 = new TierraRocosa();


        optimus.transformar();

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicion),optimus.getVelocidad());




        tablero.getCasillero(posicion).setSuperficieTerreste(rocosa);
        tablero.setAlgoformer(optimus,posicion);
        tablero.getCasillero(posicion2).setSuperficieTerreste(pantano1);
        tablero.getCasillero(posicion3).setSuperficieTerreste(pantano2);
        tablero.getCasillero(posicion4).setSuperficieTerreste(pantano3);
        tablero.getCasillero(posicion5).setSuperficieTerreste(rocosa2);

        try {
            movimiento.moverHasta(tablero.getCasillero(posicion2));
            success();

        } catch (DistanciaExcedidaException e) {
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente imposibleMoverseEfectoPresente) {
            fail();
        }




        try {
            movimiento.moverHasta(tablero.getCasillero(posicion3));
            success();

        } catch (DistanciaExcedidaException e) {
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente imposibleMoverseEfectoPresente) {
            fail();
        }



        try {
            movimiento.moverHasta(tablero.getCasillero(posicion4));
            success();

        } catch (DistanciaExcedidaException e) {
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente imposibleMoverseEfectoPresente) {
            fail();
        }



        Assert.assertFalse(movimiento.quedanMovimientos());


    }

    private void success() {
        assertTrue(true);
    }




}
