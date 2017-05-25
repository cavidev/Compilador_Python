package AnalizadorContextual;
import org.antlr.v4.runtime.*;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Carlos Mario Villafuerte Díaz.
 * Esteban Gabriel Blanco Espinoza
 */
public class TablaSimbolos {

    LinkedList<Object> tabla;

    private final int INT = 1;
    private final int STRING = 2;
    private final int CHAR = 3;
    private final int LISTA = 4;
    private final int INDEFINIDA = 5;
    private final int BOOLEAN = 6;

    class Ident {
        Token tok;
        ParserRuleContext decl;
        ArrayList<Integer> tiposLista;

        public Ident(Token token, ParserRuleContext declaracion) {
            tok         = token;
            decl        = declaracion;
            tiposLista  = new ArrayList<>();
        }

        public int ObtenerTipoLista(int posicion){
            return this.tiposLista.get(posicion);
        }

        public int ObtenerTamanoLista(){
            return this.tiposLista.size();
        }

        public String ObtenerValor(){
            return this.decl.getChild(2).getChild(0).getChild(0).getChild(0).getChild(0).getChild(0).getText();
        }
    }

    public TablaSimbolos() {
        tabla = new LinkedList<Object>();
    }

    public void insertar(String nombre, int tipo, ParserRuleContext declaracion) {
        Token token = new CommonToken(tipo, nombre);
        Ident i = new Ident(token, declaracion);
        tabla.add(i);
    }

    public void insertar(String nombre, int tipo, ParserRuleContext declaracion, ArrayList<Integer> tiposLista) {
        Token token = new CommonToken(tipo, nombre);
        Ident i = new Ident(token, declaracion);
        for (int c = 0; c< tiposLista.size(); c++){
            i.tiposLista.add(tiposLista.get(c));
        }
        tabla.add(i);
    }

    public Ident buscar(String nombre)
    {
        Ident temp = null;
        for(Object id : tabla)
            if ( ((Ident)id).tok.getText().equals(nombre) )
                temp = ( (Ident)id );
        return temp;
    }

    public void imprimir() {
        for (int i = 0; i < tabla.size(); i++) {
            Token s = (Token) ((Ident) tabla.get(i)).tok;
            System.out.println("Nombre: " + s.getText());
            switch (s.getType()) {
                case 0:
                    System.out.println("\tTipo: Indefinido\n");
                    break;
                case INT:
                    System.out.println("\tTipo: Integer\n");
                    break;
                case STRING:
                    System.out.println("\tTipo: String\n");
                    break;
                case CHAR:
                    System.out.println("\tTipo: Char\n");
                    break;
                case INDEFINIDA:
                    System.out.println("\tTipo: Indefinida\n");
                    break;
                case BOOLEAN:
                    System.out.println("\tTipo: Boolean\n");
                    break;
                case LISTA:
                    System.out.println("\tTipo: Lista\n");
                    break;
                default:
                    break;
            }
        }
    }
}
