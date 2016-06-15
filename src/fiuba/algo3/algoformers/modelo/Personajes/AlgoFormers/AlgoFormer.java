package fiuba.algo3.algoformers.modelo.Personajes.AlgoFormers;

import fiuba.algo3.algoformers.modelo.Personajes.Bandos.Bando;
import fiuba.algo3.algoformers.modelo.Personajes.TiposDeUnidades.TipoUnidad;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Ataques.EfectoAtaque;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Defensivos.EfectoDefensivo;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Efecto;
import fiuba.algo3.algoformers.modelo.Personajes.Efectos.Movimientos.EfectoMovimiento;

import java.util.Iterator;
import java.util.List;

/**
 * Created by german.shokida on 24/5/2016.
 */
public abstract class AlgoFormer {
    protected String nombre;
    protected double puntosDeVida;
    protected AlgoformerEstado estado;
    protected Bando bando;
    protected List<EfectoAtaque> efectosAtaque;
    protected List<EfectoMovimiento> efectosMovimiento;
    protected List<EfectoDefensivo> efectosDefensivo;

    public String getNombre() {
        return nombre;
    }
    public double getPuntosDeVida() {
        return puntosDeVida;
    }
    public double getAtaque() {
        double ataque = this.estado.getAtaque();
        for (EfectoAtaque efecto : this.efectosAtaque){
            ataque = efecto.aplicarEfecto(ataque);
        }
        return ataque;
    }
    public int getDistanciaDeAtaque() {
        return estado.getDistanciaDeAtaque();
    }
    public int getVelocidad() {
        int velocidad = this.estado.getVelocidad();
        for (EfectoMovimiento efecto : this.efectosMovimiento){
            velocidad = efecto.aplicarEfecto(velocidad);
        }
        return velocidad;
    }
    public Bando getBando() {
        return bando;
    }

    public void setPuntosDeVida(double puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }
    public void setAtaque(double ataque) {
        this.estado.setAtaque(ataque);
    }
    public void setVelocidad(int velocidad) {
        this.estado.setVelocidad(velocidad);
    }

    public void recibirAtaque(double puntosDeAtaque) {
        double danio = puntosDeAtaque;
        for (EfectoDefensivo efecto : this.efectosDefensivo){
            danio = efecto.aplicarEfecto(danio);
        }
        recibirDanio(danio);
    }
    private void recibirDanio(double puntosDeAtaque) {
        this.puntosDeVida -= (puntosDeAtaque);
    }

    public boolean esTipoUnidad(TipoUnidad tipoUnidad) {
        return estado.esTipoUnidad(tipoUnidad);
    }

    public abstract void transformar();

    public void pasarTurno() {
        for(Efecto efecto : this.efectosAtaque)
            efecto.pasarTurno();
        for(Efecto efecto : this.efectosMovimiento)
            efecto.pasarTurno();
        for(Efecto efecto : this.efectosDefensivo)
            efecto.pasarTurno();

        limpiarEfectos();
    }
    private void limpiarEfectos() {
        Iterator<EfectoMovimiento> efectoMovimientoIterator = this.efectosMovimiento.iterator();
        Iterator<EfectoDefensivo> efectoDefensivoIteratorIterator = this.efectosDefensivo.iterator();
        Iterator<EfectoAtaque> efectoAtaqueIteratorIterator = this.efectosAtaque.iterator();

        while (efectoMovimientoIterator.hasNext()) {
            EfectoMovimiento efecto = efectoMovimientoIterator.next();
            if(efecto.finalizo())
                efectoMovimientoIterator.remove();
        }

        while (efectoDefensivoIteratorIterator.hasNext()) {
            EfectoDefensivo efecto = efectoDefensivoIteratorIterator.next();
            if(efecto.finalizo())
                efectoDefensivoIteratorIterator.remove();
        }

        while (efectoAtaqueIteratorIterator.hasNext()) {
            EfectoAtaque efecto = efectoAtaqueIteratorIterator.next();
            if(efecto.finalizo())
                efectoAtaqueIteratorIterator.remove();
        }
    }

    public boolean sePuedeMover() {
        return (this.getVelocidad() != 0);
    }

    public boolean agregarEfectoAtaque(EfectoAtaque efecto) {
        boolean esAcumulable = true;

        for (EfectoAtaque e : this.efectosAtaque)
            if (!e.esAcumulableCon(efecto))
                esAcumulable = false;

        if(esAcumulable && !this.efectosAtaque.contains(efecto))
            this.efectosAtaque.add(efecto);

        return esAcumulable;
    }
    public void agregarEfectoMovimiento(EfectoMovimiento efecto) {
        if (!this.efectosMovimiento.contains(efecto))
            this.efectosMovimiento.add(efecto);
    }
    public void agregarEfectoDefensivo(EfectoDefensivo efecto) {
        if (!this.efectosDefensivo.contains(efecto))
            this.efectosDefensivo.add(efecto);
    }
}