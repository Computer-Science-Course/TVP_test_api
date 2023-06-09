package uea.api_test.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import uea.api_test.dto.ResumoLancamentoDto;
import uea.api_test.models.Lancamento;
import uea.api_test.repositories.filters.LancamentoFilter;
import uea.api_test.services.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;

	@GetMapping
	public ResponseEntity<Page<ResumoLancamentoDto>> resumir(LancamentoFilter lancamentoFilter, Pageable pageable) {
		Page<ResumoLancamentoDto> resumos = lancamentoService.resumir(lancamentoFilter, pageable);
		return ResponseEntity.ok().body(resumos);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarLancamentoPorCodigo(@PathVariable Long codigo) {
		Lancamento lancamento = lancamentoService.buscarLancamentoPorCodigo(codigo);
		return ResponseEntity.ok().body(lancamento);
	}

	@PostMapping
	public ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento lancamento) {
		Lancamento lancamentoCriado = lancamentoService.criar(lancamento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(lancamentoCriado.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(lancamentoCriado);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Lancamento> atualizar(@PathVariable Long codigo, @Valid @RequestBody Lancamento lancamento) {
		Lancamento lancamentoAtualizado = lancamentoService.atualizar(codigo, lancamento);
		return ResponseEntity.ok(lancamentoAtualizado);
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deletar(@PathVariable Long codigo) {
		lancamentoService.deletar(codigo);
		return ResponseEntity.noContent().build();
	}
}