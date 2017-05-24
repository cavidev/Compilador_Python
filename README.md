# Compilador_Python
El proyecto consiste en crear un Analizador Sintáctico para el lenguaje Mini_Python cuya sintaxis se detalla en el archivo adjunto. Este lenguaje es un subconjunto de lenguaje al estilo Python por lo que NO debe entenderse que el funcionamiento deba ser el mismo tanto en esta como en las etapas posteriores. El objetivo en esta etapa es realizar la fase de análisis sintáctico del compilador para dicho lenguaje en donde se espera concluir con las subfases de “scanning” “parsing” y AST. Para el desarrollo de esta etapa será necesario la utilización de la herramientas ANTLR4.

Grammar for mini-Python:
1.	program  		: statement (statement)*
2.	statement  	: defStatement | ifStatement | returnStatement | printStatement | whileStatement | assignStatement | functionCallStatement                     
3.	defStatement	: def identifier ( argList ) : sequence     
4.	argList          	: identifier moreArgs  | ε   
5.	moreArgs               : (, identifier)*                                
6.	ifStatement            : if expression : sequence else : sequence 
7.	whileStatement      	: while expression : sequence                   
8.	returnStatement     	: return expression NEWLINE                           
9.	printStatement       	: print ( expression ) NEWLINE                    
10.	assignStatement     : identifier = expression NEWLINE                   
11.	functionCallStatement    : primitiveExpression ( expressionList ) NEWLINE          
12.	sequence             	: NEWLINE INDENT moreStatement DEDENT            
13.	moreStatement     	: statement (statement)*                              
14.	expression             	: additionExpression comparison                        
15.	comparison            	: ((<|>|<=|>=|==) additionExpression)* 
16.	additionExpression	: multiplicationExpression additionFactor                
17.	additionFactor       	: ((+|-) multiplicationExpression)*                
18.	multiplicationExpression : elementExpression multiplicationFactor                 
19.	multiplicationFactor	: ((*|/) elementExpression)*                        
20.	elementExpression 	: primitiveExpression elementAccess                        
21.	elementAccess       	: ([ expression ])*                       
22.	functionCallExpression   : identifier ( expressionList )                       
23.	expressionList       	: expression moreExpressions | ε
24.	moreExpressions    	: (, expression)*                                
25.	primitiveExpression	: Integer | String | identifier | Char | ( expression ) | listExpression | len ( expression ) | functionCallExpression                              
26.	listExpression        	: [ expressionList ]

