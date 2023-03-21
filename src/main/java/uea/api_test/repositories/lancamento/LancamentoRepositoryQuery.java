package uea.api_test.repositories.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uea.api_test.dto.ResumoLancamentoDto;
import uea.api_test.repositories.filters.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public Page<ResumoLancamentoDto> filtrar(LancamentoFilter lancamentoFilter, Pageable pagebale);
}
