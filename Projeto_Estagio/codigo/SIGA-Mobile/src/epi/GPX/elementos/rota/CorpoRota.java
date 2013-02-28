package epi.GPX.elementos.rota;

import epi.GPX.elementos.camposNaoObrigatorios.CampoNome;

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
