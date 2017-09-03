package rr.thaiicecoffee.sitegenerator.webpage.stylesheet;

import java.util.ArrayList;

import rr.thaiicecoffee.sitegenerator.*;

public class SmartStylesheet extends Stylesheet {
	
	String name;
	ArrayList<DeclarationBlock> declarationBlocks;
	
	public SmartStylesheet(String inputPath) {
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
	public byte[] getPageSource() {
		String source = "";
		
		for (DeclarationBlock declarationBlock : declarationBlocks) {
			source += declarationBlock.getSource() + "\n";
		}
		
		return source.getBytes();
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
