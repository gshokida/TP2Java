package fiuba.algo3.algoformers.modelo.Integracion;

import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Escenario.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.Optimus;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by german.shokida on 31/5/2016.
 */
public class IntegracionAlgoformerEntrega1 {
    @Test
    public void nuevoTablero_UbicoAlgoFormer_VerificoPosicion_Punto1(){
        Tablero tablero = new Tablero(8, 8);
        AlgoFormer optimus = new Optimus();

        tablero.setPersonaje(optimus, 0, 0);

        assertEquals(optimus, tablero.getContenido(0, 0));
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormer_MuevoACasilleroVacio_VerificoPosicion_Punto1()
            throws ImposibleMoverseCasilleroOcupadoException {
        Tablero tablero = new Tablero(8, 8);
        AlgoFormer optimus = new Optimus();
        tablero.setContenido(optimus, 0, 0);

        tablero.moverPersonaje(optimus,2,2);

        assertEquals(optimus, tablero.getContenido(2, 2));
        assertEquals(ContenidoVacio.getInstance(), tablero.getContenido(0,0));
    }

    @Test(expected=ImposibleMoverseCasilleroOcupadoException.class)
    public void nuevoTablero_UbicoAlgoFormer_MuevoACasilleroNoVacio_LanzoException_Punto1()
            throws ImposibleMoverseCasilleroOcupadoException {
        Tablero tablero = new Tablero(8, 8);
        AlgoFormer optimus = new Optimus();
        AlgoFormer megatron = new Megatron();
        tablero.setContenido(optimus, 0, 0);
        tablero.setContenido(megatron, 2, 2);

        tablero.moverPersonaje(optimus,2,2);
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormer_VerificoQueSeaHumanoide_Punto2(){
        Tablero tablero = new Tablero(8, 8);
        AlgoFormer optimus = new Optimus();

        tablero.setContenido(optimus, 0, 0);

        assertTrue(optimus.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormer_VerificoTransformacion_Punto2(){
        Tablero tablero = new Tablero(8, 8);
        AlgoFormer optimus = new Optimus();
        tablero.setContenido(optimus, 0, 0);

        optimus.transformar();

        assertEquals(optimus.getPuntosDeVida(),500);
        assertEquals(optimus.getAtaque(),15);
        assertEquals(optimus.getDistanciaDeAtaque(),4);
        assertEquals(optimus.getVelocidad(),5);
        assertTrue(optimus.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormer_VerificoDobleTransformacion_Punto2(){
        Tablero tablero = new Tablero(8, 8);
        AlgoFormer optimus = new Optimus();
        tablero.setContenido(optimus, 0, 0);

     optimus.transformar();
        optimus.transformar();

        assertEquals(optimus.getPuntosDeVida(),500);
        assertEquals(optimus.getAtaque(),50);
        assertEquals(optimus.getDistanciaDeAtaque(),2);
        assertEquals(optimus.getVelocidad(),2);
        assertTrue(optimus.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }


    @Test
    public void nuevoTablero_UbicoAlgoFormerModoAlterno_VerificoPosicion_Punto3(){
        Tablero tablero = new Tablero(8, 8);
        AlgoFormer optimus = new Optimus();
        optimus.transformar();

        tablero.setContenido(optimus, 0, 0);

        assertEquals(optimus, tablero.getContenido(0, 0));
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormerModoAlterno_Muevo_VerificoPosicion_Punto3()  {
        Tablero tablero = new Tablero(8, 8);
        AlgoFormer optimus = new Optimus();
        optimus.transformar();

        tablero.setContenido(optimus, 0, 0);

        try {
            tablero.moverPersonaje(optimus, 1, 1);
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            e.printStackTrace();
        }

        assertEquals(optimus, tablero.getContenido(1, 1));
    }


    @Test
    public void nombredeTest()  {

        Juego juego1 = new Juego("Pepe", "Pablo", 8, 8);

        Tablero tablero = juego1.getTablero();



    }


}
