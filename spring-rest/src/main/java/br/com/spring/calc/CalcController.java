package br.com.spring.calc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
	
	@GetMapping("/calc/{numberOne}/{numberTwo}")
	public Double calc(
			@PathVariable(value="numberOne") Double numberOne,
			@PathVariable(value="numberTwo") Double numberTwo,
			@RequestParam(value = "operation", defaultValue = "sum") String operation
			) {
		return 1D;
	}
	
}
