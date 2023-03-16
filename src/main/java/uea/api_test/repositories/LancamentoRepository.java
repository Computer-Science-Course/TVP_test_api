package uea.api_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.api_test.models.Lancamento;
import uea.api_test.repositories.lancamento.LancamentoRepositoryQuery;

@Repository
public interface LancamentoRepository  extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
