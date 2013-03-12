package siga.mobile.comunication;

import java.util.Map;

import siga.mobile.util.VariaveisEstaticas;


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
