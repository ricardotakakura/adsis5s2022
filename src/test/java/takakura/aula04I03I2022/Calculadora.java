package takakura.aula04I03I2022;

import java.math.BigDecimal;
import java.math.RoundingMode;

import aula20220304.calculadora.DivisãoPorZeroException;

public class Calculadora {
	public double somar(double v1, double v2) {
		//return 20.25;
		return v1 + v2;
	}
	
	public double divisao(double v1, double v2) {
		if (v2 == 0) {
			throw new DivisaoPorZeroException();
		}
		BigDecimal aux = new BigDecimal(v1/v2);
		aux = aux.setScale(6,RoundingMode.DOWN);
		return aux.doubleValue();
	}

	public double multiplicacao(double v1, double v2) {
		return v1 * v2;
	}

	public double subtracao(double v1, double v2) {
		return v1 - v2;
	}

}
