package com.cursoBackend.fiado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.CompraFiada;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.dto.CompraFiadaDto;
import com.cursoBackend.fiado.repository.CompraFiadaRepository;
import com.cursoBackend.fiado.repository.EstabelecimentoClienteRepository;

@Service
public class CompraFiadaService {

	@Autowired
	private CompraFiadaRepository compraFiadaRepository;
	
	@Autowired
	private EstabelecimentoClienteRepository estabelecimentoClienteRepository;

	public Object save(CompraFiadaDto compraFiadaDto, Cliente cliente, Estabelecimento estabelecimento) {
		CompraFiada compra = new CompraFiada(compraFiadaDto);

		compra.setCliente(cliente);
		compra.setEstabelecimento(estabelecimento);
		return compraFiadaRepository.save(compra);
	}

	public List<CompraFiada> findAll() {
		return compraFiadaRepository.findAll();
	}

	public Optional<CompraFiada> findOne(UUID id) {
		return compraFiadaRepository.findById(id);
	}

	public CompraFiada update(CompraFiada compra) {
		return compraFiadaRepository.save(compra);
	}

	public void verificarComprasNaoPagas(Estabelecimento estabelecimento) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes = estabelecimentoClienteRepository.findClienteByEstabelecimento(estabelecimento);
		
		
	}
	
}
