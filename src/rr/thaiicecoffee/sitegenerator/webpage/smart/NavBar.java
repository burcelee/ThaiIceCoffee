package rr.thaiicecoffee.sitegenerator.webpage.smart;

import java.util.ArrayList;
import rr.thaiicecoffee.sitegenerator.webpage.Div;
import rr.thaiicecoffee.sitegenerator.webpage.DivAttribute;

public class NavBar extends Div {
	
	ArrayList<NavBarLink> links;
	
	public NavBar(ArrayList<NavBarLink> links) {
		super();
		attributes.add(new DivAttribute("class","navbar"));
		this.links = links;
	}
	
	public String getSource() {
		String content = "";
		for (NavBarLink link : links) {
			content += "<a href='"+link.getSiteFile().getPath() + "'>" + link.getLabel() + "</a>\n";
		}
		setContent(content);
		return super.getSource();
		
	}
}
