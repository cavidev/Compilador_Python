package GeneradorCodigo;

/**
 * Created by dell on 23/5/2017.
 */
public class Instruccion {

    private String instruccion;

    public void setValor(String valor) {
        this.valor = valor;
    }

    private int numeroLinea;
    private String valor;

    public Instruccion(String _instruccion, int _numeroLinea, String _valor) {
        this.instruccion = _instruccion;
        this.numeroLinea = _numeroLinea;
        this.valor = _valor;
    }

    public String getInstruccion() {
        return instruccion;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public String getValor() {
        return valor;
    }
}
