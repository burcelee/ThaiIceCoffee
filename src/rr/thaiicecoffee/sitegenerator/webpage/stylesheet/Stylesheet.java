package rr.thaiicecoffee.sitegenerator.webpage.stylesheet;

import java.util.ArrayList;

import rr.thaiicecoffee.sitegenerator.*;

public class Stylesheet implements SiteFile {
	
	String name;
	ArrayList<DeclarationBlock> declarationBlocks;
	
	public Stylesheet(String name) {
		this.name = name;
		declarationBlocks = new ArrayList<DeclarationBlock>();
	}

	@Override
	public String getFileName() {
		return name;
	}

	@Override
	public String getSubdirectory() {
		return "css";
	}

	@Override
	public String getPageSource() {
		String source = "";
		
		for (DeclarationBlock declarationBlock : declarationBlocks) {
			source += declarationBlock.getSource() + "\n";
		}
		
		return source;
	}
	
	@Override
	public String getPath() {
		return getSubdirectory() + "/" + getFileName();
	}
	
	public DeclarationBlock addDeclarationBlock(DeclarationBlock declarationBlock) {
		declarationBlocks.add(declarationBlock);
		return declarationBlock;
	}


	
}
