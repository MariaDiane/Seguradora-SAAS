package br.com.fiap.segurossaas.repository;

 import org.springframework.data.repository.CrudRepository;

import br.com.fiap.segurossaas.model.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
}
