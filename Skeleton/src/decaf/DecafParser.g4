/*
 * A skeleton for your parser, provided by Emma Norling.
 * Extended by Miles Schofield
 * 
 *
 * The parser holds the grammar rules for the compiler utilising the tokens
 * created by the Lexer component 
 *
 */
parser grammar DecafParser;
options { tokenVocab = DecafLexer; }

// Rule to show that a program is defined by class, ID, then any amount of field or method declarations
// within curly braces. The program is ended by the END OF FILE which is automatically provided by 
// ANTLR and does not exist in the Lexer. 

program: CLASS ID LCURLY (field_decl)* (method_decl)* RCURLY EOF;

field_decl: type field_name(COMMA field_name)* SEMICOLON ;
field_name: (ID|ID LSQRBRK INT_LITERAL RSQRBRK);

method_decl: (type | VOID) ID LPAREN ((type ID)(COMMA type ID)*)? RPAREN  block;

block: LCURLY var_decl* statement*  RCURLY;

var_decl: type ID(COMMA ID)* SEMICOLON;

type: (INT | BOOLEAN);

statement: location assign_op expr SEMICOLON
		| method_call SEMICOLON
		| IF LPAREN expr RPAREN block (ELSE block)?
		| FOR ID ASSIGNOPERATOR expr COMMA expr block
		| RETURN (expr)? SEMICOLON
		| BREAK SEMICOLON
		| CONTINUE SEMICOLON
		| block;


assign_op: ASSIGNOPERATOR
		| ARITHPLUS ASSIGNOPERATOR
		| ARITHMINUS ASSIGNOPERATOR;
		
method_call: method_name LPAREN (expr(COMMA expr)*)? RPAREN
		| CALLOUT LPAREN STRING_LITERAL (COMMA callout_arg(COMMA callout_arg)*)? RPAREN;
		
method_name: ID;
location: ID
		| ID LSQRBRK expr RSQRBRK;

expr: location
		| method_call
		| literal
		| ARITHMINUS expr
		| EXCLMRK expr 
		| expr bin_op expr
		| LPAREN expr RPAREN;

callout_arg: (expr | STRING_LITERAL);

bin_op: (arith_op | rel_op | eq_op | cond_op);

arith_op: (ARITHMULT | ARITHDIV | ARITHMOD | ARITHPLUS | ARITHMINUS);

rel_op: (GRTTHAN | LESTHAN | GRTEQUAL | LESEQUAL); 

eq_op: (EQUALOP | NOTEQUAL);

cond_op: (AND | OR); 

literal: (INT_LITERAL | CHAR_LITERAL | BOOL_LITERAL); 