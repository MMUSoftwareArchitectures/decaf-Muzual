package decaf;

import java.util.ArrayList;
import java.util.List;

/**
 * ScopeElement class declaration
 * 
 * Creates the objects to store in the hashtable Scope
 * storing the varName, varType and a list of parameters 
 * in the case of methods
 * 
 * @author Miles Schofield
 */
public class ScopeElement {
	// Although not utilised, varName is retained for writer's understanding
	// and is completely superfluous with ScopeElements existing in a hash table structure
	private String varName;
	private String varType;
	// List structure to store parameters. Used to ensure parameters on call occur in 
	// both same POSITION as same types 
	private List<ScopeElement> mParams = new ArrayList<ScopeElement>();
	
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
	
	public List<ScopeElement> getParams() {
		return mParams; 
	}
	
	public void setParams(ScopeElement param) {
			mParams.add(param);
	}
}