package com.cursoBackend.fiado.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.cursoBackend.fiado.dto.EnderecoDto;

@Embeddable
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rua;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

	public Endereco() {
		super();
	}

	public Endereco(String rua, int numero, String complemento, String bairro, String cidade, String estado) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Endereco(EnderecoDto endereco) {
		super();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
