// Generated from C:/Users/dell/Documents/Documentos de la U/Quinto Semestre/Compiladores e Interpretes/Proyecto 1\MyParser.g4 by ANTLR 4.6
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code inicioPrograma}
	 * labeled alternative in {@link MyParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicioPrograma(MyParser.InicioProgramaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionDEF}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionDEF(MyParser.DeclaracionDEFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionIF}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionIF(MyParser.DeclaracionIFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionRETURN}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionRETURN(MyParser.DeclaracionRETURNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionPRINT}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionPRINT(MyParser.DeclaracionPRINTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionWHILE}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionWHILE(MyParser.DeclaracionWHILEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionASSIGN}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionASSIGN(MyParser.DeclaracionASSIGNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionLLAMADAFUNCION}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionLLAMADAFUNCION(MyParser.DeclaracionLLAMADAFUNCIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcion}
	 * labeled alternative in {@link MyParser#defStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion(MyParser.FuncionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listaParametros}
	 * labeled alternative in {@link MyParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaParametros(MyParser.ListaParametrosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listaParametroEOS}
	 * labeled alternative in {@link MyParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaParametroEOS(MyParser.ListaParametroEOSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masParametros}
	 * labeled alternative in {@link MyParser#moreArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasParametros(MyParser.MasParametrosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_y_Else}
	 * labeled alternative in {@link MyParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_y_Else(MyParser.If_y_ElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link MyParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(MyParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return}
	 * labeled alternative in {@link MyParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(MyParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link MyParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(MyParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asignacion}
	 * labeled alternative in {@link MyParser#assignStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(MyParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code llamarFuncion}
	 * labeled alternative in {@link MyParser#functionCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamarFuncion(MyParser.LlamarFuncionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code secuencia}
	 * labeled alternative in {@link MyParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecuencia(MyParser.SecuenciaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masDeclaraciones}
	 * labeled alternative in {@link MyParser#moreStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasDeclaraciones(MyParser.MasDeclaracionesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresion}
	 * labeled alternative in {@link MyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(MyParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparacion}
	 * labeled alternative in {@link MyParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparacion(MyParser.ComparacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#signosComparacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignosComparacion(MyParser.SignosComparacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code espresionAderencia}
	 * labeled alternative in {@link MyParser#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEspresionAderencia(MyParser.EspresionAderenciaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorAderencia}
	 * labeled alternative in {@link MyParser#additionFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorAderencia(MyParser.FactorAderenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#signosSumaResta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignosSumaResta(MyParser.SignosSumaRestaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionMultiplicacion}
	 * labeled alternative in {@link MyParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionMultiplicacion(MyParser.ExpresionMultiplicacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorMultiplicacion}
	 * labeled alternative in {@link MyParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorMultiplicacion(MyParser.FactorMultiplicacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyParser#signosOperativos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignosOperativos(MyParser.SignosOperativosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionElemento}
	 * labeled alternative in {@link MyParser#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionElemento(MyParser.ExpresionElementoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accesoElemento}
	 * labeled alternative in {@link MyParser#elementAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccesoElemento(MyParser.AccesoElementoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaracionFuntionCallExpression}
	 * labeled alternative in {@link MyParser#functionCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionFuntionCallExpression(MyParser.DeclaracionFuntionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listaExpresiones}
	 * labeled alternative in {@link MyParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaExpresiones(MyParser.ListaExpresionesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listExpressionEOS}
	 * labeled alternative in {@link MyParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpressionEOS(MyParser.ListExpressionEOSContext ctx);
	/**
	 * Visit a parse tree produced by the {@code masExpresiones}
	 * labeled alternative in {@link MyParser#moreExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMasExpresiones(MyParser.MasExpresionesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionPrimitivaINT}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionPrimitivaINT(MyParser.ExpresionPrimitivaINTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionPrimitivaSTRING}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionPrimitivaSTRING(MyParser.ExpresionPrimitivaSTRINGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionPrimitivaID}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionPrimitivaID(MyParser.ExpresionPrimitivaIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionPrimitivaCHAR}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionPrimitivaCHAR(MyParser.ExpresionPrimitivaCHARContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionPrimitivaDER_EX_IZQ}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionPrimitivaDER_EX_IZQ(MyParser.ExpresionPrimitivaDER_EX_IZQContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionPrimitivaLISTAEXPRESION}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionPrimitivaLISTAEXPRESION(MyParser.ExpresionPrimitivaLISTAEXPRESIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionPrimitivaLEN_PIZQ_EX_PDER}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionPrimitivaLEN_PIZQ_EX_PDER(MyParser.ExpresionPrimitivaLEN_PIZQ_EX_PDERContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expresionPrimitivaFunctionCallExpression}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionPrimitivaFunctionCallExpression(MyParser.ExpresionPrimitivaFunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listaExpresionesUltima}
	 * labeled alternative in {@link MyParser#listExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListaExpresionesUltima(MyParser.ListaExpresionesUltimaContext ctx);
}