package fiuba.algo3.algoformers.modelo.Personajes;

import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficieAtaque;
import fiuba.algo3.algoformers.modelo.Escenario.Superficies.EfectosSuperficie.EfectoSuperficieMovimiento;
import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;
import fiuba.algo3.algoformers.modelo.Personajes.Modos.Modo;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidad;

import java.util.List;

/**
 * Created by german.shokida on 24/5/2016.
 */
public abstract class AlgoFormer {
    protected String nombre;
    protected double puntosDeVida;
    protected AlgoformerEstado estado;
    protected Bando bando;
    protected List<EfectoSuperficieAtaque> efectosDeAtaque;
    protected List<EfectoSuperficieMovimiento> efectosDeMovimiento;

    public String getNombre() {
        return nombre;
    }

    public double getPuntosDeVida() {
        return puntosDeVida;
    }

    public int getAtaque() {
        return estado.getAtaque();
    }

    public int getDistanciaDeAtaque() {
        return estado.getDistanciaDeAtaque();
    }

    public int getVelocidad() {
        return estado.getVelocidad();
    }

    public boolean esTipoUnidad(TipoUnidad tipoUnidad) {
        return estado.esTipoUnidad(tipoUnidad);
    }

    public boolean esModo(Modo modo) {
        return estado.esModo(modo);
    }

    public Bando getBando() {
        return bando;
    }

    public void recibirAtaque(int puntosDeAtaque) {
        recibirDanio(puntosDeAtaque);
    }

    public void recibirDanio(double puntosDeAtaque) {
        this.puntosDeVida -= (puntosDeAtaque);
    }

    public void agregarEfecto(EfectoSuperficieAtaque efectoDeAtaque) {
        this.efectosDeAtaque.add(efectoDeAtaque);
    }

    public void agregarEfecto(EfectoSuperficieMovimiento efectoDeMovimiento) {
        this.efectosDeMovimiento.add(efectoDeMovimiento);
    }

    public abstract void transformar();
}