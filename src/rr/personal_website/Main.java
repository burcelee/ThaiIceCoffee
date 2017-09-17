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
		ArrayList<NavBarLink> navBarPages = new ArrayList<NavBarLink>();
		
		//index
		Webpage index = (Webpage)site.addSiteFile(new Webpage("index.html"));
		Div contentDiv = index.appendDiv(new Div());
		contentDiv.setContent("Rick Rodgers' Very Experimental Website (brought to you by Java) 3 ");
		contentDiv.addDivAttribute(new DivAttribute("class","content"));
		
		navBarPages.add(new NavBarLink(index,"Home"));
		//hello test
		navBarPages.add(new NavBarLink(site.addSiteFile(new Webpage("Contact.html")),"See Also"));

		//spelling bee
		navBarPages.add(new NavBarLink(site.addSiteFile(new SpellingBeeWebpage()),"Daily Spelling Bee"));
		
		Webpage blog = new Webpage("Blog.html");
		navBarPages.add(new NavBarLink(site.addSiteFile(blog),"Oh God, A Blog"));
		Div blogContentDiv = blog.appendDiv(new Div());
		blogContentDiv.setContent("<iframe src ='https://gloriouscode.blogspot.com/' width='100%' height='1000'><p>Your browser does not support iFrames.</p></iframe>");
		blogContentDiv.addDivAttribute(new DivAttribute("class","content"));
		
		
		//pos
		ExternalSiteFile posHTML = (ExternalSiteFile) site.addSiteFile(new ExternalSiteFile("pos.html",null));
		navBarPages.add(new NavBarLink(posHTML,"POS"));
		site.addSiteFile(new ExternalSiteFile("jquery-311.js","scripts"));
		site.addSiteFile(new  ExternalSiteFile("pos_fs.js","scripts"));
		site.addSiteFile(new ExternalSiteFile("pos_is.js","scripts"));
		
		NavBar navBar = new NavBar(navBarPages);
		TitleBar titleBar = new TitleBar("Rick Rodgers' Website");
		
		ExternalStylesheet commonCSS = (ExternalStylesheet)site.addSiteFile(new ExternalStylesheet("common.css"));
		

		
		
		//other files
		BackgroundGenerator.GenerateBackground("bg.png");
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
