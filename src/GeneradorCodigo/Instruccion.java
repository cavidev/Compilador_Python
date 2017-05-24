package GeneradorCodigo;

/**
 * Created by dell on 23/5/2017.
 */
public class Instruccion {

    private String instruccion;
    private String numeroLinea;
    private String valor;


    public void setValor(String valor) {
        this.valor = valor;
    }

    public Instruccion(String _instruccion, String _numeroLinea, String _valor) {
        this.instruccion = _instruccion;
        this.numeroLinea = _numeroLinea;
        this.valor = _valor;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public String getNumeroLinea() {
        return numeroLinea;
    }

    public String getValor() {
        return valor;
    }
}
