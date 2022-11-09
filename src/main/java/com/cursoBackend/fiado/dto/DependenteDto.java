package com.cursoBackend.fiado.dto;

public class DependenteDto {

	private String nome;
	private String documento;
	private String telefone;

	public DependenteDto() {
		super();
	}

	public DependenteDto(String nome, String documento, String telefone, String rua, int numero) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
