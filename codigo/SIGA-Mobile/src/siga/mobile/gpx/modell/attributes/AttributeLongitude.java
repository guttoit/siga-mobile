package siga.mobile.gpx.modell.attributes;

import siga.mobile.gpx.xml.GpxTags;

public class AttributeLongitude implements Attribute{

	private String nameAttribute = GpxTags.LONGITUDE;
	private double value = 0.0;
	@Override
	public String toString() {
		String longitude = nameAttribute + "=" + "\"" + value + "\"";
		return longitude;
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
