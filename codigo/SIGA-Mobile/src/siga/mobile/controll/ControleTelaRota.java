package siga.mobile.controll;

import siga.mobile.R;
import siga.mobile.gpx.xml.ElementoGenericoObrigatorio;
import siga.mobile.gpx.xml.elements.track.Rota;
import siga.mobile.gpx.xml.elements.track.wpt.RotaPonto;
import siga.mobile.telas.TelaRota;
import siga.mobile.util.Mensagens;
import siga.mobile.util.VariaveisEstaticas;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class ControleTelaRota implements OnClickListener{

	private TelaRota telaRota;
	private GerenteArquivoGpx gerenciaArquivoGpx;
	private GerenteLocalizacao gerenteLocalizacao;
	
	public ControleTelaRota(Activity tela){
		
		telaRota = (TelaRota) tela;
		gerenciaArquivoGpx = GerenteArquivoGpx.getInstance();
		gerenteLocalizacao = GerenteLocalizacao.getInstance(null);
	}
	
	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		
			case R.id.button_adicionarPontoRota:
				
				String nomeRota = telaRota.getEditTextNomeRota().getText().toString();
				
				Rota rota = gerenciaArquivoGpx.encontraRotaPeloNome(nomeRota);
				
				RotaPonto rotaPonto = new RotaPonto();
				rotaPonto.setLatitude(gerenteLocalizacao.getLatitudeAtual());
				rotaPonto.setLongitude(gerenteLocalizacao.getLongitudeAtual());
				rotaPonto.setNome(telaRota.getEditTextNomePontoRota().getText().toString());
				
				if(rota == null){
					rota = new Rota();
					rota.setNome(nomeRota);
					rota.addPontoDaRota(rotaPonto);
					int res = gerenciaArquivoGpx.addElemento(rota);
					if(res == VariaveisEstaticas.SUCESSO){
						//Mensagens.exibeMensagemElementoAddComSucesso(telaRota.getApplicationContext(), rota);
						Mensagens.exibeMensagemElementoAddComSucesso(telaRota.getApplicationContext(), rotaPonto);
					}
				}else{
					rota.addPontoDaRota(rotaPonto);
					Mensagens.exibeMensagemElementoAddComSucesso(telaRota.getApplicationContext(), rotaPonto);
				}
				
				break;
			
			case R.id.button_localizacao:
				
				break;
				
			case R.id.button_okRota:
				String nome = telaRota.getEditTextNomeRota().getText().toString();;
				ElementoGenericoObrigatorio elemento = gerenciaArquivoGpx.encontraRotaPeloNome(nome);
				Mensagens.exibeMensagemElementoAddComSucesso(telaRota.getApplicationContext(), elemento);
				telaRota.finish();
				
				break;
		}
		
	}

}
