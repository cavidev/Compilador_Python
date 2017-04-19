lexer grammar MyScanner;

//Tokens para las identaciones.
tokens { INDENT, DEDENT }

@lexer::header {
  import denter.DenterHelper;
}

//Necesario para meter los tokens.
@lexer::members {
  private final DenterHelper denter = DenterHelper.builder()
    .nl(NEWLINE)
    .indent(MyParser.INDENT)
    .dedent(MyParser.DEDENT)
    .pullToken(MyScanner.super::nextToken);

  @Override
  public Token nextToken() {
    return denter.nextToken();
  }
}

//Tokens para las palabras reservadas
DEF
	:	'def'
	;
IF
    :	'if'
    ;
ELSE
    :	'else'
    ;
WHILE
    :	'while'
    ;
RETURN
    :	'return'
    ;
PRINT
    :	'print'
    ;
LEN
    :	'len'
    ;

//Token logicos, no se muestran en la gramatica.
AND
    :	'and'
    ;
OR
    :	'or'
    ;

//Tokens para simbolos
PIZQ	:	'(' ;
PDER	:	')' ;
DPUNTOS :   ':' ;
COMA	:	',' ;
ASIGN	:	'=' ;
MAQUE   :   '>' ;
MEQUE   :   '<' ;
MAOIQUE :  '>=' ;
MEOIQUE :  '<=' ;
IGUALQUE:   '==';
SUMA	:	'+' ;
RESTA   :   '-' ;
MUL		:	'*' ;
DIV		:	'/' ;
PCIZQ	:	'[' ;
PCDER	:	']' ;

//Tokens para expresiones regulares
INTEGER
	:	'0' ('.' ('0'..'9')* )?
	| '1'..'9' ('0'..'9')* ('.' ('0'..'9')* )?
	;

IDENTIFIER
	:	CharInicial CharContenido*
	;

STRING : '"' (~'"')*? '"' ;

CHAR   : '\'' (CharInicial) '\'';

//Aquí por ejemplo, CharContenido se crea no para que se reconozca como tal sino para ser parte de la regla anterior
fragment
CharContenido
   : CharInicial
   | '0'..'9'
   | '_'
   | '\u00B7'
   | '\u0300'..'\u036F'
   | '\u203F'..'\u2040'
   ;
fragment
CharInicial
   : '_' | 'A'..'Z' | 'a'..'z'
   | '\u00C0'..'\u00D6'
   | '\u00D8'..'\u00F6'
   | '\u00F8'..'\u02FF'
   | '\u0370'..'\u037D'
   | '\u037F'..'\u1FFF'
   | '\u200C'..'\u200D'
   | '\u2070'..'\u218F'
   | '\u2C00'..'\u2FEF'
   | '\u3001'..'\uD7FF'
   | '\uF900'..'\uFDCF'
   | '\uFDF0'..'\uFFFD'
   ;

//Token para los enter.
//NEWLINE : ('\r\n' | '\r'?'\n'(' '|'\t')*);
NEWLINE :
        '\r'?'\n' (' '|'\t')*
        ;

//El punto (.) significa cualquier caracter (*) cero o más veces, (?) opcional epsigon, en parser
//Comentario en linea, estilo PYTHON.
LINE_COMMENT:   '#'.*?'\r\n'-> skip ;

//Comentarios en bloque, tipo Python
SPECIAL_COMMENT:
        '"""'.*?'"""'->skip
        ;


//Si lee cualquiera de las de abajo no lo reconoce.
WS:   [ \n]+ -> skip ; //El espacio en blanco es equivalente a ' '+...