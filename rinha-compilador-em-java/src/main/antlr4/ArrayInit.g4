/** Grammars always start with a grammar header. This grammar is called
 *  ArrayInit and must match the filename: ArrayInit.g4
 */
grammar ArrayInit;

/** A rule called init that matches comma-separated values between {...}. */
init  : '{' value (',' value)* '}' ;  // must match at least one value

/** A value can be either a nested array/struct or a simple integer (INT) */
value : init
      | INT
      ;

// parser rules start with lowercase letters, lexer rules with uppercase
INT :   [0-9]+ ;             // Define token INT as one or more digits
WS  :   [ \t\r\n]+ -> skip ; // Define whitespace rule, toss it out

expression : '(' expression ')' #parenthesisExp
	| expression (ASTERISK|SLASH) expression #mulDivExp
	| expression (PLUS|MINUS) expression #addSubExp
	| <assoc=right> expression '^' expression #powerExp
	| NAME '(' expression ')' #functionExp
	| NUMBER #numericAtomExp
	| ID #idAtomExp
	;
	
fragment LETTER : [a-zA-Z] ;
fragment DIGIT : [0-9] ;

ASTERISK : '*' ;
SLASH : '/' ;
PLUS : '+' ;
MINUS : '-' ;

ID : LETTER DIGIT ;
NAME : LETTER+ ;
NUMBER : DIGIT+ ('.' DIGIT+)? ;
