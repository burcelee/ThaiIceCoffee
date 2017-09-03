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
		for (NavBarLink link : links) {
			Div linkDiv = this.addDiv(new Div());
			linkDiv.addDivAttribute(new DivAttribute("class","link"));
			linkDiv.setContent("<a href='"+link.getSiteFile().getPath() + "'>" + link.getLabel() + "</a>\n");
		}
	}
	
	public String getSource() {
		return super.getSource();
	}
}
