package uea.api_test.repositories.lancamento;

import java.util.List;

import uea.api_test.dto.ResumoLancamentoDto;
import uea.api_test.repositories.filters.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public List<ResumoLancamentoDto> filtrar(LancamentoFilter lancamentoFilter);
}
