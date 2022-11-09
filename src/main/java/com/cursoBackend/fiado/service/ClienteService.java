package com.cursoBackend.fiado.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.dto.ClienteDto;
import com.cursoBackend.fiado.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente save(ClienteDto clienteDto) {
		Cliente cliente = new Cliente(clienteDto);
		return clienteRepository.save(cliente);
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> findById(UUID idCliente) {
		return clienteRepository.findById(idCliente);
	}

}
