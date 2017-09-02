package rr.thaiicecoffee.sitegenerator.webpage.script;

import rr.thaiicecoffee.sitegenerator.SiteFile;

public class Script implements SiteFile {
	
	private String fileName;
	private String source;
	public Script() {
		
	}

	@Override
	public String getFileName() {
		return fileName;
	}

	@Override
	public String getSubdirectory() {
		return "scripts";
	}

	@Override
	public String getPageSource() {
		return source;
	}
	
	@Override
	public String getPath() {
		return getSubdirectory() + "/" + getFileName();
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
}
