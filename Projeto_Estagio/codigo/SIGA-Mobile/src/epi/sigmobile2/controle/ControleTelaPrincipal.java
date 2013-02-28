package epi.sigmobile2.controle;

import siga.mobile.R;
import siga.mobile.telas.TelaPrincipal;
import epi.GPX.comunicacao.PersisteArquivo;
import epi.GPX.comunicacao.TransportaDados;
import epi.util.VariaveisEstaticas;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class ControleTelaPrincipal implements OnClickListener, OnItemSelectedListener{
	
	private TelaPrincipal telaUsuario;
	private TransportaDados transportaDados;
	private GerenteLocalizacao gerenteLocalizacao;
	private CriaElementosGPX criaElementoGpx;
	private GerenteArquivoGpx gerenteArquivoGpx;
	
	public ControleTelaPrincipal(Activity activity){
		inicializaVariaveis(activity);
	}
	
	private void inicializaVariaveis(Activity activity){
		telaUsuario = (TelaPrincipal)activity;
		transportaDados = new TransportaDados();
		gerenteLocalizacao = GerenteLocalizacao.getInstance(telaUsuario);
		criaElementoGpx = new CriaElementosGPX();
		gerenteArquivoGpx = GerenteArquivoGpx.getInstance();
	}
	
	public void atualizaDadosLocalizacaoTela(){
		
		telaUsuario.getTextViewValorLatitude().setText("" + gerenteLocalizacao.getLatitudeAtual());
		telaUsuario.getTextViewValorLongitude().setText("" + gerenteLocalizacao.getLongitudeAtual());

	}
	
	@Override
	public void onClick(View v) {
		
		if(telaUsuario == null){
			Log.w(VariaveisEstaticas.LOG_IDENTIFICADOR, "MyOnClickButto" + VariaveisEstaticas.ERR_ACTIVITY_NULL );
			return;
		}
		
		Spinner spinner = telaUsuario.getSpinner();
		
		switch(v.getId()){
			
			case R.id.button_addElemento:
				PersisteArquivo persiste = new PersisteArquivo(telaUsuario.getApplicationContext());
				String arquivo = persiste.leArquivo("teste.gpx");
				Log.i("GPX", arquivo);
				/*String item = (String) spinner.getSelectedItem();
				
				if(item.equalsIgnoreCase("ponto")){
					
					Map parametrosElemento = new HashMap();
					
					parametrosElemento.put(VariaveisEstaticas.KEY_TIPO_ELEMENTO, VariaveisEstaticas.PONTO);
					parametrosElemento.put(VariaveisEstaticas.KEY_LONGITUDE, gerenteLocalizacao.getLongitudeAtual());
					parametrosElemento.put(VariaveisEstaticas.KEY_LATITUDE, gerenteLocalizacao.getLatitudeAtual());
					parametrosElemento.put(VariaveisEstaticas.KEY_NOME_ELEMENTO, telaUsuario.getEditTextNomePonto().getText().toString());
					
					int res = gerenteArquivoGpx.addElementoAoArquivoGPX(parametrosElemento);
					
					if(res == VariaveisEstaticas.SUCESSO){
						ElementoGenericoObrigatorio elemento = gerenteArquivoGpx.getArquivoGpx().getElementoPeloTipoENome(VariaveisEstaticas.PONTO, telaUsuario.getEditTextNomePonto().getText().toString());
						Mensagens.exibeMensagemElementoAddComSucesso(telaUsuario.getApplicationContext(), elemento);
					}*/
				//}
				
				break;
			
			case R.id.button_enviarMarcacao:
				
				//PersisteArquivo persistencia = new PersisteArquivo(telaUsuario.getApplicationContext());
				//persistencia.salvaArquivo("teste.gpx", gerenteArquivoGpx.getArquivoGpx().getConteudo());
				//persistencia.leArquivo("teste.gpx");
				
			try {
				
				//Map parans = new HashMap();
				//parans.put(VariaveisEstaticas.PARAMETRO_ARQUIVO, persistencia.leArquivo("teste.gpx"));
				//parans.put(VariaveisEstaticas.PARAMETRO_ARQUIVO, 10);
				//transportaDados.enviaDadosParaServidor(VariaveisEstaticas.URL_SERVIDOR, parans);
				
				//Log.i("Persistencia", "TestePersistencia2" + persistencia.leArquivo("teste.gpx"));
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
				break;
				
			default:
				break;
		}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
			long id) {
		
		String itemSelecionado = (String) parent.getItemAtPosition(pos);
		
		if(itemSelecionado.equalsIgnoreCase("Rota"))
			telaUsuario.run();
			
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
