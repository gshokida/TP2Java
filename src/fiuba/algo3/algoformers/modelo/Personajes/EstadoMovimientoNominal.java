package fiuba.algo3.algoformers.modelo.Personajes;

/**
 * Created by Rodrigo on 08/06/2016.
 */
public class EstadoMovimientoNominal implements Estado {

    private static  EstadoMovimientoNominal unicaInstancia = new EstadoMovimientoNominal();


    private EstadoMovimientoNominal(){}

    public static EstadoMovimientoNominal getUnicaInstancia() {

    return unicaInstancia;

    }

    public boolean esEmpantanado (Estado estado){

        return this.equals(estado);

    }


}
