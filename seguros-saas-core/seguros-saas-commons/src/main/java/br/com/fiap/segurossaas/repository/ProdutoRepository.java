package br.com.fiap.segurossaas.repository;

 import org.springframework.data.repository.CrudRepository;

import br.com.fiap.segurossaas.model.entity.Loja;
import br.com.fiap.segurossaas.model.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
	Produto findByNomeAndLoja(String nome, Loja loja);

	Iterable<Produto> findByLoja(Loja loja);
}
