package myExceptions;

import editor_de_texto.TPEditor;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * Escucha lo errores del parser, muestra un mensaje de donde ser genero el error la linea y columna en el archivo de texto
 *
 */
public class ParserErrorListener extends BaseErrorListener {
    private TPEditor miVentana;

    public ParserErrorListener(TPEditor ventana){
        miVentana = ventana;
    }

    /**
     * Sobrescribe la clase por defecto y genera una salida en consola y en la solución grafica.
     * @param recognizer
     * @param offendingSymbol
     * @param line
     * @param charPositionInLine
     * @param msg
     * @param e
     * @throws ParseCancellationException
     */
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                            int charPositionInLine, String msg, RecognitionException e)
            throws ParseCancellationException {
        miVentana.setErrors("Error de Parser... Linea " + line + ":" + charPositionInLine + " " + msg);
        System.out.println("Error de Parser... Linea " + line + ":" + charPositionInLine + " " + msg);
    }
}
