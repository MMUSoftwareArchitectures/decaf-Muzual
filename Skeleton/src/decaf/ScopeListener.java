package decaf;

import java.util.Hashtable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;

import decaf.DecafParser.BlockContext;
import decaf.DecafParser.Method_declContext;
import decaf.DecafParser.Strong_arith_opContext;

import java.util.List;
import java.util.Set;
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
		// Information within field_name is not available via the Field_decl Context 
		List<DecafParser.Field_nameContext> fields = ctx.field_name(); 
		Scope scope = scopes.peek();
		
		for (DecafParser.Field_nameContext field : fields) {
			ScopeElement var = new ScopeElement(field.ID().getText(), ctx.type().getText()); 
			/**
			 * Checks existence of variable already to determine if needs to store or error
			 *  @see varInScope 
			 */
			if(varInScope(var.getVarName())) System.err.println("Already exists" + var.getVarName()+ var.getVarType());
		    else scope.put(var.getVarName(), var);
			
			int varArraySize; 
			
			// Bad array size declaration. Checks for an array to not be size 0. 
			if(field.INT_LITERAL().getText().contains("0x")) varArraySize = Integer.decode((field.INT_LITERAL().getText())); 
			else varArraySize = Integer.parseInt((field.INT_LITERAL().getText())); 
			
			if(varArraySize == 0) System.err.println("Error line " + ctx.getStart().getLine() + ": Invalid array size on array named: " + field.ID().getText());
			
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
			List<TerminalNode> variables = ctx.ID();
			
			for(TerminalNode variable : variables) {
				ScopeElement var = new ScopeElement(variable.getText(), ctx.type().getText()); 
				
				if(varInScope(var.getVarName())) {
					System.err.println("Error line " + ctx.getStart().getLine() + ": Cannot create " + var.getVarName() + ", " + var.getVarType() + ". Variable exists elsewhere");
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
				System.err.println("Error line: " + ctx.getStart().getLine() + ". Variable not declared");
			} else { 
				/**
				 * Type checking for the Left Hand Side (LHS) of an expression
				 * 
				 * In the case of assignment (e.g. x=), .getVarType can be called on 
				 * ScopeElement objects to determine the type.
				 * 
				 * @see ScopeElement 
				 */
				ScopeElement temp = scope.get(variable.getText()); 
				String LHS_Type = temp.getVarType();
				
				/** 
				 * Determining the type of the RHS of a statement (expression)
				 * 
				 * Utilises a method recursive method for type checking expressions
				 * 
				 * @see type
				 */
				if(ctx.expr() != null) { 
					DecafParser.ExprContext expr = ctx.expr(0); 
					String RHS_Type = type(expr);
					// Determines if RHS and LHS are equivalent types 
					if(!(LHS_Type.equals(RHS_Type))){
						System.err.println("Error line: " + ctx.getStart().getLine() + ". Type mismatch, cannot perform operation on types " + LHS_Type + " and " + RHS_Type); 
					}
				}
			} 
		}
		
		if(ctx.RETURN() != null) {
			doesReturn = true; 
			if(ctx.getParent().getParent() != null) {
				DecafParser.Method_declContext M_declContext = (Method_declContext) ctx.getParent().getParent();
				if(ctx.expr() != null) {
					DecafParser.ExprContext expr = ctx.expr(0); 
					if(M_declContext.VOID() != null ) {
						System.err.println("Error line: " + ctx.getStart().getLine() + " RETURN cannot be called for method: \""+ M_declContext.ID().getText() + "\". Return type is VOID"); 
					} else { 
						if(!(type(expr).equals(M_declContext.type().getText()))) {
							System.err.println("Error line: " + ctx.getStart().getLine() + ". RETURN must return the same type as method type");
							}
					}
				} 
			}  
		}
	}
	
	/**
	 * Type checking for expressions
	 * 
	 * Takes an expression context and determines types of individual components
	 * recursively.
	 * 
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
			String typeMismatch = ("Error line " + expr.getStart().getLine() + ": Type mismatch, cannot perform operation on variables "
			+ l_expr.getText() + "(" + l_expr_type + ")" + " and " + r_expr.getText() + "(" + r_expr_type + ")"); 
			
			// If contains Strong ops (*/%) - Check both types are INT. 
			if(expr.strong_arith_op() != null) {
				if (!(l_expr_type.equals("int") && r_expr_type.equals("int"))) {
					System.err.println(typeMismatch); 
				}
					return "int"; 
			} 
			// If contains Weak ops (+-) - Check both types are INT. 
			if(expr.weak_arith_op() != null) {
				if (!(l_expr_type.equals("int") && r_expr_type.equals("int"))) {
					System.err.println(typeMismatch); 
				}
					return "int"; 
			}
			if(expr.bin_op() != null) { 
				// If contains Rel Ops (>=<=) - Check both types are INT. 
				if(expr.bin_op().rel_op() != null) {
					if (!(l_expr_type.equals("int") && r_expr_type.equals("int"))) {
						System.err.println(typeMismatch); 
					}
						return "boolean"; 
				}
				// If contains conditional Ops (and, or) - Check both types are BOOLEAN. 
				if(expr.bin_op().cond_op() != null) {
					if (!(l_expr_type.equals("boolean") && r_expr_type.equals("boolean"))) { 
						System.err.println(typeMismatch); 
					}
						return "boolean"; 
				}
				// If contains equality (== !=) - Check both types are the SAME. Can be BOOL or INT... 
				if(expr.bin_op().eq_op() != null) {
					if (!(l_expr_type.equals(r_expr_type))) {
						System.err.println(typeMismatch); 
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
		Scope scope = scopes.peek(); 
		ScopeElement details = scope.get(mContext.method_name().getText());
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
		Scope scope = scopes.peek();
		
		// Checking method TYPE
		if(ctx.type() != null) {
			ScopeElement method = new ScopeElement(ctx.ID().getText(), ctx.type().getText()); 
			scope.put(method.getVarName(), method); 
		} else {
			doesReturn = true; 
			ScopeElement method = new ScopeElement(ctx.ID().getText(), ctx.VOID().getText()); 
			scope.put(method.getVarName(), method); 
		}
		
		DecafParser.Method_paramsContext parameterCollection = null;
		if(ctx.method_params() != null) {
			parameterCollection = ctx.method_params(); 
			List<TerminalNode> params = parameterCollection.ID(); 
		
		for(int i = 0; i < params.size(); i++) { 
			ScopeElement var = new ScopeElement(parameterCollection.ID().get(i).getText(), parameterCollection.type().get(i).getText());
			ScopeElement currentMethod = scope.get(ctx.ID().getText());
			//currentMethod.setParams(var);
			scope.put(currentMethod.getVarName(), currentMethod);
		}
		}
		//scopes.push(new Scope(scopes.peek()));
	}
	
	@Override
	public void exitMethod_decl(DecafParser.Method_declContext ctx) {
		//scopes.pop(); 
		if(doesReturn == false) System.err.println("Error line: " + ctx.getStop().getLine() +". Method name: \"" + ctx.ID().getText() +  "\" must have a return statement"); 
	}
	
	/*
	@Override
	public void enterMethod_call(DecafParser.Method_callContext ctx) {
		Scope scope = scopes.peek(); 
		
		String methodName = null; 
		if(ctx.method_name() != null) {
			methodName = ctx.method_name().getText();
			System.err.println(methodName);
		}
	}
	*/
	
	@Override
	public void enterProgram(DecafParser.ProgramContext ctx) {
		//scopes.push(new Scope(scopes.peek()));
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
		if(foundMain == false) System.err.println("Error line: " + (ctx.getStop().getLine() + " No Main Method")); 
	}
	
	/*@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		super.enterEveryRule(ctx);
		System.err.println("entering new rule!");
		/*Scope scope = scopes.peek();
		Set<String> keys = scope.keySet(); 
		for(String key: keys){
			System.out.println(key); 
		}
	}
*/ 
	
	/* 
	@Override
	public void enterExpr(DecafParser.ExprContext ctx) {
		Scope scope = scopes.peek(); 
		// if the expression is simply a location, check that it has been declared
		if (ctx.location() != null) {
			if(!(varInScope(ctx.location().ID().getText()))) System.err.println("Error line " + ctx.getStart().getLine() + ": Variable not declared: " + ctx.literal().getText());
		}
		
	}
	*/ 

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
		String scopeName; 
		
		public Scope(Scope parent) {
			this.parent = parent;
			this.scopeName = scopeName;
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