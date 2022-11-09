package com.cursoBackend.fiado.dto;

import com.cursoBackend.fiado.domain.Estabelecimento;

public class EstabelecimentoDto {

	private String nome;
	private String cnpj;
	private String telefone;

	public EstabelecimentoDto() {
		super();
	}

	public EstabelecimentoDto(String nome, String cnpj, String telefone) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
	}

	public EstabelecimentoDto(Estabelecimento estabelecimento) {
		super();
		this.nome = estabelecimento.getNome();
		this.cnpj = estabelecimento.getCnpj();
		this.telefone = estabelecimento.getTelefone();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
