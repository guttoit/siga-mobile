package siga.mobile.telas;

import epi.sigmobile2.controle.ControleTelaPrincipal;
import siga.mobile.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TelaPrincipal extends Activity implements Runnable{

	private TextView textViewValorLatitude;
	private TextView textViewValorLongitude;
	private TextView textViewGpx;
	private Button botaoEnviarMarcacao;
	private Button botaoAddElemento;
	private EditText editTextNomePonto;
	private EditText editTextAutor;
    private ControleTelaPrincipal controleTelaUsuario;
	private Spinner spinner;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        
        pegarElementosInterfaceGrafica();
        
        inicializaVariaveis();
        
        configuraEventosTela();
       
    }

    private void configuraEventosTela(){
		botaoEnviarMarcacao.setOnClickListener(controleTelaUsuario);
		botaoAddElemento.setOnClickListener(controleTelaUsuario);
		spinner.setOnItemSelectedListener(controleTelaUsuario);
	}
	
    private void inicializaVariaveis(){
    	controleTelaUsuario = new ControleTelaPrincipal(this);
    	
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.elementos_gpx, android.R.layout.simple_spinner_item);
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

    }
    
    private void pegarElementosInterfaceGrafica(){
    	spinner = (Spinner) findViewById(R.id.spinner_elementos);
    	textViewValorLatitude = (TextView) findViewById(R.id.textView_valorLatitude);
        textViewValorLongitude = (TextView) findViewById(R.id.textView_valorLongitude);
        textViewGpx = (TextView) findViewById(R.id.textView_GPX);
        botaoEnviarMarcacao = (Button) findViewById(R.id.button_enviarMarcacao);
        botaoAddElemento = (Button) findViewById(R.id.button_addElemento);
        editTextAutor = (EditText) findViewById(R.id.editText_autor);
        editTextNomePonto = (EditText) findViewById(R.id.editText_nome);
        
    }
    
    public ControleTelaPrincipal getControleTelaUsuario(){
    	
    	return controleTelaUsuario;
    }
    
    public TextView getTextViewValorLatitude() {
		return textViewValorLatitude;
	}

	public void setTextViewValorLatitude(TextView textViewValorLatitude) {
		this.textViewValorLatitude = textViewValorLatitude;
	}

	public TextView getTextViewValorLongitude() {
		return textViewValorLongitude;
	}

	public void setTextViewValorLongitude(TextView textViewValorLongitude) {
		this.textViewValorLongitude = textViewValorLongitude;
	}

	public Button getBotaoEnviarMarcacao() {
		return botaoEnviarMarcacao;
	}

	public void setBotaoEnviarMarcacao(Button botaoEnviarMarcacao) {
		this.botaoEnviarMarcacao = botaoEnviarMarcacao;
	}

	public void setControleTelaUsuario(ControleTelaPrincipal controleTelaUsuario) {
		this.controleTelaUsuario = controleTelaUsuario;
	}
	
	public TextView getTextViewGpx() {
		return textViewGpx;
	}

	public void setTextViewGpx(TextView textViewGpx) {
		this.textViewGpx = textViewGpx;
	}

	public Button getBotaoAddElemento() {
		return botaoAddElemento;
	}

	public void setBotaoAddElemento(Button botaoAddElemento) {
		this.botaoAddElemento = botaoAddElemento;
	}

	public Spinner getSpinner() {
		return spinner;
	}

	public void setSpinner(Spinner spinner) {
		this.spinner = spinner;
	}

	public EditText getEditTextNomePonto() {
		return editTextNomePonto;
	}

	public void setEditTextNomePonto(EditText editTextNomePonto) {
		this.editTextNomePonto = editTextNomePonto;
	}

	public EditText getEditTextAutor() {
		return editTextAutor;
	}

	public void setEditTextAutor(EditText editTextAutor) {
		this.editTextAutor = editTextAutor;
	}

	@Override
	public void run() {
		
		Intent intentTelaRota = new Intent(TelaPrincipal.this, TelaRota.class);
		
		startActivity(intentTelaRota);
	}
    
}
