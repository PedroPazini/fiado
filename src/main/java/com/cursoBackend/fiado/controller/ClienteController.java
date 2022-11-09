package com.cursoBackend.fiado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.dto.ClienteDto;
import com.cursoBackend.fiado.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping(path = "api/cliente/create")
	public ResponseEntity<Cliente> create(@RequestBody ClienteDto clienteDto) {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteDto));
	}
	
	@GetMapping(path = "api/cliente")
	public ResponseEntity<List<Cliente>> clientes() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}

}
