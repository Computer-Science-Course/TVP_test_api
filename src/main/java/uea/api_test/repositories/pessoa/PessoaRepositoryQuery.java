package uea.api_test.repositories.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uea.api_test.dto.ResumoPessoaDto;
import uea.api_test.repositories.filters.LancamentoFilter;
import uea.api_test.repositories.filters.PessoaFilter;

public interface PessoaRepositoryQuery {
	public Page<ResumoPessoaDto> filtrar(
			PessoaFilter pessoaFilter, Pageable pageable);


}