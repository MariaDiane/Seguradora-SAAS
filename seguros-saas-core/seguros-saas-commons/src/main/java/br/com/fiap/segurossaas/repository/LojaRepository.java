package br.com.fiap.segurossaas.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fiap.segurossaas.model.entity.Loja;

public interface LojaRepository extends CrudRepository<Loja, Long> {
	Loja findByUsuarioAndSenha(String usuario, String senha);
}
