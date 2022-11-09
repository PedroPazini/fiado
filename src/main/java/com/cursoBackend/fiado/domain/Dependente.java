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

import com.cursoBackend.fiado.dto.DependenteDto;

@Entity
@Table(name = "dependentes")
public class Dependente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@org.hibernate.annotations.Type(type="uuid-char")
	private UUID id;

	private String nome;
	private String documento;
	private String telefone;
	private String rua;
	private int numero;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	
	public Dependente(DependenteDto dependente, Cliente cliente) {
		this.nome = dependente.getNome();
		this.documento = dependente.getDocumento();
		this.telefone = dependente.getTelefone();
		this.cliente = cliente;
	}
	
	public Dependente(UUID id, String nome, String documento, String telefone, String rua, int numero, Cliente cliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.telefone = telefone;
		this.rua = rua;
		this.numero = numero;
		this.cliente = cliente;
	}

	public Dependente() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Dependente other = (Dependente) obj;
		return Objects.equals(id, other.id);
	}

}
