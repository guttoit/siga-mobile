package siga.mobile.gpx.xml;

import java.util.List;

import siga.mobile.gpx.modell.attributes.Attribute;

public class XmlCreateHeader{

	public static String getHeader(String tag, List<Attribute> attributesList){
		String header = "<" + tag;
		
		if(attributesList != null){
			for(Attribute att: attributesList)
				header +=  " " + att.toString() ;
		}
		
		header += "/" + tag + ">";
		
		return header;
	}
	
}
