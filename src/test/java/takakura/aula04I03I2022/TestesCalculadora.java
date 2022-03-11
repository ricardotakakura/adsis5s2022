package takakura.aula04I03I2022;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestesCalculadora {
	
	@Test
	public void teste_de_subtracao() {
		Calculadora calc = new Calculadora();
		double total = calc.subtracao(10, 2);
		assertEquals(8, total, 0);
		
		total = calc.subtracao(40, 19);
		assertEquals(21, total,0);
	}
	
	@Test
	public void teste_de_soma() {
		Calculadora calc = new Calculadora();
		double total = calc.somar(10, 10.25);		
		assertEquals(20.25, total, 0);
		
		total = calc.somar(15, 77.10);		
		assertEquals(92.10, total, 0);

	}
	
	@Test(expected = DivisaoPorZeroException.class)
	public void teste_de_divisao_por_zero() {
		Calculadora calc = new Calculadora();
		double total = calc.divisao(10, 0);
	}
	
	
	@Test
	public void teste_de_divisao() {
		Calculadora calc = new Calculadora();
		double total = calc.divisao(10, 2);
		assertEquals(5, total, 0);
		
		total = calc.divisao(30, 3);
		assertEquals(10, total,0);
		
		total = calc.divisao(16, 3.3);		
		assertEquals(4.848484, total, 0);
		
	}
	
	@Test
	public void teste_de_multiplicacao() {
		Calculadora calc = new Calculadora();
		double total = calc.multiplicacao(10, 2);
		assertEquals(20, total, 0);
		
		total = calc.multiplicacao(40, 15);
		assertEquals(600, total,0);
	}
}
