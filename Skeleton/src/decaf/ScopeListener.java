/**
 * Semantic Checking for a Compiler
 * 
 * Contains the semantic checks specified in the Decaf Language Reference 
 * to ensure correct semantic structure of code given 
 * (Norling, 2017. Decaf Language Reference. Available on Moodle. Last accessed: 30/03/2017)
 * 
 * @author Miles Schofield
 */
package decaf;

import java.util.Hashtable;
import org.antlr.v4.runtime.tree.*;
import decaf.DecafParser.Method_declContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ScopeListener extends DecafParserBaseListener {

	/** 
	 * The stack used to store variables and parameters in 
	 * a particular scope.
	 */
	private Stack<Scope> scopes;
	/**
	 * Boolean to determine if a MAIN method is found within Program. 
	 * Set to True once a main is discovered. 
	 */
	private boolean foundMain = false;
	/**
	 * Boolean to determine if a method returns 
	 * Set to true once a method has a return statement 
	 */
	private boolean doesReturn; 

	public ScopeListener() {
		scopes = new Stack<Scope>();
		scopes.push(new Scope(null));
	}

	/**
	 * Code for entering the Field_Decl parse rule
	 * 
	 * Stores any IDs that are discovered into 
	 * scope stack of variables
	 * 
	 * Checks IDs are not duplicates
	 * 
	 * @param ctx Context for all information given in the field_decl parse rule
	 */
	@Override
	public void enterField_decl(DecafParser.Field_declContext ctx) {
		// The use of DecafParser.Field_nameContext is required due to the 
		// separation of Field_name and Field_decl in the DecafParser, lines 19 and 20 respectively
		// Information within field_name is not available via the Field_declContext parameter
		List<DecafParser.Field_nameContext> fields = ctx.field_name(); 
		Scope scope = scopes.peek();

		for (DecafParser.Field_nameContext field : fields) {
			ScopeElement var = new ScopeElement(field.ID().getText(), ctx.type().getText()); 
			/**
			 * Checks existence of variable already to determine if needs to store or error
			 * Example of handling semantic Rule #1 
			 * 
			 *  @see varInScope 
			 */
			if(varInScope(var.getVarName())) System.err.println("Error line: " + ctx.getStart().getLine() + ". Variable already exists" + var.getVarName() + "(" +  var.getVarType() + ")");
			else scope.put(var.getVarName(), var);

			int varArraySize; 

			// Bad array size declaration. Checks for an array to be greater than size 0 (non-existant, or minus sizes are not allowed) 
			if(field.INT_LITERAL() != null) {
				if(field.INT_LITERAL().getText().contains("0x")) varArraySize = Integer.decode((field.INT_LITERAL().getText())); 
				else varArraySize = Integer.parseInt((field.INT_LITERAL().getText())); 

				// example of semantic rule #4. 
				if(varArraySize <= 0) System.err.println("Error line: " + ctx.getStart().getLine() + ". Invalid array size on array named: " + field.ID().getText()); 
				else scope.get(var.getVarName()).setVarType("intArray");
			}
		}
	}
	/**
	 * Entering the Var_decl rule
	 * 
	 * Checking Variable Declarations are not duplicates 
	 * 
	 * @param ctx Context for all information given in the var_decl parse rule
	 */
	@Override
	public void enterVar_decl(DecafParser.Var_declContext ctx) {
		Scope scope = scopes.peek();

		// Iterate the list of IDs that occur in var_decl 
		List<TerminalNode> variables = ctx.ID();
		for(TerminalNode variable : variables) {
			ScopeElement var = new ScopeElement(variable.getText(), ctx.type().getText()); 

			if(varInScope(var.getVarName())) {
				System.err.println("Error line: " + ctx.getStart().getLine() + ". Cannot create " + var.getVarName() + "(" + var.getVarType() + ")" + ". Variable already exists");
			} else scope.put(var.getVarName(), var);
		}
	}

	/**
	 * Entering the Statement rule
	 * 
	 * Checking that variables are declared before use
	 * 
	 * In the case where Statement contains expression, checks for type equivalence 
	 * 
	 * @param ctx Context for all information given in the statement parse rule
	 */
	@Override
	public void enterStatement(DecafParser.StatementContext ctx) {
		Scope scope = scopes.peek();
		// Similarly to field_name, expr's context cannot be seen within StatementContext (ctx) 
		// and requires calling separately. 
		if(ctx.location() != null) {
			TerminalNode variable = ctx.location().ID(); 
			if (!(varInScope(variable.getText()))) {
				// example semantic rule #2
				System.err.println("Error line: " + ctx.getStart().getLine() + ". Variable used and not declared");
			} else {
				// ELSE: Variable has been declared - determine type of LHS, and then type of RHS if exists 
				String LHS_Type = type(ctx.location()); 

				if(ctx.expr() != null) { 
					DecafParser.ExprContext expr = ctx.expr(0); 
					String RHS_Type = type(expr);
					if(!(LHS_Type.equals(RHS_Type))){ // are LHS and RHS the same type? 
						System.err.println("Error line: " + ctx.getStart().getLine() + ". Type mismatch, cannot perform operation on types " + LHS_Type + " and " + RHS_Type); 
					}
					if(ctx.assign_op() != null) {
						if(ctx.assign_op().ARITHPLUS() != null || ctx.assign_op().ARITHMINUS() != null) {
							if(!(LHS_Type.equals("int") && RHS_Type.equals("int"))) {
								System.err.print("Error line: " + ctx.getStart().getLine() + ". Both operands of += and -= are required to be type int"); 
							}
						}
					}
				}
			}
			// Checking type for an array
			if(ctx.location().expr() != null) {
				DecafParser.ExprContext expr = ctx.location().expr(); 
				if(!(type(expr).equals("int"))) System.err.println("Error line: " + ctx.getStart().getLine() + ". Array index must be type int"); 
				if(ctx.assign_op() != null) {
					expr = ctx.expr(0);
					if(type(expr).equals("intArray")) System.err.println("Error line: " + ctx.getStart().getLine() + ". Attempted array nest. Array position can only hold a basic type");
				}
			}
		}
		// Checking return types of methods 
		// example of semantic rule 7 and 8. 
		if(ctx.RETURN() != null) {
			doesReturn = true; 
			if(ctx.getParent().getParent() != null) {
				DecafParser.Method_declContext M_declContext = (Method_declContext) ctx.getParent().getParent();
				if(ctx.expr() != null) {
					DecafParser.ExprContext expr = ctx.expr(0); 
					if(M_declContext.VOID() != null ) {
						System.err.println("Error line: " + ctx.getStart().getLine() + ". RETURN cannot be called for method: \""+ M_declContext.ID().getText() + "\". Return type is VOID"); 
					} else { 
						if(!(type(expr).equals(M_declContext.type().getText()))) {
							System.err.println("Error line: " + ctx.getStart().getLine() + ". RETURN must return the same type as method type");
						}
					}
				} 
			}  
		}  
		// IF statement must have a condition that can evaluate as a boolean 
		if(ctx.IF() != null) {
			if(ctx.expr() != null) {
				DecafParser.ExprContext expr = ctx.expr(0); 
				if(!(type(expr)).equals("boolean")) {
					System.err.println("Error line: " + ctx.getStart().getLine() + ". If statement must have an expression evaluating to true or false (boolean)");
				}
			}
		}
		// Handling FOR loops 
		// Ensures parameters of FOR are ints (therefore countable) 
		if(ctx.FOR() != null) {
			DecafParser.ExprContext expr = ctx.expr(0); 
			DecafParser.ExprContext expr1 = ctx.expr(1); 
			if(!(type(expr)).equals("int") && (type(expr1)).equals("int")) {
				System.err.println("Error line: " + ctx.getStart().getLine() + ". For loop parameters must be type int");
			}
		}
	}

	/**
	 * Type checking for expressions
	 * 
	 * Takes an expression context and determines types of individual components
	 * recursively. Based on Psuedocode from textbook given 
	 * Torben �gidius Mogensen, Basics of Compiler Design. 2010, Pp 136-138. Last Accessed: 30/03/2017 
	 * Utilises other type methods below 
	 * 
	 * @param expr Context for all information given in the expression parse rule
	 * @return type String The type of the expression - Bool or Int 
	 */ 
	public String type(DecafParser.ExprContext expr) {
		DecafParser.ExprContext l_expr = null;
		DecafParser.ExprContext r_expr = null;
		DecafParser.LocationContext location = expr.location();
		DecafParser.LiteralContext literal = expr.literal(); 
		DecafParser.Method_callContext Method_call = expr.method_call(); 

		if (location != null) return type(location);
		if (literal != null) return type(literal);
		if (Method_call != null) return type(Method_call);

		// Anything beyond here involves at least one subexpression
		if (expr.expr().size() == 1) {
			// IF Unary Expression:
			l_expr = expr.expr(0);
			if(l_expr.EXCLMRK() != null) return "boolean"; // Boolean NOT
			else if(l_expr.ARITHMINUS() != null) return "int"; // Unary Minus 
			else return type(l_expr);
		} else { 
			// IF Binary Expression: 
			l_expr = expr.expr(0);
			r_expr = expr.expr(1);

			// Note that all areas return the expected type, even after errors, in order to 
			// allow the compiler to continue, returning as many errors as possible in one pass 

			String l_expr_type = type(l_expr);
			String r_expr_type = type(r_expr); 
			String typeMismatch = ("Error line " + expr.getStart().getLine() + ". Type mismatch, cannot perform operation on variables " + 
					l_expr.getText() + "(" + l_expr_type + ")" + " and " + r_expr.getText() + "(" + r_expr_type + ")"); 

			// If contains Strong ops (*/%) - Check both types are INT. 
			// example of semantic rule 12. 
			if(expr.strong_arith_op() != null) {
				if (!(l_expr_type.equals("int") && r_expr_type.equals("int"))) {
					System.err.println(typeMismatch + ". Must both be int"); 
				}
				return "int"; 
			} 
			// If contains Weak ops (+-) - Check both types are INT. 
			if(expr.weak_arith_op() != null) {
				if (!(l_expr_type.equals("int") && r_expr_type.equals("int"))) {
					System.err.println(typeMismatch + ". Must both be int"); 
				}
				return "int"; 
			}
			if(expr.bin_op() != null) { 
				// If contains Rel Ops (>=<=) - Check both types are INT. 
				if(expr.bin_op().rel_op() != null) {
					if (!(l_expr_type.equals("int") && r_expr_type.equals("int"))) {
						System.err.println(typeMismatch + ". Must both be int"); 
					}
					return "boolean"; 
				}
				// If contains conditional Ops (and, or) - Check both types are BOOLEAN. 
				// examples of semantic rule #14 
				if(expr.bin_op().cond_op() != null) {
					if (!(l_expr_type.equals("boolean") && r_expr_type.equals("boolean"))) { 
						System.err.println(typeMismatch + ". Must both be boolean"); 
					}
					return "boolean"; 
				}
				// If contains equality (== !=) - Check both types are the SAME. Can be BOOL or INT... 
				// example of semantic rule #13. 
				if(expr.bin_op().eq_op() != null) {
					if (!(l_expr_type.equals(r_expr_type))) {
						System.err.println(typeMismatch + ". Must both be same type"); 
					}
					return "boolean"; 
				}
			}
		}
		// Unreachable Code. Null is never handled. 
		return null; 
	}

	/**
	 * Type checking locations
	 * 
	 * Type checking called within the type(expr) method 
	 * if the expr consists of a simple location
	 * 
	 * @param loc Context given by location parse rule 
	 * @return details.getVarType String Type of the location 
	 */
	public String type(DecafParser.LocationContext loc) {
		Scope scope = scopes.peek();
		String varName = loc.ID().getText();
		ScopeElement details = scope.get(varName); 
		// if a "[" is in the location, make the assumption it is an array 
		// if statement responsible for "unpacking" arrays, to their basic types
		// type intArray is therefore equivalent to int in this instance, as checking occurs
		// when determining if an array position holds the correct type for an array
		if(loc.LSQRBRK() != null) {
			if(details.getVarType().equals("intArray")) return("int");
			else return("boolean");
		} 
		return(details.getVarType());
	}
	/**
	 * Type checking literals
	 * 
	 * Type checking called within the type(expr) method 
	 * if the expr consists of a simple literal
	 * 
	 * @param literal Context given by literal parse rule
	 * @return Type String Type of the literal, either int or Boolean 
	 */
	public String type(DecafParser.LiteralContext literal) {
		// Literal consists only of int_literal or bool_literal 
		if(literal.INT_LITERAL() != null) return("int");
		else return("boolean");
	}
	/**
	 * Type checking Method_calls
	 * 
	 * Type checking called within the type(expr) method
	 * if the expr consists of a simple method call 
	 * 
	 * @param mContext Context given by method_call parse rule
	 * @return details.getVarType() String type of method_call 
	 */
	public String type(DecafParser.Method_callContext mContext) {
		// example of semantic rule #6
		if(mContext.CALLOUT() != null) return("int"); 
		Scope scope = scopes.peek();
		// When a method is called: .parent is the method_decl, 
		// .parent.parent is the program contexts (which contain information
		// on every method declared)
		ScopeElement details = scope.parent.parent.get(mContext.method_name().getText());
		return(details.getVarType()); 
	}

	/**
	 * Entering the method_Decl rule
	 * 
	 * Determines if a main method is found by altering
	 * boolean foundMain
	 * 
	 * @see foundMain 
	 * @param ctx Context given by Method_decl parse rule
	 */
	@Override
	public void enterMethod_decl(DecafParser.Method_declContext ctx) {
		if((ctx.ID().getText()).equals("main")) foundMain = true;
		doesReturn = false; 
		Scope scope = scopes.peek();
		if(!(varInScope(ctx.ID().getText()))) { 
			// Checking method TYPE
			if(ctx.type() != null) {
				ScopeElement method = new ScopeElement(ctx.ID().getText(), ctx.type().getText()); 
				scope.put(method.getVarName(), method); 
			} else {
				doesReturn = true; 
				ScopeElement method = new ScopeElement(ctx.ID().getText(), ctx.VOID().getText()); 
				scope.put(method.getVarName(), method); 
			}
			// enter method decl 
			DecafParser.Method_paramsContext parameterCollection = null;
			if(ctx.method_params() != null) {
				parameterCollection = ctx.method_params(); 
				List<TerminalNode> params = parameterCollection.ID(); 
				ScopeElement currentMethod = scope.get(ctx.ID().getText());
				// Store the parameters in a List<ScopeElement> within ScopeElement 
				// so "Main" has .getParams return an empty list. 
				for(int i = 0; i < params.size(); i++) { 
					ScopeElement var = new ScopeElement(parameterCollection.ID().get(i).getText(), parameterCollection.type().get(i).getText());
					currentMethod.setParams(var);
				}
			}
		} else System.err.println("Error line: " + ctx.getStart().getLine() + ". Method name already in use"); 

		scopes.push(new Scope(scopes.peek()));
	}

	@Override
	public void exitMethod_decl(DecafParser.Method_declContext ctx) {
		scopes.pop(); 
		if(doesReturn == false && ctx.type() != null) System.err.println("Error line: " + ctx.getStop().getLine() +". Method name: \"" + ctx.ID().getText() +  "\" must have a return statement"); 
	}

	/**
	 * Entering the method_call rule
	 * 
	 * Ensuring the parameters and typing is correct for
	 * calling a method 
	 * 
	 * @param ctx Context given by method_call parse rule 
	 */
	@Override
	public void enterMethod_call(DecafParser.Method_callContext ctx) {
		// Rules for a CALLOUT are not relevant for standard method calling 
		if(!(ctx.CALLOUT() != null)) { 
			Scope scope = scopes.peek();
			List<ScopeElement> parametersExpected = new ArrayList<ScopeElement>(); 
			ScopeElement currentMethod = scope.get(ctx.method_name().ID().getText()); 
			if(currentMethod == null) {
				System.err.println("Error line: " + ctx.getStart().getLine() + ". Method used and not declared");  
			} else {
				parametersExpected = currentMethod.getParams(); 
				// example of semantic rule #5 
				if(!(parametersExpected.isEmpty())) {
					// paramsExpected holds method_decl's params. methodName.getParams is this list
					// paramsGiven is the Method_call_params given in the call return 
					DecafParser.Method_call_paramsContext paramsGiven = ctx.method_call_params();
					if(!(parametersExpected.size() == paramsGiven.expr().size())) System.err.println("Error line: " + ctx.getStart().getLine() + ". Incorrect number of parameters in method call"); 
					else for(int i = 0; i < paramsGiven.expr().size(); i++) { 
						if(!(parametersExpected.get(i).getVarType().equals(type(paramsGiven.expr(i))))) {
							System.err.println("Error line: " + ctx.getStart().getLine() + ". Parameter types given do not match expected types"); 
						}
					}
				}
			}
		}
	}

	// Blocks can have their own scopes. Push and pop them respectively! 
	@Override
	public void enterBlock(DecafParser.BlockContext ctx) {
		scopes.push(new Scope(scopes.peek()));
	}
	@Override
	public void exitBlock(DecafParser.BlockContext ctx) {
		scopes.pop(); 
	}

	/** 
	 * Exiting the program rule
	 * 
	 * Returns an error informing a main method does not exist
	 * 
	 * @see foundMain 
	 * @param ctx Context given by the program rule
	 */
	@Override
	public void exitProgram(DecafParser.ProgramContext ctx) {
		// example of semantic rule #3 
		if(foundMain == false) System.err.println("Error line: " + (ctx.getStop().getLine() + ". No Main Method")); 
	}

	/** 
	 * Method to determine if variable exists 
	 * 
	 * @see Scope.inScope 
	 * @param varName String the identifier of the variable
	 * @return doesExist Boolean True or false depending on presence of variable 
	 */
	private boolean varInScope(String varName) {
		Scope scope = scopes.peek();
		boolean doesExist = false; 
		if(scope.inScope(varName)) doesExist = true;
		return doesExist; 
	}
}

/**
 * 
 * @author Miles Schofield
 *
 *	Scope class developed with reference to structure provided by Emma Norling
 *	(Norling, 2017. Labs, week 8. Available on Moodle. Last accessed: 18/03/2017)
 */
class Scope extends Hashtable<String, ScopeElement> {
	final Scope parent;

	public Scope(Scope parent) {
		this.parent = parent;
	}

	@Override
	public synchronized ScopeElement get(Object key) {
		// TODO Auto-generated method stub
		ScopeElement tempElement = super.get(key);
		if(tempElement != null) {
			return tempElement;
		} else {
			if (parent == null) {
				return null; 
			} else {
				return parent.get(key);
			}
		}

	}
	@Override
	public synchronized ScopeElement put(String key, ScopeElement value) {
		// TODO Auto-generated method stub
		return super.put(key, value);
	}

	/** 
	 * Method to determine if varName is in Scope
	 * 
	 * Recursively called to check parent scopes if not in local scope 
	 * 
	 * @param varName String variable name to check
	 * @return boolean True if exists, false if not
	 */
	boolean inScope(String varName) {
		if(super.containsKey(varName)){
			return true;
		}
		return parent == null ? false : parent.inScope(varName); 
	}
}