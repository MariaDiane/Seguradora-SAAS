package br.com.fiap.segurossaas.model.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetornoVO", propOrder = {
	    "codRetorno",
	    "retorno",
	    "sucesso",
	    "user"
	})
public class RetornoVO implements Serializable{

	private static final long serialVersionUID = 5812684852343583493L;
	
	private Integer	codRetorno;
	private String	retorno;
	private String	user;
	private Boolean sucesso;

	public Integer getCodRetorno() {
		return codRetorno;
	}
	public void setCodRetorno(Integer codRetorno) {
		this.codRetorno = codRetorno;
	}
	public String getRetorno() {
		return retorno;
	}
	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Boolean getSucesso() {
		return sucesso;
	}
	public void setSucesso(Boolean sucesso) {
		this.sucesso = sucesso;
	}
}
