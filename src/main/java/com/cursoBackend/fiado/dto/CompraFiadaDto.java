package com.cursoBackend.fiado.dto;

import java.util.UUID;

public class CompraFiadaDto {

	private UUID idCliente;

	private UUID idEstabelecimento;

	private String nome;
	private String observacao;
	private int valor;

	public CompraFiadaDto() {
		super();
	}

	public CompraFiadaDto(UUID idCliente, UUID idEstabelecimento, String nome, String observacao, int valor) {
		super();
		this.idCliente = idCliente;
		this.idEstabelecimento = idEstabelecimento;
		this.nome = nome;
		this.observacao = observacao;
		this.valor = valor;
	}

	public UUID getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(UUID idCliente) {
		this.idCliente = idCliente;
	}

	public UUID getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public void setIdEstabelecimento(UUID idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
