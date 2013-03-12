package siga.mobile.gpx.xml.wpt;

import siga.mobile.gpx.xml.elements.fieldsDontRequired.CampoNome;

public class CorpoPonto {
	
	private CampoNome campoNome;
	
	public CorpoPonto(){
		this.campoNome = new CampoNome();
	}
	
	public String getConteudo(){
		
		return campoNome.getXmlDoCampo();
	}
	
	public void setCampoNome(String nome){
		
		campoNome.setValor(nome);
	}
}
