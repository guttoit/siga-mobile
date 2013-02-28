package epi.sigmobile2.controle;

import java.util.Map;

import epi.GPX.ArquivoGpx;
import epi.GPX.elementos.elementoGenerico.ElementoGenericoObrigatorio;
import epi.GPX.elementos.ponto.Ponto;
import epi.GPX.elementos.rota.Rota;
import epi.GPX.elementos.rota.ponto.RotaPonto;
import epi.util.VariaveisEstaticas;

public class CriaElementosGPX {
	
	public int addPontoARota(Rota rota, Map camposDoElemento){
		
		if(camposDoElemento == null || rota == null){
			System.out.println("Erro funcao addPontoARota. Erro numero: " + VariaveisEstaticas.ERR_PARAMETRO_NULL);
			return VariaveisEstaticas.ERR_PARAMETRO_NULL;	
		}
		
		int tipoElemento = (Integer) camposDoElemento.get(VariaveisEstaticas.KEY_TIPO_ELEMENTO);
		
		if(tipoElemento != VariaveisEstaticas.ROTA_PONTO){
			System.out.println("Erro funcao addPontoARota. Erro numero: " + VariaveisEstaticas.ERR_TIPO_ELEMENTO_INVALIDO);
			return VariaveisEstaticas.ERR_TIPO_ELEMENTO_INVALIDO;	
		}
		
		ElementoGenericoObrigatorio elemento = criaElemento(tipoElemento, camposDoElemento);
	
		rota.addPontoDaRota((RotaPonto) elemento);
		
		return VariaveisEstaticas.SUCESSO;
	}
	
	public int addElementoAoArquivoGPX(ArquivoGpx gpx, Map camposDoElemento){
		
		if(camposDoElemento == null){
			
			System.out.println("Erro funcao addElementoAoArquivoGpx. Erro numero: " + VariaveisEstaticas.ERR_PARAMETRO_NULL);
			return VariaveisEstaticas.ERR_PARAMETRO_NULL;	
		}
		
		int tipoElemento = (Integer) camposDoElemento.get(VariaveisEstaticas.KEY_TIPO_ELEMENTO);
		
		ElementoGenericoObrigatorio elemento = criaElemento(tipoElemento, camposDoElemento);
		
		if(elemento == null){
			
			System.out.println("Erro funcao criaElemento. Erro numero: " + VariaveisEstaticas.ERR_CRIAR_ELEMENTO);
			return VariaveisEstaticas.ERR_CRIAR_ELEMENTO;
		}
		
		gpx.addElemento(elemento);
		
		return VariaveisEstaticas.SUCESSO;
	}
	
	public ElementoGenericoObrigatorio criaElemento(int tipoElemento, Map camposDoElemento){
		
		switch(tipoElemento){
		
			case VariaveisEstaticas.PONTO:
				Ponto ponto = new Ponto();
				ponto.setLongitude((Double) camposDoElemento.get(VariaveisEstaticas.KEY_LONGITUDE));
				ponto.setLatitude((Double) camposDoElemento.get(VariaveisEstaticas.KEY_LATITUDE));
				ponto.setNome((String) camposDoElemento.get(VariaveisEstaticas.KEY_NOME_ELEMENTO));
				
				return ponto;
			
			case VariaveisEstaticas.ROTA:
				RotaPonto pontoRota = new RotaPonto();
				pontoRota.setLongitude((Double) camposDoElemento.get(VariaveisEstaticas.KEY_LONGITUDE));
				pontoRota.setLatitude((Double) camposDoElemento.get(VariaveisEstaticas.KEY_LATITUDE));
				pontoRota.setNome((String) camposDoElemento.get(VariaveisEstaticas.KEY_NOME_ELEMENTO));
				
				return pontoRota;
				
			case VariaveisEstaticas.ROTA_PONTO:
				RotaPonto pontoRota2 = new RotaPonto();
				pontoRota2.setLongitude((Double) camposDoElemento.get(VariaveisEstaticas.KEY_LONGITUDE));
				pontoRota2.setLatitude((Double) camposDoElemento.get(VariaveisEstaticas.KEY_LATITUDE));
				pontoRota2.setNome((String) camposDoElemento.get(VariaveisEstaticas.KEY_NOME_ELEMENTO));
				
				return pontoRota2;
				
			default:
				return null;
		}
	}
	
}
