package br.com.fiap.segurossaas.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.segurossaas.model.entity.Loja;
import br.com.fiap.segurossaas.model.entity.Produto;
import br.com.fiap.segurossaas.model.vo.RetornoVO;
import br.com.fiap.segurossaas.service.LojaService;
import br.com.fiap.segurossaas.service.ProdutoService;
import br.com.fiap.segurossaas.vo.ProdutoVO;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private LojaService lojaService;

	@PostMapping(path="/add", produces={MediaType.APPLICATION_JSON_VALUE,
			  MediaType.APPLICATION_XML_VALUE}, consumes=MediaType.APPLICATION_JSON_VALUE)
	public RetornoVO add(@RequestBody ProdutoVO produtoVO){
		Loja loja = lojaService.buscaLoja(produtoVO.getUsuario(), produtoVO.getSenha());
		RetornoVO retornoVO = new RetornoVO();
		
		if(loja != null){
			Produto produto = new Produto(produtoVO.getNome(), produtoVO.getValor(), loja);
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

	@RequestMapping(value = "/buscar", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
	public Iterable<Produto> buscar(@QueryParam("usuario") String usuario, @QueryParam("senha")String senha) {
		Iterable<Produto> produtos = produtoService.buscarTodos(usuario, senha); 
		return produtos;
	}
}