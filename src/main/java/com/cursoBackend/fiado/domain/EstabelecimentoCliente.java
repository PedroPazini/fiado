package com.cursoBackend.fiado.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "estabelecimento_cliente")
public class EstabelecimentoCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@org.hibernate.annotations.Type(type="uuid-char")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "estabelecimento_id")
	private Estabelecimento Estabelecimento;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public EstabelecimentoCliente() {
	}
	
	public EstabelecimentoCliente(UUID id, Estabelecimento estabelecimento,
			Cliente cliente) {
		super();
		this.id = id;
		Estabelecimento = estabelecimento;
		this.cliente = cliente;
	}

	public Estabelecimento getEstabelecimento() {
		return Estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		Estabelecimento = estabelecimento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstabelecimentoCliente other = (EstabelecimentoCliente) obj;
		return Objects.equals(id, other.id);
	}

}
