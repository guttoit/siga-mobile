package siga.mobile.gpx.modell;

import java.util.ArrayList;
import java.util.List;

import siga.mobile.gpx.modell.attributes.Attribute;

public class Track {
	
	private List<TrackSeqPoint> trackSeqList = new ArrayList<TrackSeqPoint>();
	private List<Attribute> attributesList = new ArrayList<Attribute>();
	
	public void addTrackSeqPoint(TrackSeqPoint trackSeqPoint){
		trackSeqList.add(trackSeqPoint);
	}
	
	public void removeTrackSeqPoint(TrackSeqPoint trackSeqPoint){
		trackSeqList.remove(trackSeqPoint);
	}

	public List<TrackSeqPoint> getTrackSeqList() {
		return trackSeqList;
	}

	public void setTrackSeqList(List<TrackSeqPoint> trackSeqList) {
		this.trackSeqList = trackSeqList;
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
