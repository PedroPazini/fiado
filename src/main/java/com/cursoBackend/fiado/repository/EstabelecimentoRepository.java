package com.cursoBackend.fiado.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoBackend.fiado.domain.Estabelecimento;

@Repository("EstabelecimentoRepository")
public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, UUID> {

}
