package com.cursoBackend.fiado.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursoBackend.fiado.domain.Cliente;
import com.cursoBackend.fiado.domain.CompraFiada;
import com.cursoBackend.fiado.domain.Estabelecimento;
import com.cursoBackend.fiado.domain.EstabelecimentoCliente;
import com.cursoBackend.fiado.dto.CompraFiadaDto;
import com.cursoBackend.fiado.service.ClienteService;
import com.cursoBackend.fiado.service.CompraFiadaService;
import com.cursoBackend.fiado.service.EstabelecimentoClienteService;
import com.cursoBackend.fiado.service.EstabelecimentoService;

@RestController
@RequestMapping(path = "api/compras")
public class CompraFiadaController {

	@Autowired
	private CompraFiadaService compraFiadaService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EstabelecimentoService estabelecimentoService;

	@Autowired
	private EstabelecimentoClienteService estabelecimentoClienteService;

	@PostMapping(path = "/create")
	public ResponseEntity<Object> create(@RequestBody CompraFiadaDto compraFiadaDto) {

		Optional<Cliente> optionalCliente = clienteService.findById(compraFiadaDto.getIdCliente());
		Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoService
				.findById(compraFiadaDto.getIdEstabelecimento());

		if ((!optionalCliente.isPresent())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não existe na base de dados");
		}
		if ((!optionalEstabelecimento.isPresent())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estabelecimento não existe na base de dados");
		}

		Optional<EstabelecimentoCliente> optionalEC = estabelecimentoClienteService
				.findByEstabelecimentoAndCliente(optionalEstabelecimento.get(), optionalCliente.get());

		if ((!optionalEC.isPresent())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Cliente não está vinculado a este estabelecimento");
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(compraFiadaService.save(compraFiadaDto, optionalCliente.get(), optionalEstabelecimento.get()));
	}

	@GetMapping(path = "/")
	public ResponseEntity<List<CompraFiada>> findAllCompras() {
		return ResponseEntity.status(HttpStatus.OK).body(compraFiadaService.findAll());
	}

	@PutMapping(path = "/alterarpagamento/{id}")
	public ResponseEntity<Object> alterarPagamento(@PathVariable UUID id) {
		Optional<CompraFiada> optionalCompra = compraFiadaService.findOne(id);

		if (!optionalCompra.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compra não existe;");
		}

		CompraFiada compra = optionalCompra.get();

		compra.setFoiPago(true);

		return ResponseEntity.status(HttpStatus.OK).body(compraFiadaService.update(compra));
	}

	@GetMapping(path = "/verificarpagamento")
	public ResponseEntity<Object> verificarPagamento(@RequestParam UUID estabelecimentoId) {

		Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoService.findById(estabelecimentoId);

		if ((!optionalEstabelecimento.isPresent())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estabelecimento não existe na base de dados");
		}

		compraFiadaService.verificarComprasNaoPagas(optionalEstabelecimento.get());

		return ResponseEntity.status(HttpStatus.OK).body("Verificação feita com sucesso");
	}

}
