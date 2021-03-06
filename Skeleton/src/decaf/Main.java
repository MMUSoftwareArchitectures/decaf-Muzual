/**
 *  This is the main class for the compiler. It uses the command line interface (CLI) tools found in java6G6Z1010.tools.CLI.
 */
package decaf;

import java.io.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import java6G6Z1010.tools.CLI.*;

/**
 * @author Emma Norling (based on code from MIT OpenCourseWare http://ocw.mit.edu
 * for the subject 6.035 Computer Language Engineering, Spring 2010)
 *
 *	Extended by Miles Schofield 
 */
public class Main {

	/**
	 * @param args - command line arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            CLI.parse (args, new String[0]);
            
            InputStream inputStream = args.length == 0 ?
                    System.in : new java.io.FileInputStream(CLI.infile);
            ANTLRInputStream antlrIOS = new ANTLRInputStream(inputStream);

            // Allows for checking assignment of lexer tokens 
            if (CLI.target == CLI.SCAN || CLI.target == CLI.DEFAULT)
            {
                DecafLexer lexer = new DecafLexer(antlrIOS);
                Token token;
                boolean done = false;
                while (!done)
                {
                    try
                    {
                        for (token=lexer.nextToken();
                            token.getType()!=Token.EOF; token=lexer.nextToken())
                        {
                            String type = "";
                            String text = token.getText();

        
                            switch (token.getType())
                            {
                            case DecafLexer.ID:
                                type = " IDENTIFIER";
                                break;
                            case DecafLexer.CHAR_LITERAL: 
                            	type = " CHAR_LITERAL";
                            	break;
                            case DecafLexer.INT_LITERAL:
                            	type = " INT_LITERAL";
                            	break;
                            case DecafLexer.BOOL_LITERAL:
                            	type = " BOOL_LITERAL";
                            	break;
                            case DecafLexer.STRING_LITERAL:
                            	type = " STRING_LITERAL";
                            	break;
                            }
                            // Return each token found to the user on a new line 
                            System.out.println (token.getLine() + type + " " + text);
                        }
                        done = true;
                    } catch(Exception e) {
                        // print the error:
                        System.out.println(CLI.infile+" "+e);
                    }
                }
            }
            // Allows for output of a parse tree 
            else if (CLI.target == CLI.PARSE)
            {
                DecafLexer lexer = new DecafLexer(antlrIOS);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                DecafParser parser = new DecafParser (tokens);
                ParseTree tree = parser.program();
              //  if (CLI.debug) {
                    TreePrinterListener listener = new TreePrinterListener(parser);
	                ParseTreeWalker.DEFAULT.walk(listener, tree);
	                String formatted = listener.toString();
	                System.out.println(formatted);
              //  }
            }
            // Allows for semantic checking 
             else if (CLI.target == CLI.INTER)
             {
                 DecafLexer lexer = new DecafLexer(antlrIOS);
                 CommonTokenStream tokens = new CommonTokenStream(lexer);
                 DecafParser parser = new DecafParser (tokens);
                 ScopeListener listener = new ScopeListener();
                 ParseTree tree = parser.program();
                 ParseTreeWalker.DEFAULT.walk(listener, tree);
                 if (CLI.debug) {
    	             
                 }
            }
            
        } catch(Exception e) {
            // print the error:
            System.out.println(CLI.infile+" "+e);
        }
    }
}
