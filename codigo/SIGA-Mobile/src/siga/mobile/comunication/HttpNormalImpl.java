package siga.mobile.comunication;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import siga.mobile.util.VariaveisEstaticas;


import android.os.Environment;
import android.util.Log;

public class HttpNormalImpl extends MyHttp {

	private final String CATEGORIA = "SIG";
	
	public String downloadArquivo(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*public String doPost(String url, Map params){
		String param = "file";
		File textFile = new File("texte.gpx");
		File binaryFile = new File("teste.gpx");
		String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.
		String CRLF = "\r\n"; // Line separator required by multipart/form-data.
		
		URLConnection connection;
		try {
			connection = new URL(url).openConnection();
		
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
		PrintWriter writer = null;
		try {
		    OutputStream output = connection.getOutputStream();
		    writer = new PrintWriter(new OutputStreamWriter(output, "UTF-8"), true); // true = autoFlush, important!

		    // Send normal param.
		    writer.append("--" + boundary).append(CRLF);
		    writer.append("Content-Disposition: form-data; name=\"param\"").append(CRLF);
		    writer.append("Content-Type: text/plain; charset=" + "UTF-8").append(CRLF);
		    writer.append(CRLF);
		    writer.append(param).append(CRLF).flush();
		    InputStreamEntity inse = (InputStreamEntity) params.get(VariaveisEstaticas.PARAMETRO_ARQUIVO);
			InputStream in = null;
		
			in = inse.getContent();
		    // Send text file.
		    writer.append("--" + boundary).append(CRLF);
		    writer.append("Content-Disposition: form-data; name=\"textFile\"; filename=\"" + textFile.getName() + "\"").append(CRLF);
		    writer.append("Content-Type: text/plain; charset=" + "UTF-8").append(CRLF);
		    writer.append(CRLF).flush();
		    BufferedReader reader = null;
		    
		    try {
		        reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
		        for (String line; (line = reader.readLine()) != null;) {
		            writer.append(line).append(CRLF);
		        }
		    } finally {
		        if (reader != null) try { reader.close(); } catch (IOException logOrIgnore) {}
		    }
		    writer.flush();

		    // Send binary file.
		    writer.append("--" + boundary).append(CRLF);
		    writer.append("Content-Disposition: form-data; name=\"binaryFile\"; filename=\"" + binaryFile.getName() + "\"").append(CRLF);
		    writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(binaryFile.getName())).append(CRLF);
		    writer.append("Content-Transfer-Encoding: binary").append(CRLF);
		    writer.append(CRLF).flush();
		    
		    
		    InputStream input = in;
		    try {
		        //input = new FileInputStream(binaryFile);
		        byte[] buffer = new byte[1024];
		        for (int length = 0; (length = input.read(buffer)) > 0;) {
		            output.write(buffer, 0, length);
		        }
		        output.flush(); // Important! Output cannot be closed. Close of writer will close output as well.
		    } finally {
		        if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
		    }
		    writer.append(CRLF).flush(); // CRLF is important! It indicates end of binary boundary.

		    // End of multipart/form-data.
		    writer.append("--" + boundary + "--").append(CRLF);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    if (writer != null) writer.close();
		}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{}
		return CRLF;
	}*/
	
	@Override
	public String doPost(String url, Map params) {
		
		try{
			
			String queryString = getQueryString(params);
			String texto = doPost(url, queryString);
			
			return texto;
		}catch(IOException e){
			Log.e(CATEGORIA, e.getMessage(), e);
		}
		
		return url;
	}
	/*
	@Override
	public String doPost(String url, Map params) {
		
		try {
		    HttpClient httpclient = new DefaultHttpClient();

		    HttpPost httppost = new HttpPost(url);
		    //InputStreamEntity reqEntity = (InputStreamEntity) params.get(VariaveisEstaticas.PARAMETRO_ARQUIVO);
		    FileEntity reqEntity = new FileEntity(new File("teste.gpx"), "multipart/form-data;");
		    
		    //reqEntity.setContentType("binary/octet-stream");
		    reqEntity.setChunked(true); // Send in multiple parts if needed
		    long len = reqEntity.getContentLength();
		    
		    httppost.getParams().setParameter("file", "gpx");
		    httppost.setEntity(reqEntity);
		    
		    httppost.setHeader("Content-Length", String.valueOf(len));
		    
		    HttpResponse response = httpclient.execute(httppost);
		
		} catch (Exception e) {
		    // show error
		}
		
		return url;
	}
	*/
	private String doPost(String url, String params) throws IOException{
		
		//Log.i(CATEGORIA, "Http.doPost: " + url + "?" + params);
		URL u = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.connect();
		
		OutputStream out = conn.getOutputStream();
		
		byte[] bytes = params.getBytes("UTF8");
		
		out.write(bytes);
		out.flush();
		out.close();
		
		InputStream in = conn.getInputStream();
		
		String texto = readString(in);
		
		conn.disconnect();
		
		return texto;
	}
	
	private String getQueryString(Map params) throws IOException{
		
		if(params == null || params.size() <= 0)
			return null;
		
		String urlParams = null;
		
		Iterator e = (Iterator) params.keySet().iterator();
		
		while(e.hasNext()){
			
			String chave = (String) e.next();
			Object objValor = params.get(chave);
			String valor = objValor.toString();
			urlParams = urlParams == null ? "" : urlParams + "&";
			urlParams += chave + "=" + valor;
			
		}
		
		return urlParams;
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
	
	private String readString(InputStream in) throws IOException{
		
		byte[] bytes =  readBytes(in);
		String texto = new String(bytes);
		//Log.i(CATEGORIA, "Http.readString: " + texto);
		return texto;
	}

}
