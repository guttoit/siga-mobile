package siga.mobile.gpx.xml.elements.fieldsDontRequired;

import siga.mobile.gpx.xml.CampoDoElementoGpx;

public class CampoNome implements CampoDoElementoGpx{

	private String nome = "";
	private String nomeXml = "<name>" + nome + "</name>";
	
	public CampoNome(){}
	
	public CampoNome(String nome){
		
		this.nome = nome;
	}
	
	@Override
	public void setValor(Object valor) {
		this.nome = (String) valor;
	}

	public void atualizaXml(){
		
		nomeXml = "<name>" + nome + "</name>";
	}
	
	@Override
	public String getXmlDoCampo() {
		
		atualizaXml();
		
		return nomeXml;
	}

}
