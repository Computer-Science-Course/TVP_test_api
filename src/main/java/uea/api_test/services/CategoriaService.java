package uea.api_test.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.api_test.models.Categoria;
import uea.api_test.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	public Categoria criar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	} 
	
	public Categoria buscarPorCodigo(Long codigo) {
        Categoria categoria = categoriaRepository.findById(codigo).orElseThrow(); 
        return categoria;
    }
	
	public void excluir(Long codigo) {
		categoriaRepository.deleteById(codigo);
	}
	
	public Categoria atualizar(Long codigo, Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository
				.findById(codigo)
				.orElse(categoria);
		BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");;
		
		return categoriaRepository.save(categoriaSalva);
	}
}
