package br.edu.ifrn.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.edu.ifrn.model.Localizacao;
import br.edu.ifrn.util.Util;


@Controller
@RequestMapping("/")
public class IpController {
	
	private static String IP_VIEW = "ConsultaIP";

	@RequestMapping
	public ModelAndView ip() throws UnirestException, JsonParseException, JsonMappingException, IOException {
		
		ModelAndView mv = new ModelAndView(IP_VIEW);
		String ip = Util.pegarIP();
		
		HttpResponse<JsonNode> response = Unirest.post("https://community-neutrino-ip-info.p.mashape.com/ip-info")
		.header("X-Mashape-Key", "CraTlFKOFtmshaTMQRdxw4u0fvrYp1OjtRtjsnua0N7m2xdpoj")
		.header("Content-Type", "application/x-www-form-urlencoded")
		.header("Accept", "application/json")
		.field("ip", ip)
		.field("reverse-lookup", false)
		.asJson();
		String json = response.getBody().toString();
		Gson gson = new Gson();
		
		Localizacao localizacao = gson.fromJson(json, Localizacao.class);
		
		mv.addObject(localizacao);
		return mv;
	}
	
}
