package com.cursoBackend.fiado.service;

import java.util.ArrayList;
import java.util.List;

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

	public List<Cliente> getByEstabelecimento(Estabelecimento estabelecimento) {
		List<EstabelecimentoCliente> list = estabelecimentoClienteRepository.findByEstabelecimento(estabelecimento);

		ArrayList<Cliente> clientes = new ArrayList<>();

		list.forEach(ec -> {
			clientes.add(ec.getCliente());
		});

		return clientes;
	}

}
