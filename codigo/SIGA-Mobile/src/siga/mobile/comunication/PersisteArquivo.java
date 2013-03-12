package siga.mobile.comunication;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.entity.InputStreamEntity;

import siga.mobile.util.VariaveisEstaticas;


import android.content.Context;
import android.util.Log;


public class PersisteArquivo {

	private Context contexto;
	
	public PersisteArquivo(Context c){
		contexto = c;
	}
	
	public int salvaArquivo(String caminhoArquivo, String conteudo){
		
		FileOutputStream fos;
		try {
			
			fos = contexto.openFileOutput(caminhoArquivo, Context.MODE_PRIVATE);
			fos.write(conteudo.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return VariaveisEstaticas.ERR_FILE_NOT_FOUND;
			
		} catch (IOException e) {
			e.printStackTrace();
			return VariaveisEstaticas.ERR_IOEXCEPTION;
			
		}
		
		return VariaveisEstaticas.SUCESSO;
	}
	
	public InputStreamEntity getFile(String caminhoArquivo) throws FileNotFoundException{
		
		FileInputStream fis = contexto.openFileInput(caminhoArquivo);
		
		InputStreamEntity ise = new InputStreamEntity(fis, -1);
		
		return ise;
		
	}
	
	
	public String leArquivo(String caminhoArquivo){
		
		FileInputStream fis;
		String res = "";
		try {
			fis = contexto.openFileInput(caminhoArquivo);
			byte[] bytes = readBytes(fis);
			
			res = new String(bytes);
			Log.w("ArquivoGpx", res);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	private byte[] readBytes(InputStream in) throws IOException{
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		try{
			
			byte[] buffer  = new byte[1024];
			
			int len;
			
			while((len = in.read(buffer)) > 0){
				
				bos.write(buffer, 0, len);
			}
			
			byte[] bytes = bos.toByteArray();
			
			return bytes;
		
		}finally{
			bos.close();
			in.close();
		}
	}
}
