package epi.GPX;

public class CabecalhoArquivoGPX {

	private String cabecalho;
	private int posParaAddElemento;
	
	public CabecalhoArquivoGPX(){
		cabecalho = "<gpx version=\"1.1\" " +
				"creator=\"GuttoGPS\" xsi:schemaLocation=\"http://www.topografix.com/GPX/1/1/gpx.xsd\">\n</gpx>";
		posParaAddElemento = cabecalho.indexOf("</gpx>") - 1;
		
		cabecalho = "<?xml version=\"1.0\"?>\n<gpx version=\"1.0\""+"\n" +
				"creator=\"ExpertGPS 1.1 - http://www.topografix.com\"" + "\n"+
				"xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + "\n" +
				"xmlns=\"http://www.topografix.com/GPX/1/0\"" + "\n" +
				"xsi:schemaLocation=\"http://www.topografix.com/GPX/1/0 http://www.topografix.com/GPX/1/0/gpx.xsd\">" +
				"\n" + "</gpx>";
		posParaAddElemento = cabecalho.indexOf("</gpx>") - 1;
	}
	
	public String getCabecalho(){return cabecalho;}
	
	public int getPosParaAddElemento(){return posParaAddElemento;}
	
	public String toString(){return cabecalho;}
}
