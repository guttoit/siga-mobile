package epi.GPX.elementos.rota.ponto;

import epi.GPX.ArquivoGpx;
import epi.GPX.elementos.elementoGenerico.ElementoGenericoObrigatorio;
import epi.util.VariaveisEstaticas;

public class RotaPonto implements ElementoGenericoObrigatorio{

	private double latitude;
	private double longitude;
	
	private CabecalhoRotaPonto cabecalhoRotaPonto;
	
	private CorpoRotaPonto corpoRotaPonto;
	
	public RotaPonto(){
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.cabecalhoRotaPonto = new CabecalhoRotaPonto();
		this.corpoRotaPonto = new CorpoRotaPonto();
	}
	
	public RotaPonto(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
		this.cabecalhoRotaPonto = new CabecalhoRotaPonto(latitude, longitude);
		this.corpoRotaPonto = new CorpoRotaPonto();
	}
	
	public void setLatitude(double latitude){
		this.latitude = latitude;
		this.cabecalhoRotaPonto.insertLatitude(latitude);
	}
	
	public void setLongitude(double longitude){
		this.longitude = longitude;
		this.cabecalhoRotaPonto.insertLongitude(longitude);
	}
	
	public void setNome(String nome){
		
		corpoRotaPonto.setCampoNome(nome);
	}
	
	private String criaXmlRotaPonto(){
		
		StringBuffer xml = new StringBuffer(cabecalhoRotaPonto.getCabecalho());
		
		int posAddCorpo = xml.indexOf("</rtept>");
		
		xml.insert(posAddCorpo,"\n\t" + corpoRotaPonto.getConteudo() + "\n" );
		
		return xml.toString();
	}
	@Override
	public String getConteudo() {
		
		return criaXmlRotaPonto();
	}

	@Override
	public int getPosicaoAddProxElemento() {
		
		return getConteudo().indexOf("</rtept>");
	}
	
	public static void main(String args[]){
		
		RotaPonto ponto = new RotaPonto(1.0, 123.098);
		
		ponto.setNome("Rua dr zuza de matos");
		
		RotaPonto ponto2 = new RotaPonto(1.0, 123.098);
		
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
		return VariaveisEstaticas.ROTA_PONTO;
	}

}
