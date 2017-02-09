/*
 * A VERY minimal skeleton for your parser, provided by Emma Norling.
 *
 * Your parser should use the tokens provided by your lexer in rules.
 * Even if your lexer appeared to be working perfectly for stage 1,
 * you might need to adjust some of those rules when you implement
 * your parser.
 *
 * Remember to provide documentation too (including replacing this
 * documentation).
 *
 */
parser grammar DecafParser;
options { tokenVocab = DecafLexer; }

// This rule says that a program consists of the tokens CLASS ID LCURLY RCURLY EOF nothing more nothing less,
// in exactly that order. However obviously something (quite a lot of something) needs to go between the curly
// brackets. You need to write the rules (based on the provided grammar) to capture this.
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
		| expr bin_op expr
		| ARITHMINUS expr
		| EXCLMRK expr 
		| LPAREN expr RPAREN;

callout_arg: (expr | STRING_LITERAL);

bin_op: (arith_op | rel_op | eq_op | cond_op);

arith_op: (ARITHPLUS | ARITHMINUS | ARITHMULT | ARITHDIV | ARITHMOD);

rel_op: (GRTTHAN | LESTHAN | GRTEQUAL | LESEQUAL); 

eq_op: (EQUALOP | NOTEQUAL);

cond_op: (AND | OR); 

literal: (INT_LITERAL | CHAR_LITERAL | BOOL_LITERAL); 