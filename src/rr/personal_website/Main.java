package rr.personal_website;

import rr.thaiicecoffee.sitegenerator.*;
import rr.thaiicecoffee.sitegenerator.stylesheet.*;
import rr.thaiicecoffee.webpages.*;

public class Main {

	public static void main(String[] args) {
		
		Website site = new Website();
		
		site.addCommonTitle("What a title");
		site.addCommonNavBar();
		
		//index
		SimpleWebpage index = new SimpleWebpage("index.html");
		index.setBody("Rick Rodgers' Very Experimental Website (brought to you by Java)");
		site.addPage(index);
		
		//hello test
		site.addPage(new SimpleWebpage("hello.html"));

		//spelling bee
		site.addPage(new SpellingBeeWebpage());
		
		Stylesheet commonCSS = new Stylesheet("common.css");
		DeclarationBlock navbarDeclarationBlock = new DeclarationBlock(".navbar a");
		commonCSS.addDeclarationBlock(navbarDeclarationBlock);
		navbarDeclarationBlock.addDeclaration(new Declaration("padding","20px"));
		site.addCommonStylesheet(commonCSS);
		
		try {
			site.generateWebsite("");
		} catch (Exception e) {
			
		}
	}
}
