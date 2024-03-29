package br.com.spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.model.Pessoa;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer>{

}
