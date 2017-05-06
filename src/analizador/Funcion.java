package analizador;

import java.util.ArrayList;

/**
 * Created by esteb on 06/05/2017.
 */
public class Funcion {

    private String idFuncion;
    private ArrayList<Integer> tiposParametros;
    private int tipoRetorno;

    public void setTipoRetorno(int tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
    }

    public Funcion(String id){
        this.idFuncion = id;
    }

    public Funcion(String id, ArrayList<Integer> tiposParametros){
        this.idFuncion = id;
        this.tiposParametros = tiposParametros;
    }

    public String getIdFuncion() {
        return idFuncion;
    }
}
