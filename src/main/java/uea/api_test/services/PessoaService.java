package uea.api_test.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uea.api_test.dto.ResumoPessoaDto;
import uea.api_test.models.Endereco;
import uea.api_test.models.Pessoa;
import uea.api_test.repositories.PessoaRepository;
import uea.api_test.repositories.filters.PessoaFilter;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}
	
	public Page<ResumoPessoaDto> resumir(PessoaFilter lancamentoFilter, Pageable pageable){
		return pessoaRepository.filtrar(lancamentoFilter, pageable);
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

	public Pessoa atualizarEndereco(Long codigo, Endereco endereco) {
		Pessoa pessoaSalva = pessoaRepository
				.findById(codigo)
				.orElseThrow();

		pessoaSalva.getEndereco().setLogradouro(endereco.getLogradouro());
		pessoaSalva.getEndereco().setNumero(endereco.getNumero());
		pessoaSalva.getEndereco().setComplemento(endereco.getComplemento());
		pessoaSalva.getEndereco().setBairro(endereco.getBairro());
		pessoaSalva.getEndereco().setCep(endereco.getCep());
		pessoaSalva.getEndereco().setCidade(endereco.getCidade());
		pessoaSalva.getEndereco().setEstado(endereco.getEstado());

		return pessoaRepository.save(pessoaSalva);
	}
}
