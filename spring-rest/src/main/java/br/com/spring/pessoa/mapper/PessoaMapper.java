package br.com.spring.pessoa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.spring.model.Pessoa;
import br.com.spring.pessoa.dto.PessoaDto;

@Mapper(componentModel = "spring") 
public interface PessoaMapper {
	
	Pessoa INSTANCE = Mappers.getMapper(Pessoa.class);
	
	PessoaDto pessoaToPessoaDto(Pessoa pessoa);
	
	Pessoa pessoaDtoToPessoa(PessoaDto pessoa);
	
	List<PessoaDto> pessoasToPessoasDto(List<Pessoa> pessoas);
}
