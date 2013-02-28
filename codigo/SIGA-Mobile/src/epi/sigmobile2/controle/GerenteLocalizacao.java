package epi.sigmobile2.controle;

import java.util.ArrayList;
import java.util.List;

import siga.mobile.telas.TelaPrincipal;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class GerenteLocalizacao implements LocationListener{

	private TelaPrincipal activity;
	private LocationManager locationManager;
	
	private double latitude;
	private double longitude;
	private List<Location> listaLocalizacoes;
	
	private static GerenteLocalizacao gerenteLocalizacao;
	
	private GerenteLocalizacao(Activity activity) {
		
		this.activity = (TelaPrincipal) activity;
		locationManager = (LocationManager) this.activity.getSystemService(Context.LOCATION_SERVICE);
	
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 2, this);
		
		latitude = 0;
		longitude = 0;
		listaLocalizacoes = new ArrayList<Location>();
	}
	
	public static GerenteLocalizacao getInstance(TelaPrincipal tela){
		
		if(gerenteLocalizacao == null)
			return gerenteLocalizacao = new GerenteLocalizacao(tela);
		
		return gerenteLocalizacao;
		
	}
	
	public void configuraLocationManager(String tipoProvedor, int tempoAtualizacao, int variacaoEspacoAtualizacao){
		locationManager.requestLocationUpdates(tipoProvedor, tempoAtualizacao, variacaoEspacoAtualizacao, this);
		
	}
	@Override
	public void onLocationChanged(Location location) {
		
		latitude = location.getLatitude();
		   
        longitude = location.getLongitude();
        
        Location l = new Location(location);
        
        listaLocalizacoes.add(l);
        
        activity.getControleTelaUsuario().atualizaDadosLocalizacaoTela();
		
	}
	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
	public double getLatitudeAtual(){
		return latitude;
	}
	
	public double getLongitudeAtual(){
		
		return longitude;
	}
}
