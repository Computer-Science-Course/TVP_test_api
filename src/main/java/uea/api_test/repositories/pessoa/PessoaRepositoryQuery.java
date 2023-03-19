package uea.api_test.repositories.pessoa;

import java.util.List;

import uea.api_test.dto.ResumoPessoaDto;
import uea.api_test.repositories.filters.PessoaFilter;

public interface PessoaRepositoryQuery {
	public List<ResumoPessoaDto> filtrar(
			PessoaFilter pessoaFilter
	);
}
