package fiuba.algo3.algoformers.modelo.Personajes;

/**
 * Created by Rodrigo on 08/06/2016.
 */
public class EstadoEmpantanado implements Estado {

    private static EstadoEmpantanado unicaInstancia = new EstadoEmpantanado();

    private EstadoEmpantanado(){}

    public static EstadoEmpantanado getUnicaInstancia() {

        return unicaInstancia;

    }

    public boolean esEmpantanado(Estado estado) {
        return this.equals(estado);

    }
}
