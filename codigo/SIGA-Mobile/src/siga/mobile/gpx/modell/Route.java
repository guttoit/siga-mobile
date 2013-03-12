package siga.mobile.gpx.modell;

import java.util.ArrayList;
import java.util.List;

import siga.mobile.gpx.modell.attributes.Attribute;

public class Route {
	
	protected List<WayPoint> pointsList = new ArrayList<WayPoint>();
	protected List<Attribute> attributesList = new ArrayList<Attribute>();
	
	public Route(){}
	
	public void addPoint(WayPoint point){
		pointsList.add(point);
	}
	
	public void removePoint(WayPoint point){
		pointsList.remove(point);
	}

	public List<WayPoint> getPointsList() {
		return pointsList;
	}

	public void setPointsList(List<WayPoint> pointsList) {
		this.pointsList = pointsList;
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
