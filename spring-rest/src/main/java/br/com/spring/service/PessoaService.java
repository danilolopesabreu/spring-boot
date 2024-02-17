package br.com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.exceptions.NotFoundException;
import br.com.spring.model.Pessoa;
import br.com.spring.repositorio.PessoaRepositorio;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepositorio pessoaRepositorio;

	public List<Pessoa> findAll() {
		return this.pessoaRepositorio.findAll();
	}

	public Pessoa create(Pessoa pessoa) {
		return this.pessoaRepositorio.save(pessoa);
	}

	public Pessoa update(Pessoa pessoa) {
		return this.pessoaRepositorio.save(pessoa);
	}

	public void delete(Integer id) {
		this.pessoaRepositorio.deleteById(id);
	}

	public Pessoa findById(Integer id) {
		return this.pessoaRepositorio.findById(id)
				.orElseThrow(() -> new NotFoundException("Pessoa nao encontrada"));
	}
	
}
