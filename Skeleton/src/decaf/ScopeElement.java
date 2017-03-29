package decaf;

import java.util.ArrayList;
import java.util.List;

public class ScopeElement {

	private String varName;
	private String varType;
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
