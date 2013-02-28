package epi.GPX.comunicacao;

import java.util.Map;

/**
 * Adaptado do exemplo do livro Google Android: Aprenda a criar aplicações para dispositivos móveis
 * 
 * @author gutto
 *
 */
public abstract class MyHttp {

	public static final int NORMAL = 1;
	public static final int JAKARTA = 2;
	
	public static MyHttp getInstance(int tipo){
		
		switch(tipo){
		
			case NORMAL:
				return new HttpNormalImpl();
				
			//case JAKARTA:
				//return new HttpClienteImpl();
			
			default:
				return new HttpNormalImpl();
		}
		
	}
	
	public abstract String downloadArquivo(String url);
	
	public abstract String doPost(String url, Map map);
}

