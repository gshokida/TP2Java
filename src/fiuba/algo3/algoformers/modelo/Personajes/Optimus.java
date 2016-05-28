package fiuba.algo3.algoformers.modelo.Personajes;

public class Optimus {
    private String nombre;
    private float puntosDeVida;

    private AlgoformerEstado estadoActual;
    private AlgoformerEstado estadoInactivo;

    public Optimus() {
        nombre = "Optimus Prime";
        puntosDeVida = 500f;

        estadoActual = new AlgoformerEstado(50f, 2, 2, TipoUnidadTerrestre.instancia());
        estadoInactivo = new AlgoformerEstado(15f, 4 ,5, TipoUnidadTerrestre.instancia());
    }


    public String getNombre() {
        return nombre;
    }

    public float getPuntosDeVida() {
        return puntosDeVida;
    }

    public float getAtaque() {
        return estadoActual.getAtaque();
    }

    public int getDistanciaDeAtaque() {
        return estadoActual.getDistanciaDeAtaque();
    }

    public int getVelocidad() {
        return estadoActual.getVelocidad();
    }

    public void cambiarModo() {
        AlgoformerEstado auxiliar = estadoInactivo;
        estadoInactivo = estadoActual;
        estadoActual = auxiliar;
    }

    public boolean esTipoUnidad(TipoUnidadTerrestre tipoUnidad) {
        return estadoActual.esTipoUnidad(tipoUnidad);
    }
}
