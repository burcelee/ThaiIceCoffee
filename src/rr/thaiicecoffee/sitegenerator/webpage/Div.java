package rr.thaiicecoffee.sitegenerator.webpage;

import java.util.ArrayList;

public class Div {
	
	protected ArrayList<Div> subDivs;
	protected ArrayList<DivAttribute> attributes;
	protected String content;
	
	public Div() {
		subDivs = new ArrayList<Div>();
		attributes = new ArrayList<DivAttribute>();
		content = "";
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Div addDiv(Div div) {
		subDivs.add(div);
		return div;
	}
	public void addDivAttribute(DivAttribute attribute) {
		attributes.add(attribute);
	}
	
	public String getAttributeValue(String attr) {
		
		for (DivAttribute attribute : attributes) {
			if (attribute.getAttribute().equals(attr)) {
				return attribute.getValue();
			}
		}
		return null;
	}
	public String getSource() {
		String source = "<div";
		
		for (DivAttribute attribute : attributes) {
			source += " " + attribute.getSource(); 
		}
		
		source += ">\n";
		if (subDivs.size() == 0) {
			source += content + "\n";
		}
		else {
			for (Div div : subDivs) {
				source += div.getSource();
			}
		}
		source += "</div>\n";
		
		return source;
	}
}
