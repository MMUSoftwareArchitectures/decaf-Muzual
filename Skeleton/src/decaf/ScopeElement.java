package decaf;

public class ScopeElement {

	private String varName;
	private String varType;
	//private String varMethod; 
	
	public ScopeElement() {
		super();
	}

	public ScopeElement(String varName, String varType) {
		super();
		this.varName = varName;
		this.varType = varType;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public String getVarType() {
		return varType;
	}

	public void setVarType(String varType) {
		this.varType = varType;
	}
	/*
	public String getVarMethod() {
		return varMethod; 
	}
	
	public void setVarMethod(String varMethod) {
		this.varMethod = varMethod; 
	}
	*/
	
	
}
