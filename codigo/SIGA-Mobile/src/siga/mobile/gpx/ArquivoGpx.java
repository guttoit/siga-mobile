package siga.mobile.gpx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import siga.mobile.gpx.xml.ElementoGenericoObrigatorio;
import siga.mobile.util.VariaveisEstaticas;


public class ArquivoGpx{

	//public static final int TIPO_PONTO = 1;
	//public static final int TIPO_ROTA = 2;
	private CabecalhoArquivoGPX cabecalho;
	private List<ElementoGenericoObrigatorio> listaDeElementos;
	
	public ArquivoGpx(){
		cabecalho = new CabecalhoArquivoGPX();
		listaDeElementos = new ArrayList<ElementoGenericoObrigatorio>();
	}
	
	private String preencheArquivo(){
		
		StringBuffer s = new StringBuffer(cabecalho.toString());
		
		int posAddCorpo = cabecalho.getPosParaAddElemento();
		
		for(int i = 0; i < listaDeElementos.size(); i++){
			s.insert(posAddCorpo, "\n" + listaDeElementos.get(i).getConteudo());
			posAddCorpo += listaDeElementos.get(i).getConteudo().length() + 1;
		}
		
		return s.toString();
	}
	
	public String getConteudo(){
		
		return preencheArquivo();
	}
	
	public void addElemento(ElementoGenericoObrigatorio elemento){
		listaDeElementos.add(elemento);	
	}
	
	public boolean salvaArquivoGpx(String url){
		//Metodo nao implementado
		return false;
	}
	
	public ElementoGenericoObrigatorio getElementoPeloTipoENome(int tipo, String nome){
		
		for(ElementoGenericoObrigatorio elemento: listaDeElementos){
			
			int tipoElemento = elemento.getTipoElemento();
			
			if(tipo == tipoElemento)
				if(elemento.getConteudo().contains(nome))
					return elemento;	
		}
		
		return null;
	}
	
	public List<ElementoGenericoObrigatorio> getListaElementos(){return listaDeElementos;}
	
	public String toString(){return getConteudo();	}
	
}
