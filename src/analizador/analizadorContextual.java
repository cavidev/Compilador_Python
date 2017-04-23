package analizador;

import generated.MyParser;
import generated.MyParserBaseVisitor;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

/**
 * Created by dell on 22/4/2017.
 */
public class analizadorContextual extends MyParserBaseVisitor<Object> {

    private int INT = 1, STRING = 2, CHAR = 3, LISTA = 4, ID = 5, SUMA , RESTA;

    private TablaSimbolos tablaSimbolos;

    private ArrayList<TablaSimbolos> scopes;    //Lista de los Scope en el texto
    private String nombreVariable;              //Guarda el nombre de la variable temporalmente.
    private String variableAnalizar;            //Variable, controla si esta indefinida o no.
    private int profundidadScope;               //Profundidad en la que nos encontramos en el Scope.


    public analizadorContextual() {
        this.tablaSimbolos = new TablaSimbolos();
        this.scopes = new ArrayList<>();

        this.nombreVariable = null;
        this.variableAnalizar = null;
        this.profundidadScope = 0;

        this.scopes.add(profundidadScope, this.tablaSimbolos);
    }

    /**
     * Se sobrescriben todos los metodos de la clase MyParserBaseVisitor<?>, esto con el fin de adecuarlos para imprimir
     * en consola y en la GUI, se imprimiran los tokens cambiantes como los nombres de variables, expresiones primarias
     * (int | string) y los parametros de la función.
     */


    @Override
    public Object visitInicioPrograma(MyParser.InicioProgramaContext ctx) {

        visit(ctx.statement(0));
        for (int i=1; i <= ctx.statement().size()-1; i++)
        {
            visit(ctx.statement(i));
        }

        tablaSimbolos.imprimir();

        return null;
    }

    @Override
    public Object visitDeclaracionDEF(MyParser.DeclaracionDEFContext ctx) {

        visit(ctx.defStatement());

        return null;
    }

    @Override
    public Object visitDeclaracionIF(MyParser.DeclaracionIFContext ctx) {

        visit(ctx.ifStatement());

        return null;
    }

    @Override
    public Object visitDeclaracionRETURN(MyParser.DeclaracionRETURNContext ctx) {

        visit(ctx.returnStatement());

        return null;
    }

    @Override
    public Object visitDeclaracionPRINT(MyParser.DeclaracionPRINTContext ctx) {

        visit(ctx.printStatement());


        return null;
    }

    @Override
    public Object visitDeclaracionWHILE(MyParser.DeclaracionWHILEContext ctx) {

        visit(ctx.whileStatement());


        return null;
    }

    @Override
    public Object visitDeclaracionASSIGN(MyParser.DeclaracionASSIGNContext ctx) {

        visit(ctx.assignStatement());


        return null;
    }

    @Override
    public Object visitDeclaracionLLAMADAFUNCION(MyParser.DeclaracionLLAMADAFUNCIONContext ctx) {

        visit(ctx.functionCallStatement());


        return null;
    }

    @Override
    public Object visitFuncion(MyParser.FuncionContext ctx) {

        visit(ctx.argList());
        visit(ctx.sequence());

        return null;
    }

    @Override
    public Object visitListaParametros(MyParser.ListaParametrosContext ctx) {

        System.out.println(" Parametro --> " + ctx.IDENTIFIER().getSymbol().getText());


        visit(ctx.moreArgs());


        return null;
    }

    @Override
    public Object visitListaParametroEOS(MyParser.ListaParametroEOSContext ctx) {


        return null;
    }

    @Override
    public Object visitMasParametros(MyParser.MasParametrosContext ctx) {

        for (int i = 0; i <= ctx.IDENTIFIER().size() - 1; i++)
        {

            System.out.println(" Parametro --> " + ctx.IDENTIFIER(i).getSymbol().getText());

            DefaultMutableTreeNode hoja = new DefaultMutableTreeNode(ctx.IDENTIFIER(i).getSymbol().getText());

        }

        return null;
    }

    @Override
    public Object visitIf_y_Else(MyParser.If_y_ElseContext ctx)  {
        //Esperar a que termine

        visit(ctx.expression());

        visit(ctx.sequence(0));
        for (int i=1; i <= ctx.sequence().size()-1; i++)
        {
            visit(ctx.sequence(i));
        }

        return null;
    }

