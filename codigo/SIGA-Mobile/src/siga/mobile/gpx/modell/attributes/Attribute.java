package siga.mobile.gpx.modell.attributes;

public interface Attribute {

	public Object getValue();
	
	public void setValue(Object value);
	
	public void setName(String name);
	
	public String getName();

	public String toString();
}
