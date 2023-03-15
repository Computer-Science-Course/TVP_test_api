package uea.api_test.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.api_test.models.Lancamento;
import uea.api_test.repositories.LancamentoRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
    public List<Lancamento> listarLancamentos() {
        return lancamentoRepository.findAll();
    }

    public Lancamento buscarLancamentoPorCodigo(Long codigo) {
    	Lancamento lancamento = lancamentoRepository
    			.findById(codigo)
    			.orElseThrow(); 
        return lancamento;
    }

    public Lancamento criar(Lancamento lancamento) {
        return lancamentoRepository.save(lancamento);
    }

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        Lancamento lancamentoSalvo = lancamentoRepository
        		.findById(codigo)
                .orElseThrow();
        BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
        
        return lancamentoRepository.save(lancamentoSalvo);
    }

    public void deletar(Long codigo) {
        lancamentoRepository.deleteById(codigo);
    }

}
