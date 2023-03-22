package uea.api_test.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.api_test.models.Usuario;
import uea.api_test.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	public Usuario criar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	} 
	
	public Usuario buscarPorCodigo(Long codigo) {
        Usuario usuario = usuarioRepository.findById(codigo).orElseThrow(); 
        return usuario;
    }
	
	public void excluir(Long codigo) {
		usuarioRepository.deleteById(codigo);
	}
	
	public Usuario atualizar(Long codigo, Usuario usuario) {
		Usuario usuarioSalva = usuarioRepository
				.findById(codigo)
				.orElse(usuario);
		BeanUtils.copyProperties(usuario, usuarioSalva, "codigo");;
		
		return usuarioRepository.save(usuarioSalva);
	}
}
