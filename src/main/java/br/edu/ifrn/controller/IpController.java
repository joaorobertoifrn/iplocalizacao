package br.edu.ifrn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.edu.ifrn.filtro.IpFilter;
import br.edu.ifrn.model.Localizacao;
import br.edu.ifrn.service.ConsultaIpService;


@Controller
@RequestMapping("/")
public class IpController {
	
	private static String IP_VIEW = "ConsultaIP";
	
	@Autowired
	private ConsultaIpService consultaIpService;
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") IpFilter filtro, Errors errors, RedirectAttributes attributes) throws JsonParseException, JsonMappingException, UnirestException {
		ModelAndView mv = new ModelAndView(IP_VIEW);
			Localizacao localizacao = consultaIpService.filtrar(filtro);
			if (localizacao.getApierrormsg() != "") {
				attributes.addFlashAttribute("mensagem", "Limite de pesquisas Excedido.");
			}
			mv.addObject(localizacao);
		return mv;
	}
	
}
