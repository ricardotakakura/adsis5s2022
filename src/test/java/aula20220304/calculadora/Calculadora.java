package aula20220304.calculadora;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculadora {
	private double memória;
	private double últimoResultado = 0;
	private boolean possuiMemória = false;

	public double somar(double v1, double v2) {
		return reterÚltimoResultado(v1 + v2);
	}

	private double reterÚltimoResultado(double resultado) {
		this.últimoResultado = resultado;
		return this.últimoResultado;
	}

	public double subtrair(double v1, double v2) {
		return reterÚltimoResultado(v1 - v2);
	}

	public double dividir(double v1, double v2) {
		if (v2 == 0) {
			throw new DivisãoPorZeroException();
		}
		BigDecimal aux = new BigDecimal(v1 / v2);
		aux = aux.setScale(6, RoundingMode.DOWN);
		return reterÚltimoResultado(aux.doubleValue());
	}

	public double multiplicar(double v1, double v2) {
		return reterÚltimoResultado(v1 * v2);
	}
	
	public void memorizar() {
		this.memória = this.últimoResultado;
		this.possuiMemória = true;
	}
	
	public double getMemória() {
		if (!possuiMemória) {
			throw new MemóriaInexistenteException();
		}
		return this.memória;
	}

	public void limparMemória() {
		this.possuiMemória = false;
	}

}
