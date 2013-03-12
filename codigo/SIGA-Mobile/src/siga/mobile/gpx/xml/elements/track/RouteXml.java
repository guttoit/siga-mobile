package siga.mobile.gpx.xml.elements.track;

import siga.mobile.gpx.modell.Route;
import siga.mobile.gpx.xml.ElementGpxGeneric;
import siga.mobile.gpx.xml.GpxTags;
import siga.mobile.gpx.xml.XmlCreateBody;
import siga.mobile.gpx.xml.XmlCreateHeader;

public class RouteXml implements ElementGpxGeneric {
	
	private Route route = new Route();
	public static final String openHeader = "<"+GpxTags.ROUTE+"> ";
    public static final String closeHeader = "</"+GpxTags.ROUTE+">";
    
	public RouteXml(Route route ){
		this.route = route;
	}

	@Override
	public String getContent() {
		
		String header = XmlCreateHeader.getHeader(GpxTags.ROUTE, null);		
		StringBuffer xml = new StringBuffer(header);
		
		int posAddCorpo = xml.indexOf(closeHeader);
		
		String body = XmlCreateBody.getBody(route.getAttributesList());
		
		xml.insert(posAddCorpo,"\n \t" + body + "\n");
		
		return xml.toString();
	}

	@Override
	public int getElementType() {
		return GpxTags.TYPE_ROUTE;
	}
	
}
