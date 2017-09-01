package rr.thaiicecoffee.webpages;

import java.util.ArrayList;
import rr.thaiicecoffee.sitegenerator.*;


public class SimpleWebpage implements Webpage {
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
	
	String name;
	String title;
	
	String body;
	String navBarName;
	ArrayList<String> stylesheets;
	ArrayList<String> scripts;
	
	public SimpleWebpage(String name, String navBarName) {
		this.name = name;
		this.navBarName = navBarName;
		body = "";
		stylesheets = new ArrayList<String>();
		scripts = new ArrayList<String>();
	}
	
	public SimpleWebpage(String name) {
		this(name,name);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getNavBarName() {
		return navBarName;
	}
	
	@Override
	public String getPageSource() {
		String source = PAGE_START;
		source += HEAD_START;
		if (title != null) {
			source += TITLE_START + title + TITLE_END;
		}	
		for (String name : stylesheets) {
			source += STYLESHEET_START + name + STYLESHEET_END;
		}
		source += HEAD_END;
		source += BODY_START;
		source += getBody();
		source += BODY_END;
		source += PAGE_END;
		return source;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	@Override
	public String getBody() {
		return body;
	}
	
	@Override
	public void setBody(String newSource) {
		body = newSource;
	}	
	
	@Override
	public void appendDiv(String div) {
		body += div;
	}
	
	@Override
	public void prependDiv(String div) {
		body = div + body;
	}
	
	@Override
	public void addStyleSheet(String name) {
		stylesheets.add(name);
	}
	
	@Override
	public void addScript(String name) {
		
	}

}