    @Override
    public Object visitWhile(MyParser.WhileContext ctx) {

        visit(ctx.expression());

        visit(ctx.sequence());


        return null;
    }

    @Override
    public Object visitReturn(MyParser.ReturnContext ctx) {

        visit(ctx.expression());

        return null;
    }

    @Override
    public Object visitPrint(MyParser.PrintContext ctx) {

        visit(ctx.expression());

        return null;
    }

    @Override
    public Object visitAsignacion(MyParser.AsignacionContext ctx)  {

        nombreVariable = ctx.IDENTIFIER().getText().toString();

        visit(ctx.expression());

        return null;
    }

    @Override
    public Object visitLlamarFuncion(MyParser.LlamarFuncionContext ctx) {

        visit(ctx.primitiveExpression());
        visit(ctx.expressionList());


        return null;
    }

    @Override
    public Object visitSecuencia(MyParser.SecuenciaContext ctx) {

        visit(ctx.moreStatement());

        return null;
    }

    @Override
    public Object visitMasDeclaraciones(MyParser.MasDeclaracionesContext ctx) {

        visit(ctx.statement(0));
        for (int i=1; i <= ctx.statement().size()-1; i++)
        {
            visit(ctx.statement(i));
        }

        return null;
    }

    @Override
    public Object visitExpresion(MyParser.ExpresionContext ctx) {

        visit(ctx.additionExpression());
        visit(ctx.comparison());

        return null;
    }

    @Override
    public Object visitComparacion(MyParser.ComparacionContext ctx) {

        for (int i=0; i <= ctx.additionExpression().size()-1; i++)
        {
            visit(ctx.signosComparacion(i));
            visit(ctx.additionExpression(i));
        }

        return null;
    }

    @Override
    public Object visitSignosComparacion(MyParser.SignosComparacionContext ctx) {

        return null;
    }

    @Override
    public Object visitEspresionAderencia(MyParser.EspresionAderenciaContext ctx) {

        visit(ctx.multiplicationExpression());
        visit(ctx.additionFactor());

        return null;
    }

    @Override
    public Object visitFactorAderencia(MyParser.FactorAderenciaContext ctx) {

        for (int i=0; i <= ctx.multiplicationExpression().size()-1; i++)
        {
            visit(ctx.signosSumaResta(i));
            visit(ctx.multiplicationExpression(i));
        }

        return null;
    }

    @Override
    public Object visitSignosSumaResta(MyParser.SignosSumaRestaContext ctx) {

        if (ctx.RESTA() != null) {
            return RESTA;
        } else {
            return SUMA;
        }
    }

    @Override
    public Object visitExpresionMultiplicacion(MyParser.ExpresionMultiplicacionContext ctx) {

        visit(ctx.elementExpression());
        visit(ctx.multiplicationFactor());


        return null;
    }

    @Override
    public Object visitFactorMultiplicacion(MyParser.FactorMultiplicacionContext ctx) {

        for (int i=0; i <= ctx.elementExpression().size()-1; i++)
        {
            System.out.println( visit(ctx.signosOperativos(i)) );
            visit(ctx.elementExpression(i));
        }

        return null;
    }

    @Override
    public Object visitSignosOperativos(MyParser.SignosOperativosContext ctx) {
        // * /

        return null;
    }

    @Override
    public Object visitExpresionElemento(MyParser.ExpresionElementoContext ctx) {

        Object variable = visit(ctx.primitiveExpression());
        visit(ctx.elementAccess());

        print(variable);
        if (this.variableAnalizar != null) {

        }

        this.variableAnalizar = null;

        return null;
    }

    @Override
    public Object visitAccesoElemento(MyParser.AccesoElementoContext ctx) {

        for (int i=0; i <= ctx.expression().size()-1; i++)
        {
            visit(ctx.expression(i));
        }

        return null;
    }

    @Override
    public Object visitDeclaracionFuntionCallExpression(MyParser.DeclaracionFuntionCallExpressionContext ctx) {

        visit(ctx.expressionList());

        return null;
    }

    @Override
    public Object visitListaExpresiones(MyParser.ListaExpresionesContext ctx) {

        visit(ctx.expression());
        visit(ctx.moreExpressions());

        return null;
    }

    @Override
    public Object visitListExpressionEOS(MyParser.ListExpressionEOSContext ctx) {
        //Espacio en blanco

        return null;
    }

