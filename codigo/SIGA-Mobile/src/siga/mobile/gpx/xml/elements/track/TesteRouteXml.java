package siga.mobile.gpx.xml.elements.track;

import siga.mobile.gpx.modell.Route;

public class TesteRouteXml {

	public static void main(String args[]){
		
		Route route = new Route();
		RouteXml routeXml = new RouteXml(route);
		
		System.out.println(routeXml.getContent());
	}
}
