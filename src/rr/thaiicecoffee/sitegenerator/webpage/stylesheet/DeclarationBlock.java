package rr.thaiicecoffee.sitegenerator.webpage.stylesheet;

import java.util.ArrayList;

public class DeclarationBlock {
	
	private class Declaration{

		private String property;
		private String value;
		
		public Declaration(String property, String value) {
			this.property = property;
			this.value = value;
		}
		
		public String getSource() {
			return property + ":" + value + ";";
	 	}
	}
	String selector;
	ArrayList<Declaration> declarations;
	
	public DeclarationBlock(String selector) {
		this.selector = selector;
		declarations = new ArrayList<Declaration>();
	}
	
	public void addDeclaration(String property, String value) {
		declarations.add(new Declaration(property,value));
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
