package rr.thaiicecoffee.sitegenerator.webpage.stylesheet;

public class Declaration{

	private String property;
	private String value;
	
	public Declaration(String property, String value) {
		this.property = property;
		this.value = value;
	}
	
	public String getSource() {
		return property + ":" + value + ";";
 	}
}
