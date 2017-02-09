/*
 * Skeleton code for your Lexer, provided by Emma Norling, 
 * 		extended by Miles Schofield
 *
 */
lexer grammar DecafLexer;

// These rules match
// all of the reserved words for Decaf (case sensitive) 
CLASS : 'class';
BOOLEAN : 'boolean';
BREAK : 'break';
CALLOUT : 'callout'; 
CONTINUE : 'continue';
ELSE : 'else';
FALSE : 'false';
FOR : 'for';
IF : 'if';
RETURN : 'return';
TRUE : 'true';
VOID : 'void'; 
INT : 'int';

// These two rules deal with individual characters that have special meaning in Decaf
LCURLY : '{';
RCURLY : '}';
SEMICOLON : ';';
LSQRBRK : '[';
RSQRBRK : ']';
COMMA : ',';
LPAREN : '(';
RPAREN : ')';
UNDERSCORE: '_';
ASSIGNOPERATOR : '=';
ARITHPLUS: '+';
ARITHMINUS: '-'; 
EXCLMRK: '!'; 
ARITHMOD: '%';
ARITHDIV: '/';
ARITHMULT: '*'; 
GRTTHAN: '>';
LESTHAN: '<';
GRTEQUAL: '>=';
LESEQUAL: '<='; 
EQUALOP: '=='; 
NOTEQUAL: '!='; 
AND: '&&';
OR: '||'; 

// This rule shows that ID must start with a letter or underscore, then
// any combination of digits, letters or underscores. 
ID : 
  (ALPHA|'_') (ALPHA_NUM|'_')*;


// This rule simply ignores (skips) any space, tab or newline characters, as well as comments
WS_ : (' ' | '\t' | '\n' | SL_COMMENT | '\f' )+ -> skip;


// This rule ignores comments (everything from a '//' to the end of the line)
SL_COMMENT : '//' (~'\n')* '\n' -> skip;

// These two rules completely describe characters and strings, and make use of the ESC and NOTESC fragments described below
// This rule says a character is contained within single quotes, and is a single instance of either an ESC, or any
// character other than a single quote, a single backslash, a single double quote, plus the 2-character sequences 
// of \", \', \\, \t and \n 
// Character literals are composed of a <char> in single quotes
CHAR_LITERAL : '\'' (ESC|NOTESC) '\'';

// This rule says a string is contained within double quotes, and is one or more instances of either an ESC, a NOTESC
// character or any other than a double quote.
// String Literals are composed of <char>s enclosed in double quotes
STRING_LITERAL : '"' (ESC|NOTESC)* '"';

// this rule says an integer is either one or no negative signs followed by one or more integer 
INT_LITERAL : '-'?(DECIMAL_LITERAL|HEX_LITERAL);

// this rule says a hex number is an integer from 0-9 followed by either case 
// of a-f
fragment
HEX_LITERAL : '0x' HEX_DIGIT+; 

// A rule that is marked as a fragment will NOT have a token created for it. So anything matching the rules above
// will create a token in the output, but something matching the ESC rule below will only be used locally in the scope
// of this file. Any rule that should not generate an output token should be preceded by the fragment keyword.

// ESC matches either a pair of characters representing a newline ('\' and 'n') or a pair of characters representing
// a double quote ('\' and '"'). HINT: there are many other characters that should be escaped - think of how you need
// to write them in strings in languages like Java.
fragment
ESC :  '\\' ('"'|'n'|'t'|'\''|'\\');

// NOTESC matches single quotes, double quotes, backslash, double backslashes, as well
// the escape character for two character sequences such as newline, new tab and comment
fragment
NOTESC : ~('"'|'\n'|'\t'|'\''|'\\');

fragment
ALPHA_NUM : (ALPHA | DIGIT) ;

fragment 
ALPHA : ([a-z]|[A-Z]); 

fragment 
DIGIT : [0-9];

fragment 
HEX_DIGIT : (DIGIT|[a-f]|[A-F]);

fragment 
DECIMAL_LITERAL : DIGIT+ ;

BOOL_LITERAL : (TRUE | FALSE) ;

/*
fragment 
CHAR_LITERAL : '\' CHAR '\'; 

fragment 
STRING_LITERAL : '"' CHAR* '"' ;
*/