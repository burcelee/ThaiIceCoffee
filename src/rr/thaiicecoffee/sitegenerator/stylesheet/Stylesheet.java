package rr.thaiicecoffee.sitegenerator.stylesheet;

import java.util.ArrayList;

public class Stylesheet {
	
	String name;
	ArrayList<DeclarationBlock> declarationBlocks;
	
	public Stylesheet(String name) {
		this.name = name;
		declarationBlocks = new ArrayList<DeclarationBlock>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addDeclarationBlock(DeclarationBlock declarationBlock) {
		declarationBlocks.add(declarationBlock);
	}
	
	public String getSource() {
		String source = "";
		
		for (DeclarationBlock declarationBlock : declarationBlocks) {
			source += declarationBlock.getSource() + "\n";
		}
		
		return source;
	}
	
}
