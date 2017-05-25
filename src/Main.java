/**
 * Created by Carlos Mario on 18/3/2017.
 */
import GeneradorCodigo.GeneradorCodigo;
import AnalizadorContextual.*;
import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileReader;

/**
 * Clase de inicio de ejecución no implementada en esta solución. La entrada al programa se genera en la clase TPEditor.java
 */
public class Main {

    public static void main(String[] args)
    {
        ParseTree tree = null;
        MyScanner scanner = null;
        MyParser parser = null;

        try {
            ANTLRInputStream input = new ANTLRInputStream( new FileReader("SintaxisPython.txt") );
            scanner = new MyScanner(input);
        }
        catch(Exception e){
            System.out.println("No hay archivo o se cayo por algo en null");
            //e.printStackTrace();
        }

        /*
        * Se sacan los tokens del scanner y se meten en el parse automatico.
        * */
        CommonTokenStream tokens = new CommonTokenStream(scanner);
        parser = new MyParser(tokens);

        tree = parser.program();

        //ArbolSinNodos ArbolRecorrido = new ArbolSinNodos();
        //ArbolRecorrido.visit(tree);

        AnalizadorContextual aContextual = new AnalizadorContextual();
        aContextual.visit(tree);

        GeneradorCodigo gCode = new GeneradorCodigo();
        gCode.visit(tree);
    }
}