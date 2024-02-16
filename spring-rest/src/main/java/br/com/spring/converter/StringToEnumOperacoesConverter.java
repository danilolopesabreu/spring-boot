package br.com.spring.converter;

import org.springframework.core.convert.converter.Converter;

import br.com.spring.calc.Operacoes;

public class StringToEnumOperacoesConverter implements Converter<String, Operacoes> {
    
	@Override
    public Operacoes convert(String source) {
		return Operacoes.valueOf(source.toUpperCase());
    }
}