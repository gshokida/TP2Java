package fiuba.algo3.modelo;

public class AlgoformerEstado {
    private float ataque;
    private int distanciaDeAtaque;
    private int velocidad;
    private TipoUnidad tipoUnidad;

    public AlgoformerEstado(float ataque, int distanciaDeAtaque, int velocidad, TipoUnidad tipoUnidad) {
        this.ataque = ataque;
        this.distanciaDeAtaque = distanciaDeAtaque;
        this.velocidad = velocidad;
        this.tipoUnidad = tipoUnidad;
    }

    public float getAtaque() {
        return ataque;
    }

    public int getDistanciaDeAtaque() {
        return distanciaDeAtaque;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public boolean esTipoUnidad(TipoUnidad tipoUnidad) {
        return this.tipoUnidad.esTipoUnidad(tipoUnidad);
    }
}
