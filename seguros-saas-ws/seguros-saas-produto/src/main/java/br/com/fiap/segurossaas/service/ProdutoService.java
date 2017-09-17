package br.com.fiap.segurossaas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.segurossaas.model.entity.Loja;
import br.com.fiap.segurossaas.model.entity.Produto;
import br.com.fiap.segurossaas.repository.LojaRepository;
import br.com.fiap.segurossaas.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private LojaRepository lojaRepository;
	
	public Produto save(Produto produto) {
		return repository.save(produto);
	}

	public Iterable<Produto> buscarTodos(String usuario, String senha) {
		Loja loja = lojaRepository.findByUsuarioAndSenha(usuario, senha);
		return repository.findByLoja(loja);
	}
}
