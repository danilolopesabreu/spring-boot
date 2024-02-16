package br.com.spring.pessoa;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.model.Pessoa;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@GetMapping
	public List<Pessoa> listarPessoas(){
		return Arrays.asList(new Pessoa(), new Pessoa(), new Pessoa());
	}
	
	@PostMapping
	public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
		return pessoa;
	}

	@PutMapping
	public Pessoa alterarPessoa(@RequestBody Pessoa pessoa) {
		return pessoa;
	}

	@DeleteMapping("/{id}")
	public void deletarPessoa(@PathVariable("id") Integer id) {
	}
	
}
