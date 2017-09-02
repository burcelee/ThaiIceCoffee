package rr.thaiicecoffee.sitegenerator.webpage;

public class DivAttribute {

	private String attribute;
	private String value;
	
	public DivAttribute(String attribute, String value) {
		this.attribute = attribute;
		this.value = value;
	}
	
	public String getAttribute() {
		return attribute;
	}
	
	public String getValue() {
		return value;
	}
	public String getSource() {
		return attribute  + "=\"" + value + "\"";
	}
	
	
}
