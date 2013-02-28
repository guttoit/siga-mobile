package siga.mobile.telas;

import epi.sigmobile2.controle.ControleTelaRota;
import siga.mobile.R;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class TelaRota extends Activity {

	private Button botaoAddPontoRota;
	private Button botaoVerLocalizacao;
	private Button botaoOk;
	
	private EditText editTextNomeRota;
	private EditText editTextAutor;
	private EditText editTextNomePontoRota;
	
	private ControleTelaRota controleTelaRota;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_rota);
		
		inicializaElementosInterfaceGrafica();
		setAcoesElementosDaInterfaceGrafica();
	}

	
	private void inicializaElementosInterfaceGrafica(){
		
		controleTelaRota = new ControleTelaRota(this);
		
		botaoAddPontoRota = (Button) findViewById(R.id.button_adicionarPontoRota);
		botaoVerLocalizacao = (Button) findViewById(R.id.button_verLocalizacao);
		botaoOk = (Button) findViewById(R.id.button_okRota);
		
		editTextAutor = (EditText) findViewById(R.id.editText_autorRota);
		editTextNomePontoRota = (EditText) findViewById(R.id.editText_nomePontoRota);
		editTextNomeRota = (EditText) findViewById(R.id.editText_nomeRota);
	}
	
	public void setAcoesElementosDaInterfaceGrafica(){
		botaoAddPontoRota.setOnClickListener(controleTelaRota);
		botaoOk.setOnClickListener(controleTelaRota);
		botaoVerLocalizacao.setOnClickListener(controleTelaRota);
	}


	public Button getBotaoAddPontoRota() {
		return botaoAddPontoRota;
	}


	public void setBotaoAddPontoRota(Button botaoAddPontoRota) {
		this.botaoAddPontoRota = botaoAddPontoRota;
	}


	public Button getBotaoVerLocalizacao() {
		return botaoVerLocalizacao;
	}


	public void setBotaoVerLocalizacao(Button botaoVerLocalizacao) {
		this.botaoVerLocalizacao = botaoVerLocalizacao;
	}


	public Button getBotaoOk() {
		return botaoOk;
	}


	public void setBotaoOk(Button botaoOk) {
		this.botaoOk = botaoOk;
	}


	public EditText getEditTextNomeRota() {
		return editTextNomeRota;
	}


	public void setEditTextNomeRota(EditText editTextNomeRota) {
		this.editTextNomeRota = editTextNomeRota;
	}


	public EditText getEditTextAutor() {
		return editTextAutor;
	}


	public void setEditTextAutor(EditText editTextAutor) {
		this.editTextAutor = editTextAutor;
	}


	public EditText getEditTextNomePontoRota() {
		return editTextNomePontoRota;
	}


	public void setEditTextNomePontoRota(EditText editTextNomePontoRota) {
		this.editTextNomePontoRota = editTextNomePontoRota;
	}
}
