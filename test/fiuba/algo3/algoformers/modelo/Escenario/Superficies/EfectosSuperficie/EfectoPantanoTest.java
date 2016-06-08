package fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie;

import fiuba.algo3.algoformers.modelo.Errores.NoPuedeInteractuarConSuperficieException;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Espinas;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.Pantano;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.SuperficieTerrestre;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.SuperficieTerrestre.TierraRocosa;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import fiuba.algo3.algoformers.modelo.Personajes.EstadoEmpantanado;
import fiuba.algo3.algoformers.modelo.Personajes.EstadoMovimientoNominal;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

/**
 * Created by Rodrigo on 08/06/2016.
 */
public class EfectoPantanoTest {

    @Test
    public void elAutobot_Esta_Empantanado() {
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre pantano = new Pantano();
        algoFormer.transformar();


        try {
            pantano.interactuar(algoFormer);
            success();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        Assert.assertEquals(algoFormer.getEstado(), EstadoEmpantanado.getUnicaInstancia());

    }


    @Test
    public void elAutobot_No_Esta_Empantanado_Despues_De_Pasar_Por_Terreno_Rocoso() {
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre pantano = new Pantano();
        algoFormer.transformar();


        try {
            pantano.interactuar(algoFormer);
            success();
        } catch (NoPuedeInteractuarConSuperficieException e) {

        }

        SuperficieTerrestre rocoso = new TierraRocosa();

        try {
            rocoso.interactuar(algoFormer);
            success();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        Assert.assertEquals(algoFormer.getEstado(), EstadoMovimientoNominal.getUnicaInstancia());


    }

    @Test
    public void elAutobot_No_Esta_Empantanado_Despues_De_Pasar_Por_Terreno_Espinoso() {
        AlgoFormer algoFormer = new Optimus();
        SuperficieTerrestre pantano = new Pantano();
        algoFormer.transformar();


        try {
            pantano.interactuar(algoFormer);
            success();
        } catch (NoPuedeInteractuarConSuperficieException e) {

        }

        SuperficieTerrestre espinas = new Espinas();

        try {
            espinas.interactuar(algoFormer);
            success();
        } catch (NoPuedeInteractuarConSuperficieException e) {
            fail();
        }

        Assert.assertEquals(algoFormer.getEstado(), EstadoMovimientoNominal.getUnicaInstancia());


    }




    private void success() {assertTrue(true);    }


}
