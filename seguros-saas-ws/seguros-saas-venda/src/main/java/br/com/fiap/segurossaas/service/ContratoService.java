package br.com.fiap.segurossaas.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.segurossaas.model.entity.Contrato;
import br.com.fiap.segurossaas.model.entity.Loja;
import br.com.fiap.segurossaas.model.entity.Produto;
import br.com.fiap.segurossaas.model.entity.Segurado;
import br.com.fiap.segurossaas.repository.ContratoRepository;
import br.com.fiap.segurossaas.repository.LojaRepository;
import br.com.fiap.segurossaas.repository.ProdutoRepository;
import br.com.fiap.segurossaas.repository.SeguradoRepository;
import br.com.fiap.segurossaas.vo.ContratoVO;

@Service
public class ContratoService {

	@Autowired
	private ContratoRepository contratoRepository;

	@Autowired
	private LojaRepository lojaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private SeguradoRepository seguradoRepository;
	
	public Iterable<Contrato> obterTodos(String usuario, String senha){
		Loja loja = lojaRepository.findByUsuarioAndSenha(usuario, senha);
		Iterable<Contrato> contratos = contratoRepository.findByLoja(loja);
		return contratos;
	}
	
	public Contrato save(ContratoVO contratoVO) {
		//Busca a loja informada
		Loja loja = lojaRepository.findByUsuarioAndSenha(contratoVO.getUsuario(), contratoVO.getSenha());
		//Busca a produto informado
		Produto produto = produtoRepository.findByNomeAndLoja(contratoVO.getProduto(), loja);
		
		//Insere segurado na base
		Segurado segurado = new Segurado();
		segurado.setNome(contratoVO.getNomeSegurado());
		segurado.setCpf(contratoVO.getCpfSegurado());
		segurado.setDataNascimento(contratoVO.getDataNascimento());
		segurado.setEstadoCivil(contratoVO.getEstadoCivil());
		segurado = seguradoRepository.save(segurado);
		
		//Insere contrato na base
		Contrato contrato = new Contrato();
		contrato.setLoja(loja);
		contrato.setProduto(produto);
		contrato.setDataCriacao(new Date());
		contrato.setInicioVigencia(contratoVO.getInicioVigencia());
		contrato.setSegurado(segurado);
		contrato.setStatus("Pendente");
		contrato.setFormaPagamento(contratoVO.getFormaPagamento());
		
		//Gera data de fim de vigencia
		Calendar fimVigencia = Calendar.getInstance();
		fimVigencia.setTime(contratoVO.getInicioVigencia());
		fimVigencia.add(Calendar.YEAR, 1);
		contrato.setFimVigencia(fimVigencia.getTime());
		
		//Cria numero do contrato
		String numeroContrato = fimVigencia.get(Calendar.YEAR) + "000000" + ((int)(Math.random() * 1000));
		contrato.setNumero(numeroContrato);
		
		return contratoRepository.save(contrato);
	}
}
