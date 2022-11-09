package com.cursoBackend.fiado.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.dto.DependenteDto;
import com.cursoBackend.fiado.service.ClienteService;
import com.cursoBackend.fiado.service.DependenteService;

@RestController
public class DependenteController {

	@Autowired
	private DependenteService dependenteService;
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping(path = "api/dependente/create/{idCliente}")
	public ResponseEntity<Object> create(@PathVariable UUID idCliente, @RequestBody DependenteDto dependenteDto) {
		
		Optional<Cliente> optionalCliente = clienteService.findById(idCliente);
		
		if(!(optionalCliente.isPresent())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não existe!");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(dependenteService.create(optionalCliente.get(), dependenteDto));
	}

}
