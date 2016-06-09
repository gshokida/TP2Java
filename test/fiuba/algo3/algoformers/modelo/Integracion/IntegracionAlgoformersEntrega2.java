package fiuba.algo3.algoformers.modelo.Integracion;

import fiuba.algo3.algoformers.modelo.Errores.DistanciaExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseEfectoPresente;
import fiuba.algo3.algoformers.modelo.Escenario.Posicion;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.NebulosaAndromeda;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.Nube;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.SuperficieAerea;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieAerea.TormentaPsionica;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Espinas;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Pantano;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Movimiento;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Acciones.Transformacion;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
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
    public void Zona_Pantano_Optimus_Humanoide_No_Atraviesa(){

        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(0, 1);
        AlgoFormer optimus = new Optimus();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();
        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicion),optimus.getVelocidad());


        tablero.getCasillero(posicion).setSuperficieTerreste(rocosa);
        tablero.setAlgoformer(optimus,posicion);
        tablero.getCasillero(posicion2).setSuperficieTerreste(pantano);
        tablero.getCasillero(posicion2).setSuperficieAerea(new Nube());

        try {
            movimiento.moverHasta(tablero.getCasillero(posicion2));
            fail();

        } catch (DistanciaExcedidaException e) {
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            success();
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

    @Test
    public void Zona_Pantano_Megatron_Alterno_Atraviesa(){

        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(0, 1);
        AlgoFormer megatron = new Megatron();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre pantano = new Pantano();

        megatron.transformar();

        tablero.getCasillero(posicion).setSuperficieTerreste(rocosa);
        tablero.setAlgoformer(megatron,posicion);
        tablero.getCasillero(posicion2).setSuperficieTerreste(pantano);
        tablero.getCasillero(posicion2).setSuperficieAerea(new Nube());

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicion),megatron.getVelocidad());

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
    public void Zona_Espinas_Optimus_Alterno_Atraviesa_Lastimado (){

        Tablero tablero = new Tablero(5,5);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(0, 1);
        Posicion posicion3 = new Posicion(0, 2);
        Posicion posicion4 = new Posicion(0, 3);
        Posicion posicion5 = new Posicion(0, 4);
        AlgoFormer optimus = new Optimus();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre espinas1 = new Espinas();
        SuperficieTerrestre espinas2 = new Espinas();
        SuperficieTerrestre espinas3 = new Espinas();
        SuperficieTerrestre rocosa2 = new TierraRocosa();


        optimus.transformar();

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicion),optimus.getVelocidad());




        tablero.getCasillero(posicion).setSuperficieTerreste(rocosa);
        tablero.setAlgoformer(optimus,posicion);
        tablero.getCasillero(posicion2).setSuperficieTerreste(espinas1);
        tablero.getCasillero(posicion3).setSuperficieTerreste(espinas2);
        tablero.getCasillero(posicion4).setSuperficieTerreste(espinas3);
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



        try {
            movimiento.moverHasta(tablero.getCasillero(posicion5));
            success();

        } catch (DistanciaExcedidaException e) {
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente imposibleMoverseEfectoPresente) {
            fail();
        }

        Assert.assertTrue(optimus.getPuntosDeVida() < 500);


    }

    @Test
    public void Zona_Espinas_Megatron_Alterno_Atraviesa() {

        Tablero tablero = new Tablero(3, 3);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(0, 1);
        AlgoFormer megatron = new Megatron();
        SuperficieTerrestre rocosa = new TierraRocosa();
        SuperficieTerrestre espinas = new Espinas();

        megatron.transformar();

        tablero.getCasillero(posicion).setSuperficieTerreste(rocosa);
        tablero.setAlgoformer(megatron, posicion);
        tablero.getCasillero(posicion2).setSuperficieTerreste(espinas);
        tablero.getCasillero(posicion2).setSuperficieAerea(new Nube());

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicion), megatron.getVelocidad());

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
    public void Zona_Nubes_Megatron_Alterno_Atraviesa() {

        Tablero tablero = new Tablero(5,5);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(0, 1);
        Posicion posicion3 = new Posicion(0, 2);
        Posicion posicion4 = new Posicion(0, 3);
        Posicion posicion5 = new Posicion(0, 4);
        AlgoFormer megatron = new Megatron();
        SuperficieAerea nube = new Nube();
        SuperficieAerea nube1 = new Nube();
        SuperficieAerea nube2 = new Nube();
        SuperficieAerea nube3 = new Nube();
        SuperficieAerea nube4 = new Nube();


        megatron.transformar();

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicion),megatron.getVelocidad());




        tablero.getCasillero(posicion).setSuperficieAerea(nube);
        tablero.setAlgoformer(megatron,posicion);
        tablero.getCasillero(posicion2).setSuperficieAerea(nube1);
        tablero.getCasillero(posicion3).setSuperficieAerea(nube2);
        tablero.getCasillero(posicion4).setSuperficieAerea(nube3);
        tablero.getCasillero(posicion5).setSuperficieAerea(nube4);

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



        try {
            movimiento.moverHasta(tablero.getCasillero(posicion5));
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
    public void Zona_NebulosaAndromeda_Megatron_Alterno_Desactiva() {

        Tablero tablero = new Tablero(3, 3);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(0, 1);
        Posicion posicion3 = new Posicion(0, 2);
        AlgoFormer megatron = new Megatron();
        SuperficieAerea nube = new Nube();
        SuperficieAerea nebulosa = new NebulosaAndromeda();
        SuperficieAerea nube2 = new Nube();


        megatron.transformar();

        tablero.getCasillero(posicion).setSuperficieAerea(nube);
        tablero.getCasillero(posicion).setSuperficieTerreste(new TierraRocosa());
        tablero.setAlgoformer(megatron, posicion);
        tablero.getCasillero(posicion2).setSuperficieAerea(nebulosa);
        tablero.getCasillero(posicion2).setSuperficieTerreste(new TierraRocosa());
        tablero.getCasillero(posicion3).setSuperficieAerea(nube2);
        tablero.getCasillero(posicion3).setSuperficieTerreste(new TierraRocosa());

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicion), megatron.getVelocidad());

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
            fail();

        } catch (DistanciaExcedidaException e) {
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente imposibleMoverseEfectoPresente) {
            success();
        }


        megatron.pasarTurno();

        try {
            movimiento.moverHasta(tablero.getCasillero(posicion3));
            fail();

        } catch (DistanciaExcedidaException e) {
            fail();
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            fail();
        } catch (ImposibleMoverseEfectoPresente imposibleMoverseEfectoPresente) {
            success();
        }

        megatron.pasarTurno();
        megatron.pasarTurno();


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



    }

    @Test
    public void Zona_TormentaPsionica_Megatron_Alterno_BajaElAtaque() {

        Tablero tablero = new Tablero(3, 3);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(0, 1);
        Posicion posicion3 = new Posicion(0, 2);
        AlgoFormer megatron = new Megatron();
        SuperficieAerea nube = new Nube();
        SuperficieAerea tormentaPsionica = new TormentaPsionica();
        SuperficieAerea tormentaPsionica2 = new TormentaPsionica();

        Transformacion transformacion = new Transformacion(megatron);
        transformacion.aplicarTransformacion();


        int ataqueOriginal = megatron.getAtaque();

        tablero.getCasillero(posicion).setSuperficieAerea(nube);
        tablero.getCasillero(posicion).setSuperficieTerreste(new TierraRocosa());
        tablero.setAlgoformer(megatron, posicion);
        tablero.getCasillero(posicion2).setSuperficieAerea(tormentaPsionica);
        tablero.getCasillero(posicion2).setSuperficieTerreste(new TierraRocosa());
        tablero.getCasillero(posicion3).setSuperficieAerea(tormentaPsionica2);

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicion), megatron.getVelocidad());

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

        Assert.assertTrue(ataqueOriginal > megatron.getAtaque());


    }

    @Test
    public void Zona_TormentaPsionica_Megatron_Alterno_BajaElAtaque_Solo_La_Primera_Vez() {

        Tablero tablero = new Tablero(3, 3);
        Posicion posicion = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(0, 1);
        Posicion posicion3 = new Posicion(0, 2);
        AlgoFormer megatron = new Megatron();
        SuperficieAerea nube = new Nube();
        SuperficieAerea tormentaPsionica = new TormentaPsionica();
        SuperficieAerea tormentaPsionica2 = new TormentaPsionica();

        Transformacion transformacion = new Transformacion(megatron);
        transformacion.aplicarTransformacion();


        int ataqueOriginal = megatron.getAtaque();

        tablero.getCasillero(posicion).setSuperficieAerea(nube);
        tablero.getCasillero(posicion).setSuperficieTerreste(new TierraRocosa());
        tablero.setAlgoformer(megatron, posicion);
        tablero.getCasillero(posicion2).setSuperficieAerea(tormentaPsionica);
        tablero.getCasillero(posicion2).setSuperficieTerreste(new TierraRocosa());
        tablero.getCasillero(posicion3).setSuperficieAerea(tormentaPsionica2);
        tablero.getCasillero(posicion3).setSuperficieTerreste(new TierraRocosa());

        Movimiento movimiento = new Movimiento(tablero.getCasillero(posicion), megatron.getVelocidad());

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

        Assert.assertTrue(ataqueOriginal > megatron.getAtaque());

        ataqueOriginal = megatron.getAtaque();

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


        Assert.assertTrue(ataqueOriginal == megatron.getAtaque());

    }




    private void success() {
        assertTrue(true);
    }




}
