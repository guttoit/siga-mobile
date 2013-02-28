package epi.GPX.elementos.rota.ponto;

import epi.GPX.elementos.ponto.CabecalhoPonto;

public class CabecalhoRotaPonto extends CabecalhoPonto{
	
	public CabecalhoRotaPonto(){
		super();
		super.cabecalho = "<rtept lat=\"" + latitude + "\"" + " lon=\"" + longitude + "\">\n";
		super.abreCabecalho = "<rtept ";
		super.fechaWpt = "</rtept>";
	}
	
	public CabecalhoRotaPonto(double latitude, double longitude){
		super(latitude,longitude);
		super.cabecalho = "<rtept lat=\"" + latitude + "\"" + " lon=\"" + longitude + "\">\n";
		super.abreCabecalho = "<rtept ";
		super.fechaWpt = "</rtept>";
	}
	
	public void insertLatitude(double latitude){
		super.insertLatitude(latitude);
	}
	
	public void insertLongitude(double longitude){
		super.insertLongitude(longitude);
	}
	
	public void atualizaValoresCabecalho(){
		super.atualizaValoresCabecalho();
	}
	
	public String getCabecalho(){
		
		return super.getCabecalho();
	}
}
