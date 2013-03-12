package siga.mobile.gpx.modell;

import java.util.ArrayList;
import java.util.List;

import siga.mobile.gpx.modell.attributes.Attribute;

public class WayPoint {

	protected double longitude = 0.0;
	protected double latitude = 0.0;
	protected List<Attribute> attributesList = new ArrayList<Attribute>();
	
	public WayPoint(){}
	
	public WayPoint(double longitude, double latitude){
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void addAttribute(Attribute attribute){
		attributesList.add(attribute);
	}
	
	public void removeAttribute(Attribute attribute){
		attributesList.remove(attribute);
	}

	public List<Attribute> getAttributesList() {
		return attributesList;
	}

	public void setAttributesList(List<Attribute> attributesList) {
		this.attributesList = attributesList;
	}
	
	
	
	
}
