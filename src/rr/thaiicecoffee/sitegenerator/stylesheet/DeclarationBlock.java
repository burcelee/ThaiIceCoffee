package rr.thaiicecoffee.sitegenerator.stylesheet;

import java.util.ArrayList;

public class DeclarationBlock {
	
	String selector;
	ArrayList<Declaration> declarations;
	
	public DeclarationBlock(String selector) {
		this.selector = selector;
		declarations = new ArrayList<Declaration>();
	}
	
	public void addDeclaration(Declaration declaration) {
		declarations.add(declaration);
	}
	
	public String getSource() {
		String source = selector + " {" + "\n";
		
		for (Declaration declaration : declarations) {
			source += "    " + declaration.getSource() + "\n";
		}
		
		source += "}";
		return source;
	}
}
