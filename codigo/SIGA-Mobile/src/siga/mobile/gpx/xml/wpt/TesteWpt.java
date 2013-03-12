package siga.mobile.gpx.xml.wpt;

import siga.mobile.gpx.modell.WayPoint;

public class TesteWpt {
	
	
	public static void main(String args[]){
		
		WayPoint wpt = new WayPoint(1.293, 2.03);
		WayPointXml wptXml = new WayPointXml(wpt);
		
		System.out.println(wptXml.getContent());
	}

}
