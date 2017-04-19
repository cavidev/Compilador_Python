package arbol;

import generated.MyParser;
import generated.MyParserBaseVisitor;

import javax.swing.tree.DefaultTreeModel;

/**
 * Clase generada para realizar pruebas en cosola, imprime un arbol de nodos con tab de las visitas hechas por
 * el parse en su recorrido por el archivo.
 */
public class ArbolSinNodos extends MyParserBaseVisitor<Object> {
    private int cont=0;     // Lleva la cuenta de la cantidad de tap o el tamaño del arbol en que va.
    private DefaultTreeModel modelo; //contiene el nombre de la raiz del arbol que se va a generar.

    /**
     * imprime la cantidad de tap, por donde va el nodo,
     * @param tamannoActual
     */
    private void printtab(int tamannoActual) {
        for (int num = tamannoActual; num != 0; num--)
            System.out.print("-#-");
        System.out.print("]");
    }

    /**
     * Se sobrescriben todos los metodos de la clase MyParserBaseVisitor<?>
     */

    public void setComponenteArbol(DefaultTreeModel modelo ){
        this.modelo = modelo;
    }
    @Override
    public Object visitInicioPrograma(MyParser.InicioProgramaContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        for (int i=0; i <= ctx.statement().size()-1; i++)
            visit(ctx.statement(i));
        cont--;

        return null;
    }

    @Override
    public Object visitDeclaracionDEF(MyParser.DeclaracionDEFContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.defStatement());
        cont--;

