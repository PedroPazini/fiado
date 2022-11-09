package com.cursoBackend.fiado.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.dto.EstabelecimentoDto;
import com.cursoBackend.fiado.service.ClienteService;
import com.cursoBackend.fiado.service.EstabelecimentoClienteService;
import com.cursoBackend.fiado.service.EstabelecimentoService;

@RestController
@RequestMapping(path = "api/estabelecimentocliente/")
public class EstabelecimentoClienteController {

	@Autowired
	private EstabelecimentoClienteService estabelecimentoClienteService;
	
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping(path = "create")
	public ResponseEntity<Object> create(@RequestParam UUID estabelecimentoId, @RequestParam UUID clienteId) {

		Optional<Cliente> optionalCliente = clienteService.findById(clienteId);
		Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoService.findById(estabelecimentoId);
		
		if((!optionalCliente.isPresent())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não existe na base de dados");
		}
		if((!optionalEstabelecimento.isPresent())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estabelecimento não existe na base de dados");
		}
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoClienteService.save(optionalCliente.get(), optionalEstabelecimento.get()));
	}

}
