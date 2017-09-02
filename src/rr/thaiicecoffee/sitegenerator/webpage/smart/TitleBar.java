package rr.thaiicecoffee.sitegenerator.webpage.smart;

import rr.thaiicecoffee.sitegenerator.webpage.Div;
import rr.thaiicecoffee.sitegenerator.webpage.DivAttribute;

public class TitleBar extends Div {
	
	private String title;
	
	public TitleBar(String title) {
		this.title = title;
		attributes.add(new DivAttribute("class","titlebar"));
	}
	
	public String getSource() {
		setContent("<h1>" + title + "</h1>");
		return super.getSource();
		
	}
}
