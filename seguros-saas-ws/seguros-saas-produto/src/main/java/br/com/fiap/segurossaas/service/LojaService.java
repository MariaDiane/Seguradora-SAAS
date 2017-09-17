package br.com.fiap.segurossaas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.segurossaas.model.entity.Loja;
import br.com.fiap.segurossaas.repository.LojaRepository;

@Service
public class LojaService {
	
	@Autowired
	private LojaRepository repository;
	
	public Loja buscaLoja(String usuario, String senha) {
		return repository.findByUsuarioAndSenha(usuario, senha);
	}

}
