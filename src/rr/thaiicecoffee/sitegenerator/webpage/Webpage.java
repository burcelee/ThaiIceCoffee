package rr.thaiicecoffee.sitegenerator.webpage;

import java.util.ArrayList;

import rr.thaiicecoffee.sitegenerator.*;
import rr.thaiicecoffee.sitegenerator.webpage.script.Script;
import rr.thaiicecoffee.sitegenerator.webpage.stylesheet.*;


public class Webpage implements SiteFile {
	static final String PAGE_START = "<!DOCTYPE html><html>";
	static final String PAGE_END = "</html>";
	static final String HEAD_START = "<head>";
	static final String HEAD_END = "</head>";
	static final String TITLE_START = "<title>";
	static final String TITLE_END = "</title>";
	static final String BODY_START = "<body>";
	static final String BODY_END = "</body>";
	static final String STYLESHEET_START = "<link rel='stylesheet' href='";
	static final String STYLESHEET_END = "'>";
	static final String SCRIPT_START = "<link rel='stylesheet' href='";
	static final String SCRIPT_END = "'>";

	
	private String fileName;
	
	//content
	private String title;
	
	private ArrayList<Div> divs;
	private ArrayList<Stylesheet> stylesheets;
	private ArrayList<Script> scripts;
	
	public Webpage(String fileName) {
		this.fileName = fileName;
		divs = new ArrayList<Div>();
		stylesheets = new ArrayList<Stylesheet>();
		scripts = new ArrayList<Script>();
	}
	
	@Override
	public String getSubdirectory() {
		return null;
	}
	
	@Override
	public String getFileName() {
		return fileName;
	}
	
	@Override
	public String getPageSource() {
		String source = PAGE_START;
		source += HEAD_START;
		if (title != null) {
			source += TITLE_START + getTitle() + TITLE_END;
		}	
		for (Stylesheet stylesheet : stylesheets) {
			source += STYLESHEET_START + stylesheet.getSubdirectory() + "/" + stylesheet.getFileName() + STYLESHEET_END;
		}
		for (Script script : scripts) {
			source += SCRIPT_START + script.getSubdirectory() + "/" + script.getFileName() + SCRIPT_END;
		}
		source += HEAD_END;
		source += BODY_START;
		for (Div div : divs) {
			source += div.getSource() + "\n";
		}
		source += BODY_END;
		source += PAGE_END;
		return source;
	}
	
	@Override
	public String getPath() {
		
		return (getSubdirectory() == null) ? getFileName() : getSubdirectory() + "/" + getFileName();
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Div appendDiv(Div div) {
		divs.add(div);
		return div;
	}
	
	public Div prependDiv(Div div) {
		divs.add(0, div);
		return div;
	}
	
	public Stylesheet addStylesheet(Stylesheet stylesheet) {
		stylesheets.add(stylesheet);
		return stylesheet;
	}
	
	public Script addScript(Script script) {
		scripts.add(script);
		return script;
	}

}
