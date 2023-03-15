package uea.api_test.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.api_test.models.Pessoa;
import uea.api_test.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa criar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	} 
	
	public Pessoa buscarPorCodigo(Long codigo) {
        Pessoa pessoa = pessoaRepository.findById(codigo).orElseThrow(); 
        return pessoa;
    }
	
	public void excluir(Long codigo) {
		pessoaRepository.deleteById(codigo);
	}
	
	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaRepository
				.findById(codigo)
				.orElse(pessoa);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");;
		
		return pessoaRepository.save(pessoaSalva);
	}
}
