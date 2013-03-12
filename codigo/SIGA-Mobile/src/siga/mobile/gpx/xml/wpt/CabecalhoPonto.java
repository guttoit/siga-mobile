package siga.mobile.gpx.xml.wpt;

public class CabecalhoPonto {
	
	protected String latitude;
	protected String longitude;
	
	protected String cabecalho = "<wpt lat=\"" + latitude + "\"" + " lon=\"" + longitude + "\">\n" ;
	
	protected String abreCabecalho = "<wpt ";
	protected String cabecalhoLatitude = "lat=\"";
	protected String cabecalhoLongitude = "\" lon=\"";
	protected String fechaCabecalho = "\">";
	protected String fechaWpt = "</wpt>";
	
	protected String elementoNome = "";
	
	public CabecalhoPonto(){
		
		this.latitude = "";
		this.longitude = "";
	}
	
	public CabecalhoPonto(double latitude, double longitude){
		
		this.latitude = String.valueOf(latitude);
		this.longitude = String.valueOf(longitude);
	}
	public void insertLatitude(double latitude){
		
		this.latitude = String.valueOf(latitude);
		//atualizaValoresCabecalho();
	}
	
	public void insertLongitude(double longitude){
		
		this.longitude = String.valueOf(longitude);
		//atualizaValoresCabecalho();
		
	}
	
	public void atualizaValoresCabecalho(){
		
		cabecalho = abreCabecalho + cabecalhoLatitude + latitude + cabecalhoLongitude + longitude + fechaCabecalho 
				+ fechaWpt;
	}
	
	public String getCabecalho(){
		
		atualizaValoresCabecalho();
		
		return cabecalho;
	}
}
