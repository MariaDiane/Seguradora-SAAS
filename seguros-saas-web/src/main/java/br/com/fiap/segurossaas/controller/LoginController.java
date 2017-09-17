package br.com.fiap.segurossaas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.segurossaas.model.entity.Contrato;
import br.com.fiap.segurossaas.model.entity.Loja;
import br.com.fiap.segurossaas.service.ContratoService;
import br.com.fiap.segurossaas.service.LojaService;
import br.com.fiap.segurossaas.vo.LoginVO;

@Controller
public class LoginController {
	
	@Autowired
	private LojaService lojaService;
	
	@Autowired
	private ContratoService contratoService;
	
	@RequestMapping("/")
	public String index(){
		return "login";
	}
	
	@PostMapping("/logar")
	public String logar(@RequestParam String usuario, @RequestParam String senha, Model model ){
		Loja loja = lojaService.buscaLoja(new LoginVO(usuario, senha));
		if(loja != null){
			Iterable<Contrato> contratos = contratoService.obterTodos(loja);
			model.addAttribute("contratos", contratos);
			return "home";
		}
		else
			return "login";
	}
}
