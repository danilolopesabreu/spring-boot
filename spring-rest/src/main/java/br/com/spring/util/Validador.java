package br.com.spring.util;

import org.springframework.stereotype.Service;

@Service
public class Validador {
	public boolean isNumeric(String number) {
		if(number == null)
			return false;
		String n = number.replaceAll("," , ".");
		return n.matches("[+-]?[0-9]*\\.?[0-9]+");
	}
}
