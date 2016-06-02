package fiuba.algo3.algoformers.modelo.Integracion;

import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.HoloSpark;
import fiuba.algo3.algoformers.modelo.Errores.DistanciaEntreAlgoFormersExcedidaException;
import fiuba.algo3.algoformers.modelo.Errores.ImposibleMoverseCasilleroOcupadoException;
import fiuba.algo3.algoformers.modelo.Errores.NoSePermiteElFuegoAmistosoException;
import fiuba.algo3.algoformers.modelo.Escenario.Contenidos.ContenidoVacio;
import fiuba.algo3.algoformers.modelo.Escenario.Tablero;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Juego;
import fiuba.algo3.algoformers.modelo.ManejoDeJuego.Jugador;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormer;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoAutobots;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.BandoDecepticons;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Megatron;
import fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers.Optimus;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidadTerrestre;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by german.shokida on 31/5/2016.
 */
public class IntegracionAlgoformerEntrega1 {
    @Test
    public void nuevoTablero_UbicoAlgoFormer_VerificoPosicion_Punto1(){
        Tablero tablero = new Tablero(5, 5);
        AlgoFormer optimus = new Optimus();

        tablero.setPersonaje(optimus, 0, 0);

        assertEquals(optimus, tablero.getContenido(0, 0));
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormer_MuevoACasilleroVacio_VerificoPosicion_Punto1()
            throws ImposibleMoverseCasilleroOcupadoException {
        Tablero tablero = new Tablero(5, 5);
        AlgoFormer optimus = new Optimus();
        tablero.setPersonaje(optimus, 0, 0);

        tablero.moverPersonaje(optimus,1,2);

        assertEquals(optimus, tablero.getContenido(1, 2));
        assertEquals(ContenidoVacio.getInstance(), tablero.getContenido(0,0));
    }

    @Test(expected=ImposibleMoverseCasilleroOcupadoException.class)
    public void nuevoTablero_UbicoAlgoFormer_MuevoACasilleroNoVacio_LanzoException_Punto1()
            throws ImposibleMoverseCasilleroOcupadoException {
        Tablero tablero = new Tablero(5, 5);
        AlgoFormer optimus = new Optimus();
        AlgoFormer megatron = new Megatron();
        tablero.setPersonaje(optimus, 0, 0);
        tablero.setPersonaje(megatron, 2, 2);

        tablero.moverPersonaje(optimus,2,2);
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormer_VerificoQueSeaHumanoide_Punto2(){
        Tablero tablero = new Tablero(5, 5);
        AlgoFormer optimus = new Optimus();

        tablero.setPersonaje(optimus, 0, 0);

        assertTrue(optimus.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormer_VerificoTransformacion_Punto2(){
        Tablero tablero = new Tablero(5, 5);
        AlgoFormer optimus = new Optimus();
        tablero.setPersonaje(optimus, 0, 0);

        optimus.transformar();

        assertEquals(optimus.getPuntosDeVida(),500);
        assertEquals(optimus.getAtaque(),15);
        assertEquals(optimus.getDistanciaDeAtaque(),4);
        assertEquals(optimus.getVelocidad(),5);
        assertTrue(optimus.esTipoUnidad(TipoUnidadTerrestre.instancia()));
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormer_VerificoDobleTransformacion_Punto2(){
        Tablero tablero = new Tablero(5, 5);
        AlgoFormer optimus = new Optimus();
        tablero.setPersonaje(optimus, 0, 0);
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
        Tablero tablero = new Tablero(5, 5);
        AlgoFormer optimus = new Optimus();
        optimus.transformar();

        tablero.setPersonaje(optimus, 0, 0);

        assertEquals(optimus, tablero.getContenido(0, 0));
    }

    @Test
    public void nuevoTablero_UbicoAlgoFormerModoAlterno_Muevo_VerificoPosicion_Punto3()  {
        Tablero tablero = new Tablero(5, 5);
        AlgoFormer optimus = new Optimus();
        optimus.transformar();

        tablero.setPersonaje(optimus, 0, 0);

        try {
            tablero.moverPersonaje(optimus, 1, 1);
        } catch (ImposibleMoverseCasilleroOcupadoException e) {
            e.printStackTrace();
        }

        assertEquals(optimus, tablero.getContenido(1, 1));
    }


    @Test
    public void test_Crear_NuevoJuego_Integracion_Punto4()  {

        Juego juego = new Juego("Pepe", "Pablo", 5, 5);

        Jugador jugador1 = juego.getJugador1();
        Jugador jugador2 = juego.getJugador2();

        Assert.assertTrue(jugador1.seLlama("Pepe"));
        Assert.assertTrue(jugador2.seLlama("Pablo"));

        Assert.assertTrue(jugador1.getBando().equals(BandoAutobots.instancia()));
        Assert.assertFalse(jugador1.getBando().equals(BandoDecepticons.instancia()));

        Assert.assertTrue(jugador2.getBando().equals(BandoDecepticons.instancia()));
        Assert.assertFalse(jugador2.getBando().equals(BandoAutobots.instancia()));

        Tablero tablero = juego.getTablero();

        Assert.assertTrue(tablero.getContenido(2,2).esLaHoloSpark(HoloSpark.instancia()));

        Assert.assertTrue(tablero.casilleroOcupado(0,0));
        Assert.assertTrue(tablero.casilleroOcupado(0,1));
        Assert.assertTrue(tablero.casilleroOcupado(1,2));
        Assert.assertTrue(tablero.casilleroOcupado(4,4));
        Assert.assertTrue(tablero.casilleroOcupado(4,3));
        Assert.assertTrue(tablero.casilleroOcupado(3,4));
    }

    @Test
    public void test_UbicarAlgoFormers_SeAtacanConDistanciaValida_Integracion_Punto5()
            throws NoSePermiteElFuegoAmistosoException, DistanciaEntreAlgoFormersExcedidaException {
        Tablero tablero = new Tablero(5, 5);
        AlgoFormer optimus = new Optimus();
        AlgoFormer megatron = new Megatron();
        tablero.setPersonaje(optimus, 0, 0);
        tablero.setPersonaje(megatron, 2, 2);

        optimus.atacar(megatron);

        assertEquals(optimus.getPuntosDeVida(),500);
        assertEquals(megatron.getPuntosDeVida(),500);

        megatron.atacar(optimus);

        assertEquals(optimus.getPuntosDeVida(),490);
        assertEquals(megatron.getPuntosDeVida(),500);
    }

    @Test(expected=DistanciaEntreAlgoFormersExcedidaException.class)
    public void test_UbicarAlgoFormers_SeAtacanConDistanciaInvalida_Integracion_Punto5()
            throws NoSePermiteElFuegoAmistosoException, DistanciaEntreAlgoFormersExcedidaException {
        Tablero tablero = new Tablero(5, 5);
        AlgoFormer optimus = new Optimus();
        AlgoFormer megatron = new Megatron();
        tablero.setPersonaje(optimus, 0, 0);
        tablero.setPersonaje(megatron, 3, 3);

        optimus.atacar(megatron);
    }
}
