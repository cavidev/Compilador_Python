package arbol; /**
 * Created by Carlos Mario on 26/3/2017.
 */

import generated.MyParser;
import generated.MyParserBaseVisitor;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * Esta clase imprime en consola y de manera gráfica un arbol de nodos. Estos nodos son las visitas del parser
 * implementado en este proyecto, cada nodo nuevo es un tap (consola) o carpeta(GUI), se llevara
 * el control de estos nodos con una variable global cont y un nodo padre para el caso de GUI.
 */
public class Arbol extends MyParserBaseVisitor<Object> {

    private int cont=0;         //Lleva la cuenta de la cantidad de tap o el tamaño del arbol en que va.
    private JTree arbolVista;   //instancia de la clase para el arbol en GUI
    DefaultTreeModel modelo;    //instancia del modelo para la clase JTree
    DefaultMutableTreeNode nodoPadre;   //Control de los nodos, guarda el nodo anterior.

    /**
     * Imprime la cantidad de tap, por donde va el nodo.
     * @param tamannoActual
     */
    private void printtab(int tamannoActual) {
        for (int num = tamannoActual; num != 0; num--)
            System.out.print("-#-");
        System.out.print("]");
    }

    /**
     * Recibe el arbol JTree de la vista del editor de texto.
     * @param arbol
     */
    public void setComponenteArbol(JTree arbol){
        this.arbolVista = arbol;
    }

    /**
     * Se sobrescriben todos los metodos de la clase MyParserBaseVisitor<?>, esto con el fin de adecuarlos para imprimir
     * en consola y en la GUI, se imprimiran los tokens cambiantes como los nombres de variables, expresiones primarias
     * (int | string) y los parametros de la función.
     */

    @Override
    public Object visitInicioPrograma(MyParser.InicioProgramaContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoRaiz = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo = new DefaultTreeModel(nodoRaiz);
        arbolVista.setModel(modelo);
        nodoPadre = nodoRaiz;

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
    public Object visitDeclaracionDEF(MyParser.DeclaracionDEFContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.defStatement());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitDeclaracionIF(MyParser.DeclaracionIFContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.ifStatement());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitDeclaracionRETURN(MyParser.DeclaracionRETURNContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.returnStatement());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitDeclaracionPRINT(MyParser.DeclaracionPRINTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.printStatement());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitDeclaracionWHILE(MyParser.DeclaracionWHILEContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.whileStatement());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitDeclaracionASSIGN(MyParser.DeclaracionASSIGNContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.assignStatement());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitDeclaracionLLAMADAFUNCION(MyParser.DeclaracionLLAMADAFUNCIONContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.functionCallStatement());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitFuncion(MyParser.FuncionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);

        DefaultMutableTreeNode temp = nodoPadre;

        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.argList());
        visit(ctx.sequence());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitListaParametros(MyParser.ListaParametrosContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        printtab(cont);
        System.out.println(" Parametro --> " + ctx.IDENTIFIER().getSymbol().getText());

        DefaultMutableTreeNode hoja = new DefaultMutableTreeNode(ctx.IDENTIFIER().getSymbol().getText());
        modelo.insertNodeInto(hoja, nodoHijo, 0);

        cont++;
        visit(ctx.moreArgs());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitListaParametroEOS(MyParser.ListaParametroEOSContext ctx) {

        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);

        return null;
    }

    @Override
    public Object visitMasParametros(MyParser.MasParametrosContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        for (int i = 0; i <= ctx.IDENTIFIER().size() - 1; i++)
        {
            printtab(cont + 1);
            System.out.println(" Parametro --> " + ctx.IDENTIFIER(i).getSymbol().getText());

            DefaultMutableTreeNode hoja = new DefaultMutableTreeNode(ctx.IDENTIFIER(i).getSymbol().getText());
            modelo.insertNodeInto(hoja, nodoHijo, 0);
        }
        cont--;

        nodoPadre = temp;
        return null;
    }

    @Override
    public Object visitIf_y_Else(MyParser.If_y_ElseContext ctx)  {
        //Esperar a que termine
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.expression());
        cont++;
        visit(ctx.sequence(0));
        for (int i=1; i <= ctx.sequence().size()-1; i++)
        {
            visit(ctx.sequence(i));
        }
        cont--;

