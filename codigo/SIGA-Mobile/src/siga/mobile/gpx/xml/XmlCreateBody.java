package siga.mobile.gpx.xml;

import java.util.List;

import siga.mobile.gpx.modell.attributes.Attribute;

public class XmlCreateBody {

	public static String getBody(List<Attribute> attributesList){
		String body = "";
		
		for(Attribute att: attributesList)
			body +=  att.toString() + "\n" ;
		
		return body;
	}
	
}