    @Override
    public Object visitMasExpresiones(MyParser.MasExpresionesContext ctx) {

        for (int i=0; i <= ctx.expression().size()-1; i++)
        {
            visit(ctx.expression(i));
        }

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaINT(MyParser.ExpresionPrimitivaINTContext ctx) {
        System.out.println(ctx.INTEGER().getSymbol().getText());
        if (nombreVariable != null) {
            TablaSimbolos.Ident i = tablaSimbolos.buscar(nombreVariable);
            if (i != null) {
                int tipoTabla;
                tipoTabla = i.tok.getType();

                if (tipoTabla != INT) {
                    System.out.println("Tipos incompatibles en fila: " + ctx.INTEGER().getSymbol().getLine() +
                            " columna: " + ctx.INTEGER().getSymbol().getCharPositionInLine());
                }
            } else {
                tablaSimbolos.insertar(nombreVariable, INT, ctx);
            }
        }
        nombreVariable = null;

        return INT;
    }

    @Override
    public Object visitExpresionPrimitivaSTRING(MyParser.ExpresionPrimitivaSTRINGContext ctx) {

        if (nombreVariable != null) {
            TablaSimbolos.Ident i = tablaSimbolos.buscar(nombreVariable);
            if (i != null) {
                int tipoTabla = i.tok.getType();

                if (tipoTabla != STRING) {
                    System.out.println("Tipos incompatibles en fila: " + ctx.STRING().getSymbol().getLine() +
                            " columna: " + ctx.STRING().getSymbol().getCharPositionInLine());
                }
            } else {
                tablaSimbolos.insertar(nombreVariable, STRING, ctx);
            }
        }
        nombreVariable = null;

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaID(MyParser.ExpresionPrimitivaIDContext ctx) {
        //Retorno la variable para buscarla.
        variableAnalizar = ctx.IDENTIFIER().getText();
        System.out.println(ctx.getClass().getSimpleName() + " Token: " + ctx.IDENTIFIER().getText());

        return variableAnalizar;
    }

    @Override
    public Object visitExpresionPrimitivaCHAR(MyParser.ExpresionPrimitivaCHARContext ctx) {

        if (nombreVariable != null) {
            TablaSimbolos.Ident i = tablaSimbolos.buscar(nombreVariable);
            if (i != null) {
                int tipoTabla = i.tok.getType();

                if (tipoTabla != CHAR) {
                    System.out.println("Tipos incompatibles en fila: " + ctx.CHAR().getSymbol().getLine() +
                            " columna: " + ctx.CHAR().getSymbol().getCharPositionInLine());
                }
            } else {
                tablaSimbolos.insertar(nombreVariable, CHAR, ctx);
            }
        }
        nombreVariable = null;

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaDER_EX_IZQ(MyParser.ExpresionPrimitivaDER_EX_IZQContext ctx) {

        visit(ctx.expression());

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaLISTAEXPRESION(MyParser.ExpresionPrimitivaLISTAEXPRESIONContext ctx) {

        visit(ctx.listExpression());

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaLEN_PIZQ_EX_PDER(MyParser.ExpresionPrimitivaLEN_PIZQ_EX_PDERContext ctx) {

        visit(ctx.expression());

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaFunctionCallExpression(MyParser.ExpresionPrimitivaFunctionCallExpressionContext ctx) {

        visit(ctx.functionCallExpression());

        return null;
    }

    @Override
    public Object visitListaExpresionesUltima(MyParser.ListaExpresionesUltimaContext ctx) {

        if (nombreVariable != null) {
            TablaSimbolos.Ident i = tablaSimbolos.buscar(nombreVariable);
            if (i != null) {
                int tipoTabla = i.tok.getType();

                if (tipoTabla != LISTA) {
                    System.out.println("Tipos incompatibles en fila: " + ctx.PCIZQ().getSymbol().getLine() +
                            " columna: " + ctx.PCIZQ().getSymbol().getCharPositionInLine());
                }
            } else {
                tablaSimbolos.insertar(nombreVariable, LISTA, ctx);
            }
        }
        nombreVariable = null;

        visit(ctx.expressionList());

        return null;
    }

    public void print( Object doc) {
        System.out.println(doc);
    }

    public boolean isString(Object str) {
        if (str.equals(str.toString())) {
            return true;
        } else {
            return false;
        }
    }
}
