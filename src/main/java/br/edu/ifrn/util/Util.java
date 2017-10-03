package br.edu.ifrn.util;

import java.net.HttpURLConnection;
import java.net.URL;

public class Util {

	public static String pegarIP(){
		  String meuIP = null;
		  String te = null;
		  try 
			{
				URL url = new URL("http://checkip.dyndns.org/");
				HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
				conexao.connect();
				java.io.BufferedReader pagina = new java.io.BufferedReader(new java.io.InputStreamReader(conexao.getInputStream()));
				meuIP = pagina.readLine();
				te = meuIP.substring(meuIP.indexOf(": ") + 2, meuIP.lastIndexOf("</body>"));
				pagina.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return te;
	  }
	
	
}
