package br.com.fiap.segurossaas.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.segurossaas.model.entity.Contrato;
import br.com.fiap.segurossaas.model.entity.Loja;
import br.com.fiap.segurossaas.model.vo.RetornoVO;
import br.com.fiap.segurossaas.service.ContratoService;
import br.com.fiap.segurossaas.service.LojaService;
import br.com.fiap.segurossaas.vo.ContratoVO;

@RestController
public class ContratoController {

	@Autowired
	private ContratoService contratoService;

	@Autowired
	private LojaService lojaService;

	@PostMapping(path="/add", produces={MediaType.APPLICATION_JSON_VALUE,
			  MediaType.APPLICATION_XML_VALUE}, consumes=MediaType.APPLICATION_JSON_VALUE)
	public RetornoVO add(@RequestBody ContratoVO contratoVO){
		Loja loja = lojaService.buscaLoja(contratoVO.getUsuario(), contratoVO.getSenha());
		RetornoVO retornoVO = new RetornoVO();
		
		if(loja != null){
			
			Contrato contrato = contratoService.save(contratoVO);
			if(contrato.getId() != null){
				retornoVO.setCodRetorno(0);
				retornoVO.setRetorno("Seguro efetuado com sucesso! ");
				retornoVO.setSucesso(true);
				retornoVO.setUser(contratoVO.getUsuario());
			}else{
				retornoVO.setCodRetorno(1);
				retornoVO.setRetorno("Falha ao efetivar seguro");
				retornoVO.setSucesso(false);
				retornoVO.setUser(contratoVO.getUsuario());
			}
		}else{
			retornoVO.setCodRetorno(2);
			retornoVO.setRetorno("Usuario ou senha inválida.");
			retornoVO.setSucesso(false);
			retornoVO.setUser(contratoVO.getUsuario());
		}
		
		return retornoVO;
	}

	@RequestMapping(value = "/buscar", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<Contrato> buscar(@QueryParam("usuario") String usuario, @QueryParam("senha")String senha) {
		Iterable<Contrato> contratos = contratoService.obterTodos(usuario, senha); 
		return contratos;
	}
}