        nodoPadre = temp;
        return null;
    }

    @Override
    public Object visitWhile(MyParser.WhileContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.expression());
        cont++;
        visit(ctx.sequence());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitReturn(MyParser.ReturnContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.expression());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitPrint(MyParser.PrintContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.expression());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitAsignacion(MyParser.AsignacionContext ctx)  {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName() + " Variable --> " + ctx.IDENTIFIER().getText());
        printtab(cont + 2);
        System.out.println(ctx.getClass().getSimpleName() + " Token --> " + ctx.ASIGN().getText());

        DefaultMutableTreeNode hojaVariable = new DefaultMutableTreeNode(ctx.IDENTIFIER().getText()); //Nodos hojas.
        modelo.insertNodeInto(hojaVariable, nodoPadre, 0);
        DefaultMutableTreeNode hojaSimbolo = new DefaultMutableTreeNode(ctx.ASIGN().getText());
        modelo.insertNodeInto(hojaSimbolo, nodoPadre, 0);

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName()); //Procedimiento normal.
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);

        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.expression());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitLlamarFuncion(MyParser.LlamarFuncionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.primitiveExpression());
        visit(ctx.expressionList());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitSecuencia(MyParser.SecuenciaContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.moreStatement());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitMasDeclaraciones(MyParser.MasDeclaracionesContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.statement(0));
        for (int i=1; i <= ctx.statement().size()-1; i++)
        {
            visit(ctx.statement(i));
        }
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitExpresion(MyParser.ExpresionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.additionExpression());
        visit(ctx.comparison());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitComparacion(MyParser.ComparacionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        for (int i=0; i <= ctx.additionExpression().size()-1; i++)
        {
            visit(ctx.signosComparacion(i));
            visit(ctx.additionExpression(i));
        }
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitSignosComparacion(MyParser.SignosComparacionContext ctx) {
        if (ctx.MAQUE() != null) {
            printtab(cont +1);
            System.out.println(ctx.getClass().getSimpleName()+ " " + ctx.MAQUE().getSymbol().getText());
            DefaultMutableTreeNode hoja = new DefaultMutableTreeNode(ctx.MAQUE().getSymbol().getText());
            modelo.insertNodeInto(hoja, nodoPadre, 0);
        } else if (ctx.MEQUE() != null) {
            printtab(cont +1);
            System.out.println(ctx.getClass().getSimpleName()+ " " + ctx.MEQUE().getSymbol().getText());
            DefaultMutableTreeNode hoja = new DefaultMutableTreeNode(ctx.MEQUE().getSymbol().getText());
            modelo.insertNodeInto(hoja, nodoPadre, 0);
        } else if (ctx.MEOIQUE() != null) {
            printtab(cont +1);
            System.out.println(ctx.getClass().getSimpleName()+ " " + ctx.MEOIQUE().getSymbol().getText());
            DefaultMutableTreeNode hoja = new DefaultMutableTreeNode(ctx.MEOIQUE().getSymbol().getText());
            modelo.insertNodeInto(hoja, nodoPadre, 0);
        } else if (ctx.MAOIQUE() != null) {
            printtab(cont +1);
            System.out.println(ctx.getClass().getSimpleName()+ " " + ctx.MAOIQUE().getSymbol().getText());
            DefaultMutableTreeNode hoja = new DefaultMutableTreeNode(ctx.MAOIQUE().getSymbol().getText());
            modelo.insertNodeInto(hoja, nodoPadre, 0);
        } else {
            printtab(cont +1);
            System.out.println(ctx.getClass().getSimpleName()+ " " + ctx.IGUALQUE().getSymbol().getText());
            DefaultMutableTreeNode hoja = new DefaultMutableTreeNode(ctx.IGUALQUE().getSymbol().getText());
            modelo.insertNodeInto(hoja, nodoPadre, 0);
        }


        return null;
    }

    @Override
    public Object visitEspresionAderencia(MyParser.EspresionAderenciaContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.multiplicationExpression());
        visit(ctx.additionFactor());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitFactorAderencia(MyParser.FactorAderenciaContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        for (int i=0; i <= ctx.multiplicationExpression().size()-1; i++)
        {
            visit(ctx.signosSumaResta(i));
            visit(ctx.multiplicationExpression(i));
        }
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitSignosSumaResta(MyParser.SignosSumaRestaContext ctx) {
        if (ctx.RESTA() == null) {
            printtab(cont +1);
            System.out.println(ctx.getClass().getSimpleName()+ " " + ctx.SUMA().getSymbol().getText());
            DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.SUMA().getText());
            modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        } else {
            printtab(cont +1);
            System.out.println(ctx.getClass().getSimpleName()+ " " + ctx.RESTA().getSymbol().getText());
            DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.RESTA().getText());
            modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        }

        return null;
    }

    @Override
    public Object visitExpresionMultiplicacion(MyParser.ExpresionMultiplicacionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.elementExpression());
        visit(ctx.multiplicationFactor());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitFactorMultiplicacion(MyParser.FactorMultiplicacionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);

        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        for (int i=0; i <= ctx.elementExpression().size()-1; i++)
        {
            visit(ctx.signosOperativos(i));
            visit(ctx.elementExpression(i));
        }
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitSignosOperativos(MyParser.SignosOperativosContext ctx) {

        if (ctx.MUL() == null) {
            printtab(cont +1);
            System.out.println(ctx.getClass().getSimpleName()+ " " + ctx.DIV().getSymbol().getText());
            DefaultMutableTreeNode hoja = new DefaultMutableTreeNode(ctx.DIV().getSymbol().getText());
            modelo.insertNodeInto(hoja, nodoPadre, 0);
        } else {
            printtab(cont +1);
            System.out.println(ctx.getClass().getSimpleName()+ " " + ctx.MUL().getSymbol().getText());
            DefaultMutableTreeNode hoja = new DefaultMutableTreeNode(ctx.MUL().getSymbol().getText());
            modelo.insertNodeInto(hoja, nodoPadre, 0);
        }

        return null;
    }

    @Override
    public Object visitExpresionElemento(MyParser.ExpresionElementoContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.primitiveExpression());
        visit(ctx.elementAccess());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitAccesoElemento(MyParser.AccesoElementoContext ctx) {

        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        for (int i=0; i <= ctx.expression().size()-1; i++)
        {
            visit(ctx.expression(i));
        }
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitDeclaracionFuntionCallExpression(MyParser.DeclaracionFuntionCallExpressionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.expressionList());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitListaExpresiones(MyParser.ListaExpresionesContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.expression());
        visit(ctx.moreExpressions());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitListExpressionEOS(MyParser.ListExpressionEOSContext ctx) {
        //Espacio en blanco
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);

        return null;
    }

    @Override
    public Object visitMasExpresiones(MyParser.MasExpresionesContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        for (int i=0; i <= ctx.expression().size()-1; i++)
        {
            visit(ctx.expression(i));
        }
        cont--;

        nodoPadre = temp;
        return null;
    }

    @Override
    public Object visitExpresionPrimitivaINT(MyParser.ExpresionPrimitivaINTContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName() + " Token primitivo int: " + ctx.INTEGER().getText());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(" Token primitivo int: " + ctx.INTEGER().getText());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaSTRING(MyParser.ExpresionPrimitivaSTRINGContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName() + " Token primitivo string: " + ctx.STRING().getText());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(" Token primitivo string: " + ctx.STRING().getText());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaID(MyParser.ExpresionPrimitivaIDContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName() + " Token: " + ctx.IDENTIFIER().getText());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode("Token: " + ctx.IDENTIFIER().getText());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        return null;
    }

    @Override
    public Object visitExpresionPrimitivaCHAR(MyParser.ExpresionPrimitivaCHARContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName() + " Token: " + ctx.CHAR().getText());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode("Token: " + ctx.CHAR().getText());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaDER_EX_IZQ(MyParser.ExpresionPrimitivaDER_EX_IZQContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.expression());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaLISTAEXPRESION(MyParser.ExpresionPrimitivaLISTAEXPRESIONContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.listExpression());
        cont--;

        nodoPadre = temp;

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaLEN_PIZQ_EX_PDER(MyParser.ExpresionPrimitivaLEN_PIZQ_EX_PDERContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.expression());
        cont--;

        nodoPadre = temp;
        return null;
    }

    @Override
    public Object visitExpresionPrimitivaFunctionCallExpression(MyParser.ExpresionPrimitivaFunctionCallExpressionContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.functionCallExpression());
        cont--;

        nodoPadre = temp;
        return null;
    }

    @Override
    public Object visitListaExpresionesUltima(MyParser.ListaExpresionesUltimaContext ctx) {
        printtab(cont);
        System.out.println(ctx.getClass().getSimpleName());

        DefaultMutableTreeNode nodoHijo = new DefaultMutableTreeNode(ctx.getClass().getSimpleName());
        modelo.insertNodeInto(nodoHijo, nodoPadre, 0);
        DefaultMutableTreeNode temp = nodoPadre;
        nodoPadre = nodoHijo;

        cont++;
        visit(ctx.expressionList());
        cont--;

        nodoPadre = temp;

        return null;
    }

}