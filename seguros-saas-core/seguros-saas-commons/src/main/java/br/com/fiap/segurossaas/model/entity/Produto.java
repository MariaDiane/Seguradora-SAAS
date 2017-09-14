package br.com.fiap.segurossaas.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name="produto")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Produto {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private double valor;
	
	@ManyToOne
	private Loja loja;
	
	public Produto(){
	}

	public Produto(String nome, double valor, Loja loja) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.loja = loja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}
}
