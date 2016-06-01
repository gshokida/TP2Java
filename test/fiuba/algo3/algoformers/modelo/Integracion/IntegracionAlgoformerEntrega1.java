package fiuba.algo3.algoformers.modelo.Integracion;

import fiuba.algo3.algoformers.modelo.Escenario.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
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
        Optimus optimus = new Optimus();

        tablero.setPersonaje(optimus, 0, 0);

        assertEquals(optimus, tablero.getContenido(0, 0));
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormer_MuevoACasilleroVacio_VerificoPosicion_Punto1(){
        Tablero tablero = new Tablero(8, 8);
        Optimus optimus = new Optimus();
        tablero.setContenido(optimus, 0, 0);

        tablero.moverPersonaje(optimus,2,2);

        assertEquals(optimus, tablero.getContenido(2, 2));
        assertEquals(ContenidoVacio.getInstance(), tablero.getContenido(0,0));
    }


    @Test
    public void nuevoTablero_UbicoAlgoFormer_VerificoQueSeaHumanoide_Punto2(){
        Tablero tablero = new Tablero(8, 8);
        Optimus optimus = new Optimus();

        //tablero.setContenido(optimus, 0, 0);

        assertTrue(optimus.getAtaque() == 50);
        assertTrue(optimus.getDistanciaDeAtaque() == 2);
        assertTrue(optimus.getVelocidad() == 2);
        assertTrue(optimus.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormer_VerificoTransformacion_Punto2(){
        Tablero tablero = new Tablero(8, 8);
        Optimus optimus = new Optimus();

        //tablero.setContenido(optimus, 0, 0);

        optimus.transformar();

        assertTrue(optimus.getAtaque() == 15);
        assertTrue(optimus.getDistanciaDeAtaque() == 4);
        assertTrue(optimus.getVelocidad() == 5);
        assertTrue(optimus.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormer_VerificoDobleTransformacion_Punto2(){
        Tablero tablero = new Tablero(8, 8);
        Optimus optimus = new Optimus();

        //tablero.setContenido(optimus, 0, 0);

        optimus.transformar();
        optimus.transformar();

        assertTrue(optimus.getAtaque() == 50);
        assertTrue(optimus.getDistanciaDeAtaque() == 2);
        assertTrue(optimus.getVelocidad() == 2);
        assertTrue(optimus.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }


    @Test
    public void nuevoTablero_UbicoAlgoFormerModoAlterno_VerificoPosicion_Punto3(){
        Tablero tablero = new Tablero(8, 8);
        Optimus optimus = new Optimus();
        optimus.transformar();

        //tablero.setContenido(optimus, 0, 0);

        //assertEquals(optimus, tablero.getContenido(0, 0));
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormerModoAlterno_Muevo_VerificoPosicion_Punto3(){
        Tablero tablero = new Tablero(8, 8);
        Optimus optimus = new Optimus();
        optimus.transformar();

        //tablero.setContenido(optimus, 0, 0);

        //optimus.mover(1, 1);

        //assertEquals(optimus, tablero.getContenido(1, 1));
    }


}
