package br.com.fiap.segurossaas.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.segurossaas.model.entity.Loja;
import br.com.fiap.segurossaas.model.entity.Produto;
import br.com.fiap.segurossaas.model.vo.RetornoVO;
import br.com.fiap.segurossaas.produto.service.LojaService;
import br.com.fiap.segurossaas.produto.service.ProdutoService;
import br.com.fiap.segurossaas.produto.vo.ProdutoVO;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private LojaService lojaService;

	@RequestMapping(value="/add", 
			produces={MediaType.APPLICATION_JSON_VALUE,
					  MediaType.APPLICATION_XML_VALUE},
			consumes=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	
	@PostMapping(path="/add", produces={MediaType.APPLICATION_JSON_VALUE,
			  MediaType.APPLICATION_XML_VALUE}, consumes=MediaType.APPLICATION_JSON_VALUE)
	public RetornoVO add(ProdutoVO produtoVO){
		Loja loja = lojaService.buscaLoja(produtoVO.getUsuario(), produtoVO.getSenha());
		RetornoVO retornoVO = new RetornoVO();
		
		if(loja != null){
			Produto produto = new Produto(produtoVO.getNome(), produtoVO.getPreco(), loja);
			produto = produtoService.save(produto);
			if(produto.getId() != null){
				retornoVO.setCodRetorno(0);
				retornoVO.setRetorno("Produto " + produto.getNome() + "cadastrado com sucesso!");
				retornoVO.setSucesso(true);
				retornoVO.setUser(produtoVO.getUsuario());
			}else{
				retornoVO.setCodRetorno(1);
				retornoVO.setRetorno("Falha ao inserir produto");
				retornoVO.setSucesso(false);
				retornoVO.setUser(produtoVO.getUsuario());
			}
		}else{
			retornoVO.setCodRetorno(2);
			retornoVO.setRetorno("Usuario ou senha inválida.");
			retornoVO.setSucesso(false);
			retornoVO.setUser(produtoVO.getUsuario());
		}
		
		return retornoVO;
	}

//	@RequestMapping(value="/buscar", 
//			produces={MediaType.APPLICATION_JSON_VALUE,
//					  MediaType.APPLICATION_XML_VALUE},
//			method=RequestMethod.GET)	
//	public Produto buscar(String usuario, String senha){
//		Loja loja = lojaService.buscaLoja(usuario, senha);
//		
//		Produto p = new Produto();
//		p.setLoja(new Loja());
//		return p;
//	}
	
}
