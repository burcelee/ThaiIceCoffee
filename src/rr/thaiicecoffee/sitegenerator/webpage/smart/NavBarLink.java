package rr.thaiicecoffee.sitegenerator.webpage.smart;

import rr.thaiicecoffee.sitegenerator.SiteFile;

public class NavBarLink {

	private SiteFile siteFile;
	private String label;
	
	public NavBarLink(SiteFile siteFile, String label) {
		this.siteFile = siteFile;
		this.label = label;
	}
	
	public SiteFile getSiteFile() {
		return siteFile;
	}
	
	public String getLabel() {
		return label;
	}
}
