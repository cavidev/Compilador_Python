package myExceptions;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.misc.Pair;
import editor_de_texto.TPEditor;

import javax.swing.*;

/**
 * Sobreescribe la clase para el manejo de errores que posee por defecto el parser, para poder controlar los errores
 * de forma personalizada. Se envian a la ventana la fila y columna, así como el detalle respectivo para cada error.
 */

public class MyExceptionHandler extends DefaultErrorStrategy{

    private TPEditor miVentana;
    public MyExceptionHandler(TPEditor ventana){
        miVentana = ventana;
    }

    @Override
    public void reportError(Parser recognizer, RecognitionException e) {
        if(!this.inErrorRecoveryMode(recognizer)) {
            this.beginErrorCondition(recognizer);
            if(e instanceof NoViableAltException) {
                this.reportNoViableAlternative(recognizer, (NoViableAltException)e);
            } else if(e instanceof InputMismatchException) {
                this.reportInputMismatch(recognizer, (InputMismatchException)e);
            } else if(e instanceof FailedPredicateException) {
                this.reportFailedPredicate(recognizer, (FailedPredicateException)e);
            } else {
                miVentana.setErrors(e.getOffendingToken().getLine()+":"+e.getOffendingToken().getCharPositionInLine()+" "+
                        "Error de reconocimiento desconocido tipo: " + e.getClass().getName());
                System.err.println("Error de reconocimiento desconocido tipo: " + e.getClass().getName());
                recognizer.notifyErrorListeners(e.getOffendingToken(), e.getMessage(), e);
            }

        }
    }

    @Override
    protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {
        TokenStream tokens = recognizer.getInputStream();
        String input;
        if(tokens != null) {
            if(e.getStartToken().getType() == -1) {
                input = "<Fin de Archivo>";
            } else {
                input = tokens.getText(e.getStartToken(), e.getOffendingToken());
            }
        } else {
            input = "<Entrada desconocida>";
        }
        String msg = "No hay alternativa viable en la entrada " + this.escapeWSAndQuote(input);
        miVentana.setErrors(e.getOffendingToken().getLine()+":"+e.getOffendingToken().getCharPositionInLine()+" "+msg);
        recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
    }

    @Override
    protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
        String msg = "Entrada no concuerda " + this.getTokenErrorDisplay(e.getOffendingToken()) + " se esperaba " + e.getExpectedTokens().toString(recognizer.getVocabulary());
        miVentana.setErrors(e.getOffendingToken().getLine()+":"+e.getOffendingToken().getCharPositionInLine()+" "+msg);
        recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
    }

    @Override
    protected void reportUnwantedToken(Parser recognizer) {
        if(!this.inErrorRecoveryMode(recognizer)) {
            this.beginErrorCondition(recognizer);
            Token t = recognizer.getCurrentToken();
            String tokenName = this.getTokenErrorDisplay(t);
            IntervalSet expecting = this.getExpectedTokens(recognizer);
            String msg = "Entrada extraña " + tokenName + " se esperaba " + expecting.toString(recognizer.getVocabulary());
            miVentana.setErrors(t.getLine()+" : "+t.getCharPositionInLine()+" "+msg);
            recognizer.notifyErrorListeners(t, msg, (RecognitionException)null);
        }
    }

    @Override
    protected void reportMissingToken(Parser recognizer) {
        if(!this.inErrorRecoveryMode(recognizer)) {
            this.beginErrorCondition(recognizer);
            Token t = recognizer.getCurrentToken();
            IntervalSet expecting = this.getExpectedTokens(recognizer);
            String msg = "No se encontró " + expecting.toString(recognizer.getVocabulary()) + " en " + this.getTokenErrorDisplay(t);
            miVentana.setErrors(t.getLine()+" : "+t.getCharPositionInLine()+" "+msg);
            recognizer.notifyErrorListeners(t, msg, (RecognitionException)null);
        }
    }

    @Override
    protected Token getMissingSymbol(Parser recognizer) {
        Token currentSymbol = recognizer.getCurrentToken();
        IntervalSet expecting = this.getExpectedTokens(recognizer);
        int expectedTokenType = expecting.getMinElement();
        String tokenText;
        if(expectedTokenType == -1) {
            tokenText = "<No se encontró Final de Archivo>";
        } else {
            tokenText = "<No se encontró " + recognizer.getVocabulary().getDisplayName(expectedTokenType) + ">";
        }

        Token current = currentSymbol;
        Token lookback = recognizer.getInputStream().LT(-1);
        if(currentSymbol.getType() == -1 && lookback != null) {
            current = lookback;
        }

        return recognizer.getTokenFactory().create(new Pair(current.getTokenSource(), current.getTokenSource().getInputStream()), expectedTokenType, tokenText, 0, -1, -1, current.getLine(), current.getCharPositionInLine());
    }

    @Override
    protected String getTokenErrorDisplay(Token t) {
        if(t == null) {
            miVentana.setErrors("<Sin token>");
            return "<Sin token>";
        } else {
            String s = this.getSymbolText(t);
            if(s == null) {
                if(this.getSymbolType(t) == -1) {
                    s = "<Final de Archivo>";
                } else {
                    s = "<" + this.getSymbolType(t) + ">";
                }
            }
            miVentana.setErrors(t.getLine()+":"+t.getCharPositionInLine()+" "+this.escapeWSAndQuote(s));
            return this.escapeWSAndQuote(s);
        }
    }
}