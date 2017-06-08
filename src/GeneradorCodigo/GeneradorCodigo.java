package GeneradorCodigo;

import generated.MyParser;
import generated.MyParserBaseVisitor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by dell on 22/5/2017.
 */
public class GeneradorCodigo extends MyParserBaseVisitor<Object> {

    private int lineas;
    private ArrayList<Instruccion> pilaInstrucciones;
    private Boolean esFuncion;


    @Override
    public Object visitInicioPrograma(MyParser.InicioProgramaContext ctx) {
        this.lineas = 0;
        this.pilaInstrucciones = new ArrayList<Instruccion>();
        esFuncion = false;

        for (int i=0; i <= ctx.statement().size()-1; i++) {
            visit(ctx.statement(i));
        }

        try {
            this.EscribirPilaDeInstrucciones();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        this.AgregarPilaInstrucciones(-1, ctx.IDENTIFIER().getText() + "(" + visit(ctx.argList()).toString() + ")", " ");
        visit(ctx.sequence());

        return null;
    }

    @Override
    public Object visitListaParametros(MyParser.ListaParametrosContext ctx) {

        String primerParametro = ctx.IDENTIFIER().getText();
        if (ctx.moreArgs().getChildCount() != 0){
            primerParametro +=  visit(ctx.moreArgs());
        }
        return primerParametro;
    }

    @Override
    public Object visitListaParametroEOS(MyParser.ListaParametroEOSContext ctx) {
        return " ";
    }

    @Override
    public Object visitMasParametros(MyParser.MasParametrosContext ctx) {
        String masParametros = ", ";
        for (int i = 0; i < ctx.IDENTIFIER().size()-1; i++){
            masParametros += ctx.IDENTIFIER(i).getText() + ", " ;
        }
        masParametros += ctx.IDENTIFIER(ctx.IDENTIFIER().size()-1).getText();

        return masParametros;
    }

    @Override
    public Object visitIf_y_Else(MyParser.If_y_ElseContext ctx) {

        visit(ctx.expression());

        this.AgregarPilaInstrucciones(this.lineas, "JUMP_IF_TRUE", "Agregar linea");
        this.lineas++;

        Instruccion salto = this.pilaInstrucciones.get(this.pilaInstrucciones.size()-1);


        visit(ctx.sequence(1));

        salto.setValor(String.valueOf(this.lineas + 1));


        this.AgregarPilaInstrucciones(this.lineas, "JUMP_ABSOLUTE", "Agregar linea");
        this.lineas++;

        salto = this.pilaInstrucciones.get(this.pilaInstrucciones.size()-1);

        visit(ctx.sequence(0));

        salto.setValor(String.valueOf(this.lineas));

        return null;
    }

    @Override
    public Object visitWhile(MyParser.WhileContext ctx) {

        String volverLinea = String.valueOf(this.lineas);

        visit(ctx.expression());

        this.AgregarPilaInstrucciones(this.lineas, "JUMP_IF_FALSE", " ");
        this.lineas++;

        Instruccion salto = this.pilaInstrucciones.get(this.pilaInstrucciones.size()-1);

        visit(ctx.sequence());

        salto.setValor(String.valueOf(this.lineas + 1));

        this.AgregarPilaInstrucciones(this.lineas, "JUMP_ABSOLUTE", volverLinea);
        this.lineas++;

        return null;
    }

    @Override
    public Object visitReturn(MyParser.ReturnContext ctx) {

        visit(ctx.expression());

        this.AgregarPilaInstrucciones(this.lineas, "RETURN_VALUE", " ");
        this.lineas++;

        return null;
    }

    @Override
    public Object visitPrint(MyParser.PrintContext ctx) {

        this.AgregarPilaInstrucciones(this.lineas, "LOAD_GLOBAL", "print");
        this.lineas++;

        visit(ctx.expression());

        this.AgregarPilaInstrucciones(this.lineas, "CALL_FUNCTION", "1");
        this.lineas++;

        return null;
    }

    @Override
    public Object visitAsignacion(MyParser.AsignacionContext ctx) {

        visit(ctx.expression());

        this.AgregarPilaInstrucciones(this.lineas, "STORE_FAST", ctx.IDENTIFIER().getText());
        this.lineas++;

        return null;
    }

    @Override
    public Object visitLlamarFuncion(MyParser.LlamarFuncionContext ctx) {

        esFuncion = true;

        visit(ctx.primitiveExpression());

        int expresiones = (int) visit(ctx.expressionList());

        this.AgregarPilaInstrucciones(this.lineas, "CALL_FUNCTION", String.valueOf(expresiones));
        this.lineas++;

        return null;
    }

    @Override
    public Object visitSecuencia(MyParser.SecuenciaContext ctx) {

        visit(ctx.moreStatement());

        return null;
    }

    @Override
    public Object visitMasDeclaraciones(MyParser.MasDeclaracionesContext ctx) {

        for (int i = 0; i <= ctx.statement().size()-1; i++) {
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

        for (int i = 0; i <= ctx.additionExpression().size()-1 ; i++) {
            visit(ctx.additionExpression(i));
            visit(ctx.signosComparacion(i));
        }

        return null;
    }

    @Override
    public Object visitSignosComparacion(MyParser.SignosComparacionContext ctx) {

        if (ctx.MAQUE() != null) {
            this.AgregarPilaInstrucciones(this.lineas, "COMPARE_OP", ctx.MAQUE().getText());
            this.lineas++;
            return null;
        } else if (ctx.MEQUE() != null) {
            this.AgregarPilaInstrucciones(this.lineas, "COMPARE_OP", ctx.MEQUE().getText());
            this.lineas++;
            return null;
        } else if (ctx.MEOIQUE() != null) {
            this.AgregarPilaInstrucciones(this.lineas, "COMPARE_OP", ctx.MEOIQUE().getText());
            this.lineas++;
            return null;
        } else if (ctx.MAOIQUE() != null){
            this.AgregarPilaInstrucciones(this.lineas, "COMPARE_OP", ctx.MAOIQUE().getText());
            this.lineas++;
            return null;
        } else  {
            this.AgregarPilaInstrucciones(this.lineas, "COMPARE_OP", ctx.IGUALQUE().getText());
            this.lineas++;
            return null;
        }

    }

    @Override
    public Object visitEspresionAderencia(MyParser.EspresionAderenciaContext ctx) {

        visit(ctx.multiplicationExpression());
        visit(ctx.additionFactor());

        return null;
    }

    @Override
    public Object visitFactorAderencia(MyParser.FactorAderenciaContext ctx) {

        for (int i = 0; i <= ctx.multiplicationExpression().size()-1 ; i++) {
            visit(ctx.multiplicationExpression(i));
            visit(ctx.signosSumaResta(i));
        }

        return null;
    }

    @Override
    public Object visitSignosSumaResta(MyParser.SignosSumaRestaContext ctx) {
        if (ctx.SUMA() != null) {
            this.AgregarPilaInstrucciones(this.lineas, "BINARY_ADD", ctx.SUMA().getText());
            this.lineas++;

            return null;

        } else {
            this.AgregarPilaInstrucciones(this.lineas, "BINARY_SUBSTRACT", ctx.RESTA().getText());
            this.lineas++;

            return null;

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

        for (int i = 0; i <= ctx.signosOperativos().size()-1; i++) {
            visit(ctx.elementExpression(i));
            visit(ctx.signosOperativos(i));
        }

        return null;
    }

    @Override
    public Object visitSignosOperativos(MyParser.SignosOperativosContext ctx) {
        if (ctx.MUL() != null) {
            this.AgregarPilaInstrucciones(this.lineas, "BINARY_MULTIPLY", ctx.MUL().getText());
            this.lineas++;

            return null;
        } else {
            this.AgregarPilaInstrucciones(this.lineas, "BINARY_DIVIDE", ctx.DIV().getText());
            this.lineas++;

            return null;
        }
    }

    //todo: Pendiente
    @Override
    public Object visitExpresionElemento(MyParser.ExpresionElementoContext ctx) {

        visit(ctx.primitiveExpression());

        if (ctx.elementAccess().children != null){
            visit(ctx.elementAccess());
            this.AgregarPilaInstrucciones(this.lineas, "BINARY_SUBSCR", " ");
            this.lineas++;

        }

        return null;
    }

    //todo: Pendiente
    @Override
    public Object visitAccesoElemento(MyParser.AccesoElementoContext ctx) {
        visit(ctx.expression(0));
        return null;
    }

    @Override
    public Object visitDeclaracionFuntionCallExpression(MyParser.DeclaracionFuntionCallExpressionContext ctx) {

        this.AgregarPilaInstrucciones(this.lineas, "LOAD_GLOBAL", ctx.IDENTIFIER().getText());
        this.lineas++;

        int expresiones = (int) visit(ctx.expressionList());

        this.AgregarPilaInstrucciones(this.lineas, "CALL_FUNCTION", String.valueOf(expresiones));
        this.lineas++;

        return null;
    }

    @Override
    public Object visitListaExpresiones(MyParser.ListaExpresionesContext ctx) {

        visit(ctx.expression());

        int contadorExpresiones = 1;

        contadorExpresiones += (int) visit(ctx.moreExpressions());

        return contadorExpresiones;
    }

    @Override
    public Object visitListExpressionEOS(MyParser.ListExpressionEOSContext ctx) {

        return 0;
    }

    @Override
    public Object visitMasExpresiones(MyParser.MasExpresionesContext ctx) {
        int contadorMasExpresiones = 0;
        for (int i = 0; i <= ctx.expression().size()-1 ; i++) {
            visit(ctx.expression(i));
            contadorMasExpresiones ++;
        }

        return contadorMasExpresiones;
    }

    /**
     * Colocar el numero entero en pila.
     * @param ctx
     * @return
     */
    @Override
    public Object visitExpresionPrimitivaINT(MyParser.ExpresionPrimitivaINTContext ctx) {

        this.AgregarPilaInstrucciones(this.lineas, "LOAD_CONST", ctx.INTEGER().getText());
        this.lineas++;

        return null;
    }

    /**
     * Colocar el string en la pila.
     * @param ctx
     * @return
     */
    @Override
    public Object visitExpresionPrimitivaSTRING(MyParser.ExpresionPrimitivaSTRINGContext ctx) {

        this.AgregarPilaInstrucciones(this.lineas, "LOAD_CONST", ctx.STRING().getText());
        this.lineas++;

        return null;
    }

    /**
     * Colocar el contenido de la variable en la pila.
     * @param ctx
     * @return
     */
    @Override
    public Object visitExpresionPrimitivaID(MyParser.ExpresionPrimitivaIDContext ctx) {

        if (esFuncion){
            this.AgregarPilaInstrucciones(this.lineas, "LOAD_GLOBAL", ctx.IDENTIFIER().getText());
            this.lineas++;
            esFuncion = false;
        }
        else {
            this.AgregarPilaInstrucciones(this.lineas, "LOAD_FAST", ctx.IDENTIFIER().getText());
            this.lineas++;
        }

        return null;
    }

    /**
     * Colocar el char en la pila.
     * @param ctx
     * @return
     */
    @Override
    public Object visitExpresionPrimitivaCHAR(MyParser.ExpresionPrimitivaCHARContext ctx) {

        this.AgregarPilaInstrucciones(this.lineas, "LOAD_CONST", ctx.CHAR().getText());
        this.lineas++;

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaDER_EX_IZQ(MyParser.ExpresionPrimitivaDER_EX_IZQContext ctx) {

        visit(ctx.expression());    //Visita la expresion primitiva...

        return null;
    }

    @Override
    public Object visitExpresionPrimitivaLISTAEXPRESION(MyParser.ExpresionPrimitivaLISTAEXPRESIONContext ctx) {
        visit(ctx.listExpression());
        return null;

    }

    @Override
    public Object visitExpresionPrimitivaLEN_PIZQ_EX_PDER(MyParser.ExpresionPrimitivaLEN_PIZQ_EX_PDERContext ctx) {

        this.AgregarPilaInstrucciones(this.lineas, "LOAD_GLOBAL", "len" );
        this.lineas++;

        visit(ctx.expression());

        this.AgregarPilaInstrucciones(this.lineas, "CALL_FUNCTION", "1");
        this.lineas++;

        return null;

    }

    @Override
    public Object visitExpresionPrimitivaFunctionCallExpression(MyParser.ExpresionPrimitivaFunctionCallExpressionContext ctx) {

        visit(ctx.functionCallExpression());
        return null;
    }

    @Override
    public Object visitListaExpresionesUltima(MyParser.ListaExpresionesUltimaContext ctx) {
        int cantidad = (int)visit(ctx.expressionList());
        this.AgregarPilaInstrucciones(this.lineas, "BUILD_LIST", String.valueOf(cantidad));
        this.lineas++;

        return null;

    }

    /**
     * Agrega a la pila (lista) las instrucciones generadas.
     * @param _linea
     * @param _instruccion
     * @param _valor
     */
    private void AgregarPilaInstrucciones(int _linea, String _instruccion, String _valor){

        if (_linea == -1) {
            this.pilaInstrucciones.add(new Instruccion(_instruccion, "", _valor));
        } else {
            this.pilaInstrucciones.add(new Instruccion(_instruccion, String.valueOf(_linea) , _valor));
        }


    }

    /**
     * Escribe la pila de instrucciones (lista) en un documento txt...
     */
    private void EscribirPilaDeInstrucciones() throws IOException {
        for (int i = 0; i < this.pilaInstrucciones.size(); i++) {
            System.out.println(this.pilaInstrucciones.get(i).getNumeroLinea()+" "+
                    this.pilaInstrucciones.get(i).getInstruccion() + " " +  this.pilaInstrucciones.get(i).getValor());
        }
        File archivo = new File("codigoGenerado.txt"); //Busca el archivo de aqui en adelante empieza a escribir...
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i <= this.pilaInstrucciones.size()-1; i++) {
                bw.write(this.pilaInstrucciones.get(i).getNumeroLinea()+" "+
                        this.pilaInstrucciones.get(i).getInstruccion() + " " +
                        this.pilaInstrucciones.get(i).getValor());
                bw.newLine();
            }

        } else {
            archivo.createNewFile();
            bw = new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i <= this.pilaInstrucciones.size()-1; i++) {
                bw.write(this.pilaInstrucciones.get(i).getNumeroLinea()+" "+
                        this.pilaInstrucciones.get(i).getInstruccion() + " " +
                        this.pilaInstrucciones.get(i).getValor());
                bw.newLine();
            }
        }
        bw.close();
        return;
    }
}
