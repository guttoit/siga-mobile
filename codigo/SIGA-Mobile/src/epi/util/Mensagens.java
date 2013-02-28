package epi.util;

import android.content.Context;
import android.widget.Toast;
import epi.GPX.elementos.elementoGenerico.ElementoGenericoObrigatorio;

public class Mensagens {
	
	public static void exibeMensagemElementoAddComSucesso(Context contexto, ElementoGenericoObrigatorio elemento){
		
		String mensagem= criaMensagem(elemento);
		
		Toast.makeText(contexto, mensagem, Toast.LENGTH_SHORT).show();
		
	}
	
	private static String criaMensagem(ElementoGenericoObrigatorio elemento){
		
		String mensagem="";
		String conteudo = elemento.getConteudo();
		int start = conteudo.indexOf(VariaveisEstaticas.TAG_START_NOME) + VariaveisEstaticas.TAG_START_NOME.length();
		int end = conteudo.indexOf(VariaveisEstaticas.TAG_CLOSE_NOME);
		String nome = conteudo.substring(start, end);
		
		switch(elemento.getTipoElemento()){
		
			case VariaveisEstaticas.PONTO:
				
				mensagem = "O ponto " + nome + " foi adicionado.";
				
				return mensagem;
				
			case VariaveisEstaticas.ROTA:
				
				mensagem = "A rota " + nome + " foi criada.";
				
				return mensagem;
			
			case VariaveisEstaticas.ROTA_PONTO:
				
				mensagem = "O ponto " + nome + " foi adicionado a rota.";
				
				return mensagem;
				
			default:
				return mensagem;
		}
		
	}
}
