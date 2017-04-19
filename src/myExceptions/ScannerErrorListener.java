package myExceptions;

import editor_de_texto.TPEditor;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * Escucha lo errores del scanner, muestra un mensaje de donde ser genero el error la linea y columna en el archivo de texto
 */
public class ScannerErrorListener extends BaseErrorListener{
    private TPEditor miVentana;

    public ScannerErrorListener(TPEditor ventana){
        miVentana = ventana;
    }

    /**
     * Se sobreescribe la clase implementada por defecto, genera una salida en consola y en la solucion grafica.
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
        miVentana.setErrors("Error de Scanner... Linea " + line + ":" + charPositionInLine + " " + msg);
        System.out.println("Error de Scanner... Linea " + line + ":" + charPositionInLine + " " + msg);
    }
}
