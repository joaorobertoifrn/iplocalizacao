package br.edu.ifrn.service;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import br.edu.ifrn.filtro.IpFilter;
import br.edu.ifrn.model.Localizacao;

@Service
public class ConsultaIpService {
	
	public Localizacao filtrar(IpFilter filtro) throws UnirestException, JsonParseException, JsonMappingException, UnirestException {
		String ip = filtro.getIp() == null ? "%" : filtro.getIp();
		
		HttpResponse<JsonNode> response = Unirest.post("https://community-neutrino-ip-info.p.mashape.com/ip-info")
		.header("X-Mashape-Key", "CraTlFKOFtmshaTMQRdxw4u0fvrYp1OjtRtjsnua0N7m2xdpoj")
		.header("Content-Type", "application/x-www-form-urlencoded")
		.header("Accept", "application/json")
		.field("ip", ip)
		.field("reverse-lookup" , true)
		.asJson();
		String json = response.getBody().toString(); 
	 	Gson gson = new Gson();
		
		Localizacao localizacao = gson.fromJson(json, Localizacao.class);
		
		return localizacao;
	}
	
}
