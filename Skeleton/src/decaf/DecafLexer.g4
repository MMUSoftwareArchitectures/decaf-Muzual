/*
 * Skeleton code for your Lexer, provided by Emma Norling
 *
 * Please note that this code is far from complete.
 * It needs to be extended and the documentation updated to reflect your changes.
 *
 */
lexer grammar DecafLexer;

// This rule matches one of the keywords for Decaf - what others do you need?
CLASS : 'class';

// These two rules deal with characters that have special meaning in Decaf - again, what others?
LCURLY : '{';
RCURLY : '}';

// This says an identifier is a sequence of one or more alphabetic characters
// or beginning with an underscore. can also contain digits. 
// Decaf is a little more sophisticated than this.
ID : 
  ('a'..'z' | 'A'..'Z' | '_' ) ('a'..'z' | 'A'..'Z' | '_' | '0' .. '9')*;

// This rule simply ignores (skips) any space, tab or newline characters
WS_ : (' ' | '\t' | '\n' )+ -> skip;

// And this rule ignores comments (everything from a '//' to the end of the line)
SL_COMMENT : '//' (~'\n')* '\n' -> skip;

// These two rules completely describe characters and strings, and make use of the ESC and NOTESC fragments described below
// This rule says a character is contained within single quotes, and is a single instance of either an ESC, or any
// character other than a single quote, a single backslash, a single double quote, plus the 2-character sequences 
// of \", \', \\, \t and \n 
CHAR : '\'' (ESC|NOTESC|~'\'') '\'';

// This rule says a string is contained within double quotes, and is one or more instances of either an ESC, a NOTESC
// character or any other than a double quote.
STRING : '"' (ESC|~'"'|NOTESC)+ '"';

// String Literals are composed of <char>s enclosed in double quotes
STRINGLITERAL : '"' (ESC|NOTESC)+ '"';

// Character literals are composed of a <char> in single quotes
CHARLITERAL : '\'' (ESC|NOTESC) '\'';

// A rule that is marked as a fragment will NOT have a token created for it. So anything matching the rules above
// will create a token in the output, but something matching the ESC rule below will only be used locally in the scope
// of this file. Any rule that should not generate an output token should be preceded by the fragment keyword.

// ESC matches either a pair of characters representing a newline ('\' and 'n') or a pair of characters representing
// a double quote ('\' and '"'). HINT: there are many other characters that should be escaped - think of how you need
// to write them in strings in languages like Java.
fragment
ESC :  '\\' ('n'|'"');

// NOTESC matches single quotes, double quotes, backslash, double backslashes, as well
// the escape character for two character sequences such as newline, new tab and comment
fragment
NOTESC : ~'\''|~'"'|~'\'|~'\"'|~'\\''|~'\\\'|~'\t'|~'\n';
