package siga.mobile.gpx.xml.wpt;

import java.util.ArrayList;
import java.util.List;

import siga.mobile.gpx.modell.WayPoint;
import siga.mobile.gpx.modell.attributes.Attribute;
import siga.mobile.gpx.modell.attributes.AttributeLatitude;
import siga.mobile.gpx.modell.attributes.AttributeLongitude;
import siga.mobile.gpx.xml.ElementGpxGeneric;
import siga.mobile.gpx.xml.GpxTags;
import siga.mobile.gpx.xml.XmlCreateBody;
import siga.mobile.gpx.xml.XmlCreateHeader;

public class WayPointXml implements ElementGpxGeneric {

	private WayPoint wpt = new WayPoint();
	
    private AttributeLatitude latitudeXml = new AttributeLatitude();
    private AttributeLongitude longitudeXml = new AttributeLongitude();
    private List<Attribute> listHeaderAttributes = new ArrayList<Attribute>();
    
    public static final String openHeader = "<"+GpxTags.WAY_POINT;
    public static final String closeHeader = "</"+GpxTags.WAY_POINT+">";
    
    public WayPointXml(WayPoint wpt){
    	this.wpt = wpt;
    	latitudeXml.setValue(wpt.getLatitude());
    	longitudeXml.setValue(wpt.getLongitude());
    	listHeaderAttributes.add(latitudeXml);
    	listHeaderAttributes.add(longitudeXml);
    }
    
	@Override
	public String getContent() {
		String header = XmlCreateHeader.getHeader(GpxTags.WAY_POINT, listHeaderAttributes);		
		StringBuffer xml = new StringBuffer(header);
		
		int posAddCorpo = xml.indexOf(closeHeader);
		
		String body = XmlCreateBody.getBody(wpt.getAttributesList());
		
		xml.insert(posAddCorpo,"\n \t" + body + "\n");
		
		return xml.toString();
	}

	@Override
	public int getElementType() {
		return GpxTags.TYPE_WAY_POINT;
	}
   

	
	
}