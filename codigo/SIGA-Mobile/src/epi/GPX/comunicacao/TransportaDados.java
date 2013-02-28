package epi.GPX.comunicacao;

import java.util.Map;

import epi.util.VariaveisEstaticas;

import android.util.Log;

public class TransportaDados {

	private MyHttp myHttp;
	
	public TransportaDados(){
		
		myHttp = MyHttp.getInstance(MyHttp.NORMAL);
		
	}
	
	public String enviaDadosParaServidor(String urlServidor, Map parametros){
		String res = null;
		
		try{
			res = myHttp.doPost(urlServidor, parametros);
			
		}catch(Exception ex){
			
			Log.e(VariaveisEstaticas.LOG_IDENTIFICADOR, ex.getMessage());
			res = ex.getMessage();
		}
		
		return res;
		 
	}
}
