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


// Note the EOF token is not provided in Lexer due to being
// included as part of ANTLR
program: CLASS ID LCURLY (field_decl)* (method_decl)* RCURLY EOF;

// field_name is split from field_decl to improve readability 
field_decl: type field_name(COMMA field_name)* SEMICOLON ;
field_name: (ID|ID LSQRBRK INT_LITERAL RSQRBRK);

method_decl: (type | VOID) ID LPAREN method_params? RPAREN  block;
method_params: ((type ID)(COMMA type ID)*);

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

// It is key to separate strong and weak operators
// due to order of operations when parsing 
// */% have higher priority than +- according to BIDMAS
expr: location
		| method_call
		| literal
		| ARITHMINUS expr
		| EXCLMRK expr 
		| expr strong_arith_op expr
		| expr weak_arith_op expr 
		| expr bin_op expr
		| LPAREN expr RPAREN;

callout_arg: (expr | STRING_LITERAL);


// The following rules deal with grouping tokens
// for ease of use in rules
bin_op: (rel_op | eq_op | cond_op);

// "Strong", or higher priority mathematical operators
strong_arith_op: (ARITHMULT | ARITHDIV | ARITHMOD);

// "Weak", or lower priority mathematical operators 
weak_arith_op: (ARITHPLUS | ARITHMINUS);

rel_op: (GRTTHAN | LESTHAN | GRTEQUAL | LESEQUAL); 

eq_op: (EQUALOP | NOTEQUAL);

cond_op: (AND | OR); 

literal: (INT_LITERAL | CHAR_LITERAL | BOOL_LITERAL); 