package rr.personal_website;

import java.util.ArrayList;

import rr.thaiicecoffee.sitegenerator.SiteFile;
import rr.thaiicecoffee.sitegenerator.Website;
import rr.thaiicecoffee.sitegenerator.webpage.*;
import rr.thaiicecoffee.sitegenerator.webpage.smart.*;
import rr.thaiicecoffee.sitegenerator.webpage.stylesheet.Declaration;
import rr.thaiicecoffee.sitegenerator.webpage.stylesheet.DeclarationBlock;
import rr.thaiicecoffee.sitegenerator.webpage.stylesheet.Stylesheet;

public class Main {

	public static void main(String[] args) {
		
		Website site = new Website();
		
		ArrayList<NavBarLink> mainPages = new ArrayList<NavBarLink>();
		//index
		Webpage index = (Webpage)site.addSiteFile(new Webpage("index.html"));
		index.appendDiv(new Div()).setContent("Rick Rodgers' Very Experimental Website (brought to you by Java) 3 ");
		mainPages.add(new NavBarLink(index,"home"));
		//hello test
		mainPages.add(new NavBarLink(site.addSiteFile(new Webpage("hello.html")),"test page"));

		//spelling bee
		mainPages.add(new NavBarLink(site.addSiteFile(new SpellingBeeWebpage()),"daily spelling bee"));
		
		
		NavBar navBar = new NavBar(mainPages);
		TitleBar titleBar = new TitleBar("Rick Rodgers");
		
		Stylesheet commonCSS = (Stylesheet)site.addSiteFile(new Stylesheet("common.css"));
		
		DeclarationBlock navBarDeclarationBlock = commonCSS.addDeclarationBlock(new DeclarationBlock(navBar.getAttributeValue("class") + " a"));
		navBarDeclarationBlock.addDeclaration("padding","10px");
		
		DeclarationBlock navBar2DeclarationBlock = commonCSS.addDeclarationBlock(new DeclarationBlock(navBar.getAttributeValue("class") + " a, a:link, a:hover, a:active, a:visited"));
		navBar2DeclarationBlock.addDeclaration("color","black");
		navBar2DeclarationBlock.addDeclaration("text-decoration","underline");
		

		for (SiteFile siteFile : site.getSiteFiles()) {
			if (siteFile instanceof Webpage) {
				((Webpage) siteFile).prependDiv(navBar);
				((Webpage) siteFile).prependDiv(titleBar);
				((Webpage) siteFile).addStylesheet(commonCSS);
			}
		}
		try {
			site.generateWebsite("");
		} catch (Exception e) {
			System.out.println("test" + e);
		}
	}
}
