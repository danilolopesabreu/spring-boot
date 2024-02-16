package br.com.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilString {
	
	@Autowired
	private Validador validador;
	
	public Double convertToDouble(String number) {
		if(number == null) 
			return 0D;
		String n = number.replaceAll("," , ".");
		if(this.validador.isNumeric(n))
			return Double.parseDouble(n);
		
		throw new UnsupportedOperationException("Somente valor numerico");
	}
}
