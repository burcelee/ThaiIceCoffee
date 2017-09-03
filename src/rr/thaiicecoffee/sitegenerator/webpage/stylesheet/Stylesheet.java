package rr.thaiicecoffee.sitegenerator.webpage.stylesheet;

import java.util.ArrayList;

import rr.thaiicecoffee.sitegenerator.*;

public abstract class Stylesheet implements SiteFile {
	
	@Override
	public abstract String getFileName();
	
	@Override
	public String getSubdirectory() {
		return "css";
	}

	@Override
	public abstract byte[] getPageSource();
	
	@Override
	public abstract String getPath();
}
