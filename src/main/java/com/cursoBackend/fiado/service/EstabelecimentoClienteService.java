package com.cursoBackend.fiado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.domain.EstabelecimentoCliente;
import com.cursoBackend.fiado.repository.EstabelecimentoClienteRepository;

@Service
public class EstabelecimentoClienteService {

	@Autowired
	private EstabelecimentoClienteRepository estabelecimentoClienteRepository;

	public EstabelecimentoCliente save(Cliente cliente, Estabelecimento estabelecimento) {

		EstabelecimentoCliente estabelecimentoCliente = new EstabelecimentoCliente();

		estabelecimentoCliente.setCliente(cliente);
		estabelecimentoCliente.setEstabelecimento(estabelecimento);

		return estabelecimentoClienteRepository.save(estabelecimentoCliente);
	}

}
