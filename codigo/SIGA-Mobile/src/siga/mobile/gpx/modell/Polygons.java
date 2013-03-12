package siga.mobile.gpx.modell;

import java.util.ArrayList;
import java.util.List;

import siga.mobile.gpx.modell.attributes.Attribute;

public class Polygons{

	private List<WayPoint> polygonPointsList = new ArrayList<WayPoint>();
	private List<Attribute> attributesList = new ArrayList<Attribute>();
	
	public void addPolygonPoint(WayPoint polygonPoint){
		polygonPointsList.add(polygonPoint);
	}
	
	public void removePolygonPoint(WayPoint polygonPoint){
		polygonPointsList.remove(polygonPoint);
	}
	
	public List<WayPoint> getPolygonPointsList() {
		return polygonPointsList;
	}

	public void setPolygonPointsList(List<WayPoint> polygonPointsList) {
		this.polygonPointsList = polygonPointsList;
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
