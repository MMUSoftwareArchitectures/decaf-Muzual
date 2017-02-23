package decaf;

import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class ScopeListener extends DecafParserBaseListener {

	private Stack<Scope> scopes;
	
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
			System.out.println("Adding: " + varName + " " + varType); 
			}
		}
	}
	
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
		if(super.contains(varName)){
			return true;
		}
		return parent == null ? false : parent.inScope(varName); 
	}
	}