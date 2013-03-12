package siga.mobile.gpx.xml.elements.track;

import siga.mobile.gpx.xml.elements.fieldsDontRequired.CampoNome;

public class CorpoRota {

	private CampoNome campoNome;
	
	public CorpoRota(){
		this.campoNome = new CampoNome();
	}
	
	public String getConteudo(){
		
		return campoNome.getXmlDoCampo();
	}
	
	public void setCampoNome(String nome){
		
		campoNome.setValor(nome);
	}
}
