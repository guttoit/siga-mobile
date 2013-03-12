package siga.mobile.gpx.modell.attributes;

import siga.mobile.gpx.xml.GpxTags;

public class AttributeLatitude implements Attribute {
	
	private String nameAttribute = GpxTags.LATITUDE;
	private double value = 0.0;
	@Override
	public String toString() {
		String latitude = nameAttribute + "=" + "\"" + value + "\"";
		return latitude;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Object value) {
		this.value = (Double) value;
	}

	@Override
	public void setName(String name) {
		this.nameAttribute = name;
	}

	@Override
	public String getName() {
		return this.nameAttribute;
	}

}
