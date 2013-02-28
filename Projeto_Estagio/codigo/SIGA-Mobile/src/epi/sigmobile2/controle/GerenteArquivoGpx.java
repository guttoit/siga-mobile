package epi.sigmobile2.controle;

import java.util.Map;

import epi.GPX.ArquivoGpx;
import epi.GPX.elementos.elementoGenerico.ElementoGenericoObrigatorio;
import epi.GPX.elementos.rota.Rota;
import epi.GPX.elementos.rota.ponto.RotaPonto;
import epi.util.VariaveisEstaticas;

public class GerenteArquivoGpx {

	private ArquivoGpx arquivoGpx;
	private static GerenteArquivoGpx instanciaGerente;
	private CriaElementosGPX criaElementoGpx;
	
	private GerenteArquivoGpx(){
		arquivoGpx = new ArquivoGpx();
		criaElementoGpx = new CriaElementosGPX();
	}

	public Rota encontraRotaPeloNome(String nome){
		
		ElementoGenericoObrigatorio rota = arquivoGpx.getElementoPeloTipoENome(VariaveisEstaticas.ROTA, nome);
		
		if(rota != null)
			return (Rota)rota;
		
		return null;
	}
	
	public static GerenteArquivoGpx getInstance(){
		
		if(instanciaGerente == null)
			return instanciaGerente = new GerenteArquivoGpx();
		
		return instanciaGerente;
		
	}
	
	public int addElementoAoArquivoGPX(Map camposDoElemento){
		
		if(camposDoElemento == null){
			
			System.out.println("Erro funcao addElementoAoArquivoGpx. Erro numero: " + VariaveisEstaticas.ERR_PARAMETRO_NULL);
			return VariaveisEstaticas.ERR_PARAMETRO_NULL;	
		}
		
		int tipoElemento = (Integer) camposDoElemento.get(VariaveisEstaticas.KEY_TIPO_ELEMENTO);
		
		ElementoGenericoObrigatorio elemento = criaElementoGpx.criaElemento(tipoElemento, camposDoElemento);
		
		if(elemento == null){
			
			System.out.println("Erro funcao criaElemento. Erro numero: " + VariaveisEstaticas.ERR_CRIAR_ELEMENTO);
			return VariaveisEstaticas.ERR_CRIAR_ELEMENTO;
		}
		
		arquivoGpx.addElemento(elemento);
		
		return VariaveisEstaticas.SUCESSO;
	}
	
	public int addElemento(ElementoGenericoObrigatorio elemento){
		arquivoGpx.addElemento(elemento);
		
		return VariaveisEstaticas.SUCESSO;
	}
	
	public ArquivoGpx getArquivoGpx() {
		return arquivoGpx;
	}

	public void setArquivoGpx(ArquivoGpx arquivoGpx) {
		this.arquivoGpx = arquivoGpx;
	}
	
		
}
