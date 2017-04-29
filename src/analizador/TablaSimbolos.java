package analizador;
import org.antlr.v4.runtime.*;
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

    class Ident{
        Token tok;
        ParserRuleContext decl;

        public Ident(Token token, ParserRuleContext declaracion) {
            tok = token;
            decl = declaracion;
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
                case LISTA:
                    System.out.println("\tTipo: Lista\n");
                    break;
                default:
                    break;
            }
        }
    }
}
