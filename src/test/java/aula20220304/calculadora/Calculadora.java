package aula20220304.calculadora;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculadora {

	public double somar(double v1, double v2) {
		//return 20.25;
		return v1 + v2;
	}

	public double subtrair(double v1, double v2) {
		return v1 - v2;
	}

	public double dividir(double v1, double v2) {
		if (v2 == 0) {
			throw new DivisãoPorZeroException();
		}
		BigDecimal aux = new BigDecimal(v1 / v2);
		aux = aux.setScale(6, RoundingMode.DOWN);
		return aux.doubleValue();
	}

	public double multiplicar(double v1, double v2) {
		return v1 * v2;
	}

}
