package br.com.spring.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.util.UtilString;

@RestController
public class CalcController {
	
	@Autowired
	private UtilString utilString;
	
	@GetMapping("/calc/{numberOne}/{numberTwo}")
	public Double calc(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo,
			@RequestParam("operation") Operacoes operacao
			) throws Exception {

		return operacao.calc(
				  this.utilString.convertToDouble(numberOne)
				, this.utilString.convertToDouble(numberTwo)
				);
	}
	
}
