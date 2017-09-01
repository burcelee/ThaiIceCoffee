package rr.thaiicecoffee.sitegenerator;


public interface Webpage {

	public String getName();
	public String getNavBarName();
	
	public String getPageSource();
	
	public String getTitle();
	public void setTitle(String newTitle);
	
	public String getBody();
	public void setBody(String newBody);
	
	public void addStyleSheet(String name);
	public void addScript(String name);
	
	public void prependDiv(String source);
	public void appendDiv(String source);
	
}
