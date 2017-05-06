// Generated from C:/Users/esteb/IdeaProjects/Compilador_Python\MyParser.g4 by ANTLR 4.6
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyParser}.
 */
public interface MyParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code inicioPrograma}
	 * labeled alternative in {@link MyParser#program}.
	 * @param ctx the parse tree
	 */
	void enterInicioPrograma(MyParser.InicioProgramaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inicioPrograma}
	 * labeled alternative in {@link MyParser#program}.
	 * @param ctx the parse tree
	 */
	void exitInicioPrograma(MyParser.InicioProgramaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaracionDEF}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionDEF(MyParser.DeclaracionDEFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaracionDEF}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionDEF(MyParser.DeclaracionDEFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaracionIF}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionIF(MyParser.DeclaracionIFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaracionIF}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionIF(MyParser.DeclaracionIFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaracionRETURN}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionRETURN(MyParser.DeclaracionRETURNContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaracionRETURN}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionRETURN(MyParser.DeclaracionRETURNContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaracionPRINT}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionPRINT(MyParser.DeclaracionPRINTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaracionPRINT}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionPRINT(MyParser.DeclaracionPRINTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaracionWHILE}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionWHILE(MyParser.DeclaracionWHILEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaracionWHILE}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionWHILE(MyParser.DeclaracionWHILEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaracionASSIGN}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionASSIGN(MyParser.DeclaracionASSIGNContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaracionASSIGN}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionASSIGN(MyParser.DeclaracionASSIGNContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaracionLLAMADAFUNCION}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionLLAMADAFUNCION(MyParser.DeclaracionLLAMADAFUNCIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaracionLLAMADAFUNCION}
	 * labeled alternative in {@link MyParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionLLAMADAFUNCION(MyParser.DeclaracionLLAMADAFUNCIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcion}
	 * labeled alternative in {@link MyParser#defStatement}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(MyParser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcion}
	 * labeled alternative in {@link MyParser#defStatement}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(MyParser.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listaParametros}
	 * labeled alternative in {@link MyParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterListaParametros(MyParser.ListaParametrosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listaParametros}
	 * labeled alternative in {@link MyParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitListaParametros(MyParser.ListaParametrosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listaParametroEOS}
	 * labeled alternative in {@link MyParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterListaParametroEOS(MyParser.ListaParametroEOSContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listaParametroEOS}
	 * labeled alternative in {@link MyParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitListaParametroEOS(MyParser.ListaParametroEOSContext ctx);
	/**
	 * Enter a parse tree produced by the {@code masParametros}
	 * labeled alternative in {@link MyParser#moreArgs}.
	 * @param ctx the parse tree
	 */
	void enterMasParametros(MyParser.MasParametrosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code masParametros}
	 * labeled alternative in {@link MyParser#moreArgs}.
	 * @param ctx the parse tree
	 */
	void exitMasParametros(MyParser.MasParametrosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if_y_Else}
	 * labeled alternative in {@link MyParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIf_y_Else(MyParser.If_y_ElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if_y_Else}
	 * labeled alternative in {@link MyParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIf_y_Else(MyParser.If_y_ElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link MyParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhile(MyParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link MyParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhile(MyParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return}
	 * labeled alternative in {@link MyParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturn(MyParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return}
	 * labeled alternative in {@link MyParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturn(MyParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link MyParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrint(MyParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link MyParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrint(MyParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asignacion}
	 * labeled alternative in {@link MyParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(MyParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asignacion}
	 * labeled alternative in {@link MyParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(MyParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code llamarFuncion}
	 * labeled alternative in {@link MyParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterLlamarFuncion(MyParser.LlamarFuncionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code llamarFuncion}
	 * labeled alternative in {@link MyParser#functionCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitLlamarFuncion(MyParser.LlamarFuncionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code secuencia}
	 * labeled alternative in {@link MyParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSecuencia(MyParser.SecuenciaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code secuencia}
	 * labeled alternative in {@link MyParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSecuencia(MyParser.SecuenciaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code masDeclaraciones}
	 * labeled alternative in {@link MyParser#moreStatement}.
	 * @param ctx the parse tree
	 */
	void enterMasDeclaraciones(MyParser.MasDeclaracionesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code masDeclaraciones}
	 * labeled alternative in {@link MyParser#moreStatement}.
	 * @param ctx the parse tree
	 */
	void exitMasDeclaraciones(MyParser.MasDeclaracionesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expresion}
	 * labeled alternative in {@link MyParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(MyParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expresion}
	 * labeled alternative in {@link MyParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(MyParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparacion}
	 * labeled alternative in {@link MyParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparacion(MyParser.ComparacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparacion}
	 * labeled alternative in {@link MyParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparacion(MyParser.ComparacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#signosComparacion}.
	 * @param ctx the parse tree
	 */
	void enterSignosComparacion(MyParser.SignosComparacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#signosComparacion}.
	 * @param ctx the parse tree
	 */
	void exitSignosComparacion(MyParser.SignosComparacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code espresionAderencia}
	 * labeled alternative in {@link MyParser#additionExpression}.
	 * @param ctx the parse tree
	 */
	void enterEspresionAderencia(MyParser.EspresionAderenciaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code espresionAderencia}
	 * labeled alternative in {@link MyParser#additionExpression}.
	 * @param ctx the parse tree
	 */
	void exitEspresionAderencia(MyParser.EspresionAderenciaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorAderencia}
	 * labeled alternative in {@link MyParser#additionFactor}.
	 * @param ctx the parse tree
	 */
	void enterFactorAderencia(MyParser.FactorAderenciaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorAderencia}
	 * labeled alternative in {@link MyParser#additionFactor}.
	 * @param ctx the parse tree
	 */
	void exitFactorAderencia(MyParser.FactorAderenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#signosSumaResta}.
	 * @param ctx the parse tree
	 */
	void enterSignosSumaResta(MyParser.SignosSumaRestaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#signosSumaResta}.
	 * @param ctx the parse tree
	 */
	void exitSignosSumaResta(MyParser.SignosSumaRestaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expresionMultiplicacion}
	 * labeled alternative in {@link MyParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpresionMultiplicacion(MyParser.ExpresionMultiplicacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expresionMultiplicacion}
	 * labeled alternative in {@link MyParser#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpresionMultiplicacion(MyParser.ExpresionMultiplicacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorMultiplicacion}
	 * labeled alternative in {@link MyParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 */
	void enterFactorMultiplicacion(MyParser.FactorMultiplicacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorMultiplicacion}
	 * labeled alternative in {@link MyParser#multiplicationFactor}.
	 * @param ctx the parse tree
	 */
	void exitFactorMultiplicacion(MyParser.FactorMultiplicacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyParser#signosOperativos}.
	 * @param ctx the parse tree
	 */
	void enterSignosOperativos(MyParser.SignosOperativosContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyParser#signosOperativos}.
	 * @param ctx the parse tree
	 */
	void exitSignosOperativos(MyParser.SignosOperativosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expresionElemento}
	 * labeled alternative in {@link MyParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpresionElemento(MyParser.ExpresionElementoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expresionElemento}
	 * labeled alternative in {@link MyParser#elementExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpresionElemento(MyParser.ExpresionElementoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accesoElemento}
	 * labeled alternative in {@link MyParser#elementAccess}.
	 * @param ctx the parse tree
	 */
	void enterAccesoElemento(MyParser.AccesoElementoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accesoElemento}
	 * labeled alternative in {@link MyParser#elementAccess}.
	 * @param ctx the parse tree
	 */
	void exitAccesoElemento(MyParser.AccesoElementoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declaracionFuntionCallExpression}
	 * labeled alternative in {@link MyParser#functionCallExpression}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionFuntionCallExpression(MyParser.DeclaracionFuntionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declaracionFuntionCallExpression}
	 * labeled alternative in {@link MyParser#functionCallExpression}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionFuntionCallExpression(MyParser.DeclaracionFuntionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listaExpresiones}
	 * labeled alternative in {@link MyParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterListaExpresiones(MyParser.ListaExpresionesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listaExpresiones}
	 * labeled alternative in {@link MyParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitListaExpresiones(MyParser.ListaExpresionesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpressionEOS}
	 * labeled alternative in {@link MyParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterListExpressionEOS(MyParser.ListExpressionEOSContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpressionEOS}
	 * labeled alternative in {@link MyParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitListExpressionEOS(MyParser.ListExpressionEOSContext ctx);
	/**
	 * Enter a parse tree produced by the {@code masExpresiones}
	 * labeled alternative in {@link MyParser#moreExpressions}.
	 * @param ctx the parse tree
	 */
	void enterMasExpresiones(MyParser.MasExpresionesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code masExpresiones}
	 * labeled alternative in {@link MyParser#moreExpressions}.
	 * @param ctx the parse tree
	 */
	void exitMasExpresiones(MyParser.MasExpresionesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expresionPrimitivaINT}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpresionPrimitivaINT(MyParser.ExpresionPrimitivaINTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expresionPrimitivaINT}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpresionPrimitivaINT(MyParser.ExpresionPrimitivaINTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expresionPrimitivaSTRING}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpresionPrimitivaSTRING(MyParser.ExpresionPrimitivaSTRINGContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expresionPrimitivaSTRING}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpresionPrimitivaSTRING(MyParser.ExpresionPrimitivaSTRINGContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expresionPrimitivaID}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpresionPrimitivaID(MyParser.ExpresionPrimitivaIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expresionPrimitivaID}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpresionPrimitivaID(MyParser.ExpresionPrimitivaIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expresionPrimitivaCHAR}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpresionPrimitivaCHAR(MyParser.ExpresionPrimitivaCHARContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expresionPrimitivaCHAR}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpresionPrimitivaCHAR(MyParser.ExpresionPrimitivaCHARContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expresionPrimitivaDER_EX_IZQ}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpresionPrimitivaDER_EX_IZQ(MyParser.ExpresionPrimitivaDER_EX_IZQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expresionPrimitivaDER_EX_IZQ}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpresionPrimitivaDER_EX_IZQ(MyParser.ExpresionPrimitivaDER_EX_IZQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expresionPrimitivaLISTAEXPRESION}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpresionPrimitivaLISTAEXPRESION(MyParser.ExpresionPrimitivaLISTAEXPRESIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expresionPrimitivaLISTAEXPRESION}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpresionPrimitivaLISTAEXPRESION(MyParser.ExpresionPrimitivaLISTAEXPRESIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expresionPrimitivaLEN_PIZQ_EX_PDER}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpresionPrimitivaLEN_PIZQ_EX_PDER(MyParser.ExpresionPrimitivaLEN_PIZQ_EX_PDERContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expresionPrimitivaLEN_PIZQ_EX_PDER}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpresionPrimitivaLEN_PIZQ_EX_PDER(MyParser.ExpresionPrimitivaLEN_PIZQ_EX_PDERContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expresionPrimitivaFunctionCallExpression}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterExpresionPrimitivaFunctionCallExpression(MyParser.ExpresionPrimitivaFunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expresionPrimitivaFunctionCallExpression}
	 * labeled alternative in {@link MyParser#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitExpresionPrimitivaFunctionCallExpression(MyParser.ExpresionPrimitivaFunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listaExpresionesUltima}
	 * labeled alternative in {@link MyParser#listExpression}.
	 * @param ctx the parse tree
	 */
	void enterListaExpresionesUltima(MyParser.ListaExpresionesUltimaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listaExpresionesUltima}
	 * labeled alternative in {@link MyParser#listExpression}.
	 * @param ctx the parse tree
	 */
	void exitListaExpresionesUltima(MyParser.ListaExpresionesUltimaContext ctx);
}