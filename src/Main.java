/**
 * Created by Carlos Mario on 18/3/2017.
 */
import analizador.analizadorContextual;
import arbol.Arbol;
import arbol.ArbolSinNodos;
import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileReader;
import java.util.List;

/**
 * Clase de inicio de ejecución no implementada en esta solución. La entrada al programa se genera en la clase TPEditor.java
 */
public class Main {

    public static void main(String[] args)
    {
        MyScanner scanner = null;
        MyParser parser = null;
        try {
            ANTLRInputStream input = new ANTLRInputStream( new FileReader("SintaxisPython.txt") );
            scanner = new MyScanner(input);
            /*
            * Se sacan los tokens del scanner y se meten en el parse automatico.
            * */
            CommonTokenStream tokens = new CommonTokenStream(scanner);
            parser = new MyParser(tokens);

            ParseTree tree = parser.program();

            ArbolSinNodos arbol = new ArbolSinNodos();
            arbol.visit(tree);

            //analizadorContextual aContextual =  new analizadorContextual();
            //aContextual.visit(tree);
        }
        catch(Exception e){
            System.out.println("No hay archivo");
            System.out.println(e);
        }
    }
}