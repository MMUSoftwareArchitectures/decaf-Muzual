package decaf;

import java.util.Hashtable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;
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
			String varName = field.ID().getText();
			String varType = ctx.type().getText();
			if(checkVarName(varName)) {
			System.err.println("Already exists" + varName + varType);
			} else {	
			scope.put(varName,varType);
			}
			int varArraySize = Integer.parseInt((field.INT_LITERAL().getText())); 
			if(varArraySize == 0) System.err.println("Error line " + ctx.getStart().getLine() + ": Invalid array size");
			
		}
	}
	
	@Override
	public void enterVar_decl(DecafParser.Var_declContext ctx) {
		Scope scope = scopes.peek();
			List<TerminalNode> variables = ctx.ID();
			String varType = ctx.type().getText();
			for(TerminalNode variable : variables) {
				String varName = variable.getText(); 
				
			if(checkVarName(varName)) {
			System.err.println("Error line " + ctx.getStart().getLine() + ": Already exists: " + varName + ", " + varType);
			} else {	
			scope.put(varName,varType);
			}
			}
	}
	
	@Override
	public void enterStatement(DecafParser.StatementContext ctx) {
		Scope scope = scopes.peek();
		TerminalNode variable = ctx.location().ID(); 
		if (!(checkVarName(variable.getText()))) {
				System.err.println("Error line " + ctx.getStart().getLine() + ": Variable not declared");
		}
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

	private boolean checkVarName(String varName) {
		Scope scope = scopes.peek();
		boolean doesExist = false; 
		if(scope.inScope(varName)) doesExist = true;
		return doesExist; 
		}
	}
	class Scope extends Hashtable<String, String> {
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