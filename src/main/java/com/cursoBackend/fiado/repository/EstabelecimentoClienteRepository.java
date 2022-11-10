package com.cursoBackend.fiado.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.domain.EstabelecimentoCliente;

@Repository("EstabelecimentoClienteRepository")
public interface EstabelecimentoClienteRepository extends JpaRepository<EstabelecimentoCliente, UUID> {

	List<EstabelecimentoCliente> findByEstabelecimento(Estabelecimento estabelecimento);

	Optional<EstabelecimentoCliente> findByEstabelecimentoAndCliente(Estabelecimento estabelecimentoId,
			Cliente clienteId);

}
