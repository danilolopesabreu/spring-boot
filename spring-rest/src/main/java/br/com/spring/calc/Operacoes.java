package br.com.spring.calc;

public enum Operacoes {
	SOMA {

		Double calc(Double x, Double y) {
			return x + y;
		}

	},
	
	SUB{

		Double calc(Double x, Double y) {
			return x - y;
		}

	},
	
	MULT{

		Double calc(Double x, Double y) {
			return x * y;
		}

	},
	
	MEDIA{

		Double calc(Double x, Double y) {
			return (x + y) / 2;
		}

	},
	
	RAIZ2{

		Double calc(Double x, Double y) {
			return Math.sqrt(x+y);
		}

	};

	abstract Double calc(Double x, Double y);
}
