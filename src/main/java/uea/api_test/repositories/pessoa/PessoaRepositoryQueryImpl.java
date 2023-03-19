package uea.api_test.repositories.pessoa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import uea.api_test.dto.ResumoPessoaDto;
import uea.api_test.models.Pessoa;
import uea.api_test.repositories.filters.PessoaFilter;

public class PessoaRepositoryQueryImpl implements PessoaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<ResumoPessoaDto> filtrar(PessoaFilter lancamentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();

		CriteriaQuery<ResumoPessoaDto> criteria = builder.createQuery(ResumoPessoaDto.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);

		criteria.select(builder.construct(ResumoPessoaDto.class, root.get("codigo"), root.get("nome"),
				root.get("ativo"), root.get("endereco").get("logradouro")));

		Predicate[] predicates = criarRestricoes(lancamentoFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		List<ResumoPessoaDto> returnList = manager.createQuery(criteria).getResultList();

		return returnList;
	}

	private Predicate[] criarRestricoes(PessoaFilter lancamentoFilter, CriteriaBuilder builder, Root<Pessoa> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!ObjectUtils.isEmpty(lancamentoFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get("nome")),
					"%" + lancamentoFilter.getNome().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}
