package rr.personal_website;

import java.util.ArrayList;

import rr.thaiicecoffee.sitegenerator.ExternalSiteFile;
import rr.thaiicecoffee.sitegenerator.SiteFile;
import rr.thaiicecoffee.sitegenerator.Website;
import rr.thaiicecoffee.sitegenerator.webpage.*;
import rr.thaiicecoffee.sitegenerator.webpage.smart.*;
import rr.thaiicecoffee.sitegenerator.webpage.stylesheet.Declaration;
import rr.thaiicecoffee.sitegenerator.webpage.stylesheet.DeclarationBlock;
import rr.thaiicecoffee.sitegenerator.webpage.stylesheet.ExternalStylesheet;
import rr.thaiicecoffee.sitegenerator.webpage.stylesheet.SmartStylesheet;
import rr.thaiicecoffee.sitegenerator.webpage.stylesheet.Stylesheet;

public class Main {

	public static void main(String[] args) {
		
		Website site = new Website();
		ArrayList<NavBarLink> mainPages = new ArrayList<NavBarLink>();
		
		//index
		Webpage index = (Webpage)site.addSiteFile(new Webpage("index.html"));
		Div contentDiv = index.appendDiv(new Div());
		contentDiv.setContent("Rick Rodgers' Very Experimental Website (brought to you by Java) 3 ");
		contentDiv.addDivAttribute(new DivAttribute("class","content"));
		
		mainPages.add(new NavBarLink(index,"Home"));
		//hello test
		mainPages.add(new NavBarLink(site.addSiteFile(new Webpage("hello.html")),"Test"));

		//spelling bee
		mainPages.add(new NavBarLink(site.addSiteFile(new SpellingBeeWebpage()),"Daily Spelling Bee"));
		
		
		NavBar navBar = new NavBar(mainPages);
		TitleBar titleBar = new TitleBar("Rick Rodgers' Website");
		
		ExternalStylesheet commonCSS = (ExternalStylesheet)site.addSiteFile(new ExternalStylesheet("common.css"));
		
		//other files
		BackgroundGenerator.GenerateBackground("bg.png");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		site.addSiteFile(new ExternalSiteFile("bg.png","imgs"));

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
