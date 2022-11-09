package com.cursoBackend.fiado.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoBackend.fiado.domain.EstabelecimentoCliente;

@Repository("EstabelecimentoClienteRepository")
public interface EstabelecimentoClienteRepository extends JpaRepository<EstabelecimentoCliente, UUID> {

}
