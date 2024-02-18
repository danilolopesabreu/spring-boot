package br.com.spring.pessoa;

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

import br.com.spring.model.Pessoa;
import br.com.spring.pessoa.dto.PessoaDto;
import br.com.spring.pessoa.mapper.PessoaMapper;
import br.com.spring.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private PessoaMapper pessoaMapper;
	
	@GetMapping
	public List<PessoaDto> listarPessoas(){
		var pessoas = this.pessoaService.findAll();
		return this.pessoaMapper.pessoasToPessoasDto(pessoas);
	}
	
	@GetMapping("/{id}")
	public Pessoa listarPessoaPorId(@PathVariable("id") Integer id){
		return this.pessoaService.findById(id);
	}
	
	@PostMapping
	public PessoaDto criarPessoa(@RequestBody PessoaDto pessoaDto) {
		var novaPessoa = this.pessoaMapper.pessoaDtoToPessoa(pessoaDto);
		var pessoaCadastrada = this.pessoaService.create(novaPessoa);
		return this.pessoaMapper.pessoaToPessoaDto(pessoaCadastrada);
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
