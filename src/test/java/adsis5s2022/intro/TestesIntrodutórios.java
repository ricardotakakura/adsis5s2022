package adsis5s2022.intro;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestesIntrodutórios {

	@Test
	public void teste_de_soma() {
		Calculadora calc = new Calculadora();
		double total = calc.somar(10, 10.25);		
		assertEquals(20.25, total, 0);
		
		total = calc.somar(15, 77.10);		
		assertEquals(92.10, total, 0);

	}
	@Test
	public void teste2() {
	}
	@Test
	public void teste3() {
	}
	@Test
	public void teste4() {
	}

}
