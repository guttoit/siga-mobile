package epi.GPX.elementos.rota;

import java.util.ArrayList;
import java.util.List;

import epi.GPX.ArquivoGpx;
import epi.GPX.elementos.elementoGenerico.ElementoGenericoObrigatorio;
import epi.GPX.elementos.ponto.Ponto;
import epi.GPX.elementos.rota.ponto.RotaPonto;
import epi.util.VariaveisEstaticas;

public class Rota implements ElementoGenericoObrigatorio{

	private CabecalhoRota cabecalho;
	private CorpoRota corpoRota;
	private List<RotaPonto> pontosDaRota;
	
	public Rota(){
		cabecalho = new CabecalhoRota();
		corpoRota = new CorpoRota();
		pontosDaRota = new ArrayList<RotaPonto>();
	}
	
	public void setNome(String nome){
		corpoRota.setCampoNome(nome);
	}
	
	public void addPontoDaRota(RotaPonto ponto){
		pontosDaRota.add(ponto);
	}
	
	@Override
	public String getConteudo() {
		
		StringBuffer s = new StringBuffer(cabecalho.getCabecalho());
		
		int posAddCorpo = cabecalho.getPosParaAddElemento();
		
		s.insert(posAddCorpo, "\n" + corpoRota.getConteudo());
		posAddCorpo += corpoRota.getConteudo().length() + 1;
		
		for(int i = 0; i < pontosDaRota.size(); i++){
			s.insert(posAddCorpo, "\n" + pontosDaRota.get(i).getConteudo());
			posAddCorpo += pontosDaRota.get(i).getConteudo().length() + 1;
		}
		
		s.insert(posAddCorpo,"\n");
		
		return s.toString();
	}

	@Override
	public int getPosicaoAddProxElemento() {
		return getConteudo().indexOf("</rte>") + "</rte>".length();
	}
	
	public static void main(String args[]){
		
		RotaPonto ponto = new RotaPonto(1.0, 123.098);
		
		ponto.setNome("Rua dr zuza de matos");
		
		RotaPonto ponto2 = new RotaPonto(1.0, 123.098);
		
		ponto2.setNome("Labepi");
		
		Rota rota = new Rota();
		
		rota.addPontoDaRota(ponto);
		rota.addPontoDaRota(ponto2);
		
		Ponto p = new Ponto(0, 50);
		p.setNome("Casa");
		
		ArquivoGpx gpx = new ArquivoGpx();
		
		gpx.addElemento(rota);
		gpx.addElemento(p);
		System.out.println(gpx.getConteudo());
	}

	@Override
	public int getTipoElemento() {
		return VariaveisEstaticas.ROTA;
	}

}
