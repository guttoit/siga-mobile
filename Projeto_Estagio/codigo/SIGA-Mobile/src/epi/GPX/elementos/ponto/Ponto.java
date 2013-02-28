package epi.GPX.elementos.ponto;

import epi.GPX.ArquivoGpx;
import epi.GPX.elementos.elementoGenerico.ElementoGenericoObrigatorio;
import epi.util.VariaveisEstaticas;

public class Ponto implements ElementoGenericoObrigatorio{

	private double latitude;
	private double longitude;
	
	private CabecalhoPonto cabecalhoPonto;
	
	private CorpoPonto corpoPonto;
	
	public Ponto(){
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.cabecalhoPonto = new CabecalhoPonto();
		this.corpoPonto = new CorpoPonto();
	}
	
	public Ponto(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
		this.cabecalhoPonto = new CabecalhoPonto(latitude, longitude);
		this.corpoPonto = new CorpoPonto();
	}
	
	public void setLatitude(double latitude){
		this.latitude = latitude;
		this.cabecalhoPonto.insertLatitude(latitude);
	}
	
	public void setLongitude(double longitude){
		this.longitude = longitude;
		this.cabecalhoPonto.insertLongitude(longitude);
	}
	
	public void setNome(String nome){
		
		corpoPonto.setCampoNome(nome);
	}
	
	private String criaXmlPonto(){
		
		StringBuffer xml = new StringBuffer(cabecalhoPonto.getCabecalho());
		
		int posAddCorpo = xml.indexOf("</wpt>");
		
		xml.insert(posAddCorpo,"\n \t" + corpoPonto.getConteudo() + "\n");
		
		return xml.toString();
	}
	@Override
	public String getConteudo() {
		
		return criaXmlPonto();
	}

	@Override
	public int getPosicaoAddProxElemento() {
		
		return getConteudo().indexOf("</wpt>");
	}
	
	public static void main(String args[]){
		
		Ponto ponto = new Ponto(1.0, 123.098);
		
		ponto.setNome("Rua dr zuza de matos");
		
		Ponto ponto2 = new Ponto(1.0, 123.098);
		
		ponto2.setNome("Labepi");
		
		ArquivoGpx gpx = new ArquivoGpx();
		
		gpx.addElemento(ponto);
		gpx.addElemento(ponto);
		gpx.addElemento(ponto2);
		gpx.addElemento(ponto2);
		System.out.println(gpx.getConteudo());
	}

	@Override
	public int getTipoElemento() {
		return VariaveisEstaticas.PONTO;
	}


}
