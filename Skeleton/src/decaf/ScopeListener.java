package decaf;

import java.util.Hashtable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;

import decaf.DecafParser.Strong_arith_opContext;

import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ScopeListener extends DecafParserBaseListener {

	private Stack<Scope> scopes;
	private boolean foundMain = false;
	
	public ScopeListener() {
		scopes = new Stack<Scope>();
		scopes.push(new Scope(null));
	}
	
	// make the value an object in the key:value set. the obj can store
	// variable values. type, size of array, etc 
	@Override
	public void enterField_decl(DecafParser.Field_declContext ctx) {
		
		List<DecafParser.Field_nameContext> fields = ctx.field_name(); 
		Scope scope = scopes.peek();
		for (DecafParser.Field_nameContext field : fields) {
			ScopeElement var = new ScopeElement(field.ID().getText(), ctx.type().getText()); 
			if(varInScope(var.getVarName())) {
				System.err.println("Already exists" + var.getVarName()+ var.getVarType());
			} else {	
				scope.put(var.getVarName(), var);
			}
			int varArraySize = Integer.parseInt((field.INT_LITERAL().getText())); 
			if(varArraySize == 0) System.err.println("Error line " + ctx.getStart().getLine() + ": Invalid array size on array named: " + field.ID().getText());
			
		}
	}
	
	@Override
	public void enterVar_decl(DecafParser.Var_declContext ctx) {
		Scope scope = scopes.peek();
			List<TerminalNode> variables = ctx.ID();
			for(TerminalNode variable : variables) {
				ScopeElement var = new ScopeElement(variable.getText(), ctx.type().getText()); 
			if(varInScope(var.getVarName())) {
				System.err.println("Error line " + ctx.getStart().getLine() + ": Already exists: " + var.getVarName() + ", " + var.getVarType());
			} else {	
				scope.put(var.getVarName(), var);
			}
			}
	}
	
	@Override
	public void enterStatement(DecafParser.StatementContext ctx) {
		Scope scope = scopes.peek();
		DecafParser.ExprContext expr = ctx.expr(0); 
		// if assignment statement, check that LHS has been declared
		TerminalNode variable = ctx.location().ID(); 
		if (!(varInScope(variable.getText()))) System.err.println("Error line " + ctx.getStart().getLine() + ": Variable not declared");
		
		ScopeElement temp = scope.get(variable.getText()); 
		String LHS_Type = temp.getVarType();
		
		// Now check type(RHS) = type (LHS)
		//String RHS_Type = type(expr);
		
		/*if(!(LHS_Type.equals("int") && RHS_Type.equals("int"))){
			System.err.println("Error line " + ctx.getStart().getLine() + ": Type mismatch, cannot perform operation on types " + LHS_Type + " and " + RHS_Type); 
		}*/ 
	}
	
	/*
	public String type(DecafParser.ExprContext expr) {
		// straightforward location
		
		
		if (expr.location() != null) return type(expr.location());
		if (expr.literal() != null) return type (expr.literal());
		if (expr.method_call() != null) return type (expr.method_call());
		
		// anything beyond here involves at least one subexpression

		DecafParser.ExprContext l_expr = expr.expr(0);
		DecafParser.ExprContext r_expr = expr.expr(1);
		if (r_expr == null) {
			// NOT
				return "boolean";
			// MINUS
				return "int";
			// ( expr )
				return type (l_expr);
		}
		// must have binary expression
			// arith op
				if (type (l_expr) == "int" && type (r_expr) == "int") return "int";
			// boolean op
			// relational op
			// eq op

	}
	*/
	public String type(DecafParser.LocationContext loc) {
		
		Scope scope = scopes.peek(); 
		ScopeElement temp = scope.get(loc.ID()); 
		System.out.println(temp.getVarType());
		
		return(temp.getVarType());
	}
	public String type(DecafParser.LiteralContext literal) {
		
		if(literal.INT_LITERAL() != null) {
			return("int");
		} else {
			return("string");
		}
	}
	public String type(DecafParser.Method_callContext mContext) {
		
		Scope scope = scopes.peek(); 
		ScopeElement temp = scope.get(mContext.method_name().getText());
		return(temp.getVarType()); 
	}
	
	@Override
	public void enterMethod_decl(DecafParser.Method_declContext ctx) {
		if((ctx.ID().get(0).getText()).equals("main")) foundMain = true;
	}
	
	@Override
	public void exitProgram(DecafParser.ProgramContext ctx) {
		if(foundMain == false) System.err.println("Error line: " + (ctx.getStop().getLine() + " No Main Method")); 
	}
	
	/*@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		super.enterEveryRule(ctx);
		Scope scope = scopes.peek();
		Set<String> keys = scope.keySet(); 
		for(String key: keys){
			System.out.println(key); 
		}
	} */
	
	
	@Override
	public void enterExpr(DecafParser.ExprContext ctx) {
		Scope scope = scopes.peek(); 
		// if the expression is simply a location, check that it has been declared
		if (ctx.location() != null) {
			if(!(varInScope(ctx.location().ID().getText()))) System.err.println("Error line " + ctx.getStart().getLine() + ": Variable not declared: " + ctx.literal().getText());
		}
		
	}

	private boolean varInScope(String varName) {
		Scope scope = scopes.peek();
		boolean doesExist = false; 
		if(scope.inScope(varName)) doesExist = true;
		return doesExist; 
		}
	}
	class Scope extends Hashtable<String, ScopeElement> {
		final Scope parent;
		
		public Scope(Scope parent) {
			this.parent = parent;
		}
	boolean inScope(String varName) {
		if(super.containsKey(varName)){
			return true;
		}
		return parent == null ? false : parent.inScope(varName); 
	}
	}