package epi.GPX.elementos.ponto;

import epi.GPX.elementos.camposNaoObrigatorios.CampoNome;

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
