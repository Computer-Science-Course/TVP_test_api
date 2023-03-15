package uea.api_test.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import uea.api_test.models.Categoria;
import uea.api_test.services.CategoriaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaRerource {
	
	@Autowired
	private CategoriaService pessoaService;
	
	@PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria pessoa) {
        Categoria pessoaSalva = pessoaService.criar(pessoa);
        
        URI uri = ServletUriComponentsBuilder
        		.fromCurrentRequest()
        		.path("/{codigo}")
        		.buildAndExpand(pessoaSalva.getCodigo())
        		.toUri();
        
        return ResponseEntity
        		.created(uri)
        		.body(pessoaSalva);
    }
    
    @GetMapping
    public ResponseEntity<List<Categoria>> listar(){
        List<Categoria> pessoas = pessoaService.listar();
        
        return ResponseEntity
        		.ok()
        		.body(pessoas);
    }
    
    @GetMapping(value = "/{codigo}")
    public ResponseEntity<Categoria> buscarPorCodigo(@PathVariable Long codigo){
        Categoria pessoa = pessoaService.buscarPorCodigo(codigo);
        
        return ResponseEntity
        		.ok()
        		.body(pessoa);
    }
    
    @DeleteMapping(value="/{codigo}")
    public ResponseEntity<Void> excluir(@PathVariable Long codigo) {
    	pessoaService.excluir(codigo);
    	
    	return ResponseEntity.noContent()
    			.build();
    }
    
    @PutMapping(value="/{codigo}")
    public ResponseEntity<Categoria> atualizar(
    		@PathVariable Long codigo,
    		@RequestBody Categoria pessoa
    ) {
    	Categoria pessoaSalva = pessoaService.atualizar(codigo, pessoa);
    	
    	return ResponseEntity
        		.ok()
        		.body(pessoaSalva);
    }
}
