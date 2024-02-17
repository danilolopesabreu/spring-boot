package br.com.spring.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.model.Pessoa;
import br.com.spring.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> listarPessoas(){
		return this.pessoaService.findAll();
	}
	
	@GetMapping("/{id}")
	public Pessoa listarPessoaPorId(@PathVariable("id") Integer id){
		return this.pessoaService.findById(id);
	}
	
	@PostMapping
	public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
		return this.pessoaService.create(pessoa);
	}

	@PutMapping
	public Pessoa alterarPessoa(@RequestBody Pessoa pessoa) {
		return this.pessoaService.update(pessoa);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPessoa(@PathVariable("id") Integer id) {
		this.pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
