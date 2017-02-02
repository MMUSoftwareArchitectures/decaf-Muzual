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
program: CLASS id LCURLY (field_decl)* (method_decl)* RCURLY EOF;

field_decl: type field_name(COMMA field_name)* SEMICOLON ;
field_name: (id|id LSQRBRK INTLIT RSQRBRK);

method_decl: (type | VOID) id LPAREN ((type id)(COMMA type id)*)? RPAREN  block;

block: LCURLY var_decl* statement*  RCURLY;

var_decl: type id(COMMA id)* SEMICOLON;

type: (INT | BOOLEAN);

statement: location assign_op expr
		| method_call
		| IF LPAREN expr RPAREN block (ELSE block)?
		| FOR id ASSIGNOPERATOR expr COMMA expr block
		| RETURN (expr)? SEMICOLON
		| BREAK SEMICOLON
		| CONTINUE SEMICOLON
		| block;


assign_op: ASSIGNOPERATOR
		| ARITHPLUS ASSIGNOPERATOR
		| ARITHMINUS ASSIGNOPERATOR;
		
method_call: method_name LPAREN (expr(COMMA expr)*)? RPAREN
		| CALLOUT LPAREN STRINGLIT (callout_arg(COMMA callout_arg)*)? RPAREN;
		
method_name: id;
location: id
		| id LSQRBRK expr RSQRBRK;

expr: location
		| method_call
		| literal
		| expr bin_op expr
		| ARITHMINUS expr
		| EXCLMRK expr 
		| LPAREN expr RPAREN;

callout_arg: (expr | STRINGLIT);
//
bin_op: (arith_op | rel_op | eq_op | cond_op);

arith_op: (ARITHPLUS | ARITHMINUS | ARITHMULT | ARITHDIV | ARITHMOD);

rel_op: (GRTTHAN | LESTHAN | GRTEQUAL | LESEQUAL); 

eq_op: (EQUALOP | NOTEQUAL);

cond_op: (AND | OR); 

literal: (int_literal | char_literal | boolean_literal); 

id: (ALPHA)(alpha_num)*;

alpha_num: (ALPHA|digit);

digit: '0'..'9';

hex_digit: (digit|ALPHA|ALPHA);

int_literal: (decimal_literal | hex_literal);

decimal_literal: (digit)(digit)*;

hex_literal: HEX; 

boolean_literal: (TRUE | FALSE); 

char_literal: CHARLIT;
string_literal: STRINGLIT; 
