parser grammar MyParser;
//Se leen los tokens del scanner, programado en este mismo paquete.
options { tokenVocab = MyScanner; }

/*Se definen las reglas de la gramaticas, las cuales definen como se podra escribir en el lenguaje,
*estan fueron dadas por el profesor a cargo del curso de compiladores TEC 2017*/
program:
        statement  (statement)*   #inicioPrograma
        ;

statement:
        defStatement            #declaracionDEF
        | ifStatement           #declaracionIF
        | returnStatement       #declaracionRETURN
        | printStatement        #declaracionPRINT
        | whileStatement        #declaracionWHILE
        | assignStatement       #declaracionASSIGN
        | functionCallStatement #declaracionLLAMADAFUNCION
        ;

defStatement:
        DEF IDENTIFIER PIZQ argList PDER DPUNTOS sequence   #funcion
        ;

argList:
        IDENTIFIER moreArgs #listaParametros
        |                   #listaParametroEOS
        ;

moreArgs:
        (COMA IDENTIFIER)*  #masParametros
        ;

ifStatement:
        IF expression DPUNTOS sequence ELSE DPUNTOS sequence    #if_y_Else
        ;

whileStatement:
        WHILE expression DPUNTOS sequence   #while
        ;

returnStatement:
        RETURN expression NEWLINE           #return
        ;

printStatement:
        PRINT PIZQ expression PDER NEWLINE  #print
        ;

assignStatement:
        IDENTIFIER ASIGN expression NEWLINE #asignacion
        ;

functionCallStatement:
        primitiveExpression PIZQ expressionList PDER NEWLINE    #llamarFuncion
        ;

sequence:
        INDENT moreStatement DEDENT #secuencia
        ;

moreStatement:
        statement (statement)*  #masDeclaraciones
        ;

expression:
        additionExpression comparison   #expresion
        ;

comparison:
        (signosComparacion additionExpression)*    #comparacion
        ;
//Se agrego nueva, para poder ver que viene en orden.
signosComparacion:
        MAQUE
        | MEQUE
        | MEOIQUE
        | MAOIQUE
        | IGUALQUE
        ;


additionExpression:
        multiplicationExpression additionFactor #espresionAderencia
        ;

additionFactor:
        (signosSumaResta multiplicationExpression)*    #factorAderencia
        ;

signosSumaResta:
        SUMA
        | RESTA
        ;

multiplicationExpression:
        elementExpression multiplicationFactor  #expresionMultiplicacion
        ;

multiplicationFactor:
        ( signosOperativos elementExpression)*  #factorMultiplicacion
        ;

//Se agrego nueva, para poder llevar un control de que viene primero.
signosOperativos:
        MUL
        | DIV
        ;
elementExpression:
        primitiveExpression elementAccess   #expresionElemento
        ;

elementAccess:
        (PCIZQ expression PCDER)*   #accesoElemento
        ;

functionCallExpression:
        IDENTIFIER ( expressionList )   #declaracionFuntionCallExpression
        ;

expressionList:
        expression moreExpressions  #listaExpresiones
        |                           #listExpressionEOS
        ;

moreExpressions:
        (COMA expression)*          #masExpresiones
        ;

primitiveExpression:
        INTEGER                     #expresionPrimitivaINT
        | STRING                    #expresionPrimitivaSTRING
        | IDENTIFIER                #expresionPrimitivaID
        | CHAR                      #expresionPrimitivaCHAR
        | PIZQ expression PDER      #expresionPrimitivaDER_EX_IZQ
        | listExpression            #expresionPrimitivaLISTAEXPRESION
        | LEN PIZQ expression PDER  #expresionPrimitivaLEN_PIZQ_EX_PDER
        | functionCallExpression    #expresionPrimitivaFunctionCallExpression
        ;

listExpression:
        PCIZQ expressionList PCDER #listaExpresionesUltima
        ;