package siga.mobile.controll;

import siga.mobile.telas.TelaPrincipal;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class ListenerDoBotaoAdd implements OnClickListener{

	private TelaPrincipal telaUsuario = null;
	
	public ListenerDoBotaoAdd(Activity tela){
		
		telaUsuario = (TelaPrincipal) tela;
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	public void setActivity(Activity activity){
		
		telaUsuario = (TelaPrincipal) activity;
	}
}