        return null;
    }

    @Override
    public Object visitDeclaracionIF(MyParser.DeclaracionIFContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.ifStatement());
        cont--;

        return null;
    }

    @Override
    public Object visitDeclaracionRETURN(MyParser.DeclaracionRETURNContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.returnStatement());
        cont--;

        return null;
    }

    @Override
    public Object visitDeclaracionPRINT(MyParser.DeclaracionPRINTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.printStatement());
        cont--;

        return null;
    }

    @Override
    public Object visitDeclaracionWHILE(MyParser.DeclaracionWHILEContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.whileStatement());
        cont--;

        return null;
    }

    @Override
    public Object visitDeclaracionASSIGN(MyParser.DeclaracionASSIGNContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.assignStatement());
        cont--;

        return null;
    }

    @Override
    public Object visitDeclaracionLLAMADAFUNCION(MyParser.DeclaracionLLAMADAFUNCIONContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.functionCallStatement());
        cont--;

        return null;
    }

    @Override
    public Object visitFuncion(MyParser.FuncionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.argList());
        visit(ctx.sequence());
        cont--;

        return null;
    }

    @Override
    public Object visitListaParametros(MyParser.ListaParametrosContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());
        printtab(cont);
        System.out.println(" Parametro --> " + ctx.IDENTIFIER().getSymbol().getText());

        cont++;
        visit(ctx.moreArgs());
        cont--;

        return null;
    }

    @Override
    public Object visitListaParametroEOS(MyParser.ListaParametroEOSContext ctx) {

        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        return null;
    }

    @Override
    public Object visitMasParametros(MyParser.MasParametrosContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        for (int i = 0; i <= ctx.IDENTIFIER().size() - 1; i++)
        {
            printtab(cont + 1);
            System.out.println(" Parametro --> " + ctx.IDENTIFIER(i).getSymbol().getText());
        }
        cont--;

        return null;
    }

    @Override
    public Object visitIf_y_Else(MyParser.If_y_ElseContext ctx)  {
        //Esperar a que termine
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());
        cont++;
        visit(ctx.expression());
        cont++;
        visit(ctx.sequence(0));
        for (int i=1; i <= ctx.sequence().size()-1; i++)
        {
            visit(ctx.sequence(i));
        }
        cont--;

        return null;
    }

    @Override
    public Object visitWhile(MyParser.WhileContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.expression());
        cont++;
        visit(ctx.sequence());
        cont--;

        return null;
    }

    @Override
    public Object visitReturn(MyParser.ReturnContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.expression());
        cont--;

        return null;
    }

    @Override
    public Object visitPrint(MyParser.PrintContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.expression());
        cont--;

        return null;
    }

    @Override
    public Object visitAsignacion(MyParser.AsignacionContext ctx)  {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName() + " Variable --> " + ctx.IDENTIFIER().getText());

        cont++;
        visit(ctx.expression());
        cont--;

        return null;
    }

    @Override
    public Object visitLlamarFuncion(MyParser.LlamarFuncionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.primitiveExpression());
        visit(ctx.expressionList());
        cont--;

        return null;
    }

    @Override
    public Object visitSecuencia(MyParser.SecuenciaContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.moreStatement());
        cont--;

        return null;
    }

    @Override
    public Object visitMasDeclaraciones(MyParser.MasDeclaracionesContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());
        cont++;
        visit(ctx.statement(0));
        for (int i=1; i <= ctx.statement().size()-1; i++)
        {
            visit(ctx.statement(i));
        }
        cont--;

        return null;
    }

    @Override
    public Object visitExpresion(MyParser.ExpresionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.additionExpression());
        visit(ctx.comparison());
        cont--;

        return null;
    }

    @Override
    public Object visitComparacion(MyParser.ComparacionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        for (int i=0; i <= ctx.additionExpression().size()-1; i++)
        {
            visit(ctx.additionExpression(i));
        }
        cont--;

        return null;
    }

    @Override
    public Object visitEspresionAderencia(MyParser.EspresionAderenciaContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.multiplicationExpression());
        visit(ctx.additionFactor());
        cont--;


        return null;
    }

    @Override
    public Object visitFactorAderencia(MyParser.FactorAderenciaContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        for (int i=0; i <= ctx.multiplicationExpression().size()-1; i++)
        {
            visit(ctx.multiplicationExpression(i));
        }
        cont--;
        return null;
    }

    @Override
    public Object visitExpresionMultiplicacion(MyParser.ExpresionMultiplicacionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.elementExpression());
        visit(ctx.multiplicationFactor());
        cont--;

        return null;
    }

    @Override
    public Object visitFactorMultiplicacion(MyParser.FactorMultiplicacionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        //ctx.
        cont++;
        for (int i=0; i <= ctx.elementExpression().size()-1; i++)
        {
            visit(ctx.elementExpression(i));
        }
        cont--;

        return null;
    }

    @Override
    public Object visitExpresionElemento(MyParser.ExpresionElementoContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.primitiveExpression());
        visit(ctx.elementAccess());
        cont--;


        return null;
    }

    @Override
    public Object visitAccesoElemento(MyParser.AccesoElementoContext ctx) {

        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        for (int i=0; i <= ctx.expression().size()-1; i++)
        {
            visit(ctx.expression(i));
        }
        cont--;

        return null;
    }

    @Override
    public Object visitDeclaracionFuntionCallExpression(MyParser.DeclaracionFuntionCallExpressionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.expressionList());
        cont--;
        return null;
    }

    @Override
    public Object visitListaExpresiones(MyParser.ListaExpresionesContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.expression());
        visit(ctx.moreExpressions());
        cont--;
        return null;
    }

    @Override
    public Object visitListExpressionEOS(MyParser.ListExpressionEOSContext ctx) {
        //Espacio en blanco
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());
        return null;
    }

    @Override
    public Object visitMasExpresiones(MyParser.MasExpresionesContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        for (int i=0; i <= ctx.expression().size()-1; i++)
        {
            visit(ctx.expression(i));
        }
        cont--;

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaINT(MyParser.ExpresionPrimitivaINTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName() + " Token primitivo int: " + ctx.INTEGER().getText());
        return null;
    }

    @Override
    public Object visitExpresionPrimitivaSTRING(MyParser.ExpresionPrimitivaSTRINGContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName() + " Token primitivo string: " + ctx.STRING().getText());
        return null;
    }

    @Override
    public Object visitExpresionPrimitivaID(MyParser.ExpresionPrimitivaIDContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName() + " Token: " + ctx.IDENTIFIER().getText());
        return null;
    }

    @Override
    public Object visitExpresionPrimitivaCHAR(MyParser.ExpresionPrimitivaCHARContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName() + " Token: " + ctx.CHAR().getText());

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaDER_EX_IZQ(MyParser.ExpresionPrimitivaDER_EX_IZQContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.expression());
        cont--;

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaLISTAEXPRESION(MyParser.ExpresionPrimitivaLISTAEXPRESIONContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.listExpression());
        cont--;

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaLEN_PIZQ_EX_PDER(MyParser.ExpresionPrimitivaLEN_PIZQ_EX_PDERContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.expression());
        cont--;

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaFunctionCallExpression(MyParser.ExpresionPrimitivaFunctionCallExpressionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.functionCallExpression());
        cont--;

        return null;
    }

    @Override
    public Object visitListaExpresionesUltima(MyParser.ListaExpresionesUltimaContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        cont++;
        visit(ctx.expressionList());
        cont--;

        return null;
    }


}
