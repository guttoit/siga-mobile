package epi.GPX.elementos.rota;

public class CabecalhoRota {
	
	private String cabecalho = "";
	private int posAddCorpo = 0;
	public CabecalhoRota(){
		cabecalho = "<rte>#c</rte>";
		posAddCorpo = cabecalho.indexOf("</rte>") - 1;
	}
	
	public String getCabecalho(){
		
		String cabecalhoAux = cabecalho.toString();
		
		cabecalhoAux = cabecalhoAux.replace("#c","");
		
		return cabecalhoAux;
	}
	
	public int getPosParaAddElemento(){
		String cab = this.getCabecalho();
		posAddCorpo = cabecalho.indexOf("</rte>") - 2;
		return posAddCorpo;
	
	}
	
	public static void main (String args[]){
		
		new CabecalhoRota().getCabecalho();
	}
}
