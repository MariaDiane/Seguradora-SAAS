package br.com.fiap.segurossaas.repository;

 import org.springframework.data.repository.CrudRepository;

import br.com.fiap.segurossaas.model.entity.Contrato;
import br.com.fiap.segurossaas.model.entity.Loja;

public interface ContratoRepository extends CrudRepository<Contrato, Long> {
	
	public Iterable<Contrato> findByLoja(Loja loja);
	
}
