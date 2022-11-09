package com.cursoBackend.fiado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.Dependente;
import com.cursoBackend.fiado.dto.DependenteDto;
import com.cursoBackend.fiado.repository.DependenteRepository;

@Service
public class DependenteService {

	@Autowired
	private DependenteRepository dependenteRepository;

	public Dependente create(Cliente cliente,DependenteDto dependenteDto) {
		Dependente dependente = new Dependente(dependenteDto, cliente);
		//ou
//		Dependente dependente1 = new Dependente();
//		BeanUtils.copyProperties(dependenteDto, dependente1);
//		dependente1.setCliente(cliente);
		
		return dependenteRepository.save(dependente);
	}

	public List<Dependente> findAll() {
		return dependenteRepository.findAll();
	}

}
