package br.com.springboot.sistema-movimentacao-produtos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpController {

	@RequestMapping(value = "/")
    public String index() {
    	
    	return "index.html";
    	
    }

	@RequestMapping(value = "/index")
    public String indexPrincipal() {
    	
    	return "index.html";
    	
    }
	
}
