package aula20220304.calculadora;

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
	public void teste_de_subtração() {
		Calculadora calc = new Calculadora();
		double total = calc.subtrair(10, 10.25);		
		assertEquals(-0.25, total, 0);
		
		total = calc.subtrair(77, 15);		
		assertEquals(62, total, 0);

	}
	@Test(expected = DivisãoPorZeroException.class)
	public void teste_de_divisão_por_zero() {
		Calculadora calc = new Calculadora();
		double total = calc.dividir(10, 0);		
	}

	
	@Test
	public void teste_de_divisão() {
		Calculadora calc = new Calculadora();
		double total = calc.dividir(10, 2);		
		assertEquals(5, total, 0);
		
		total = calc.dividir(15, 3);		
		assertEquals(5, total, 0);
		
		total = calc.dividir(16, 3.3);		
		assertEquals(4.848484, total, 0);


	}
	@Test
	public void teste_de_multiplicação() {
		Calculadora calc = new Calculadora();
		double total = calc.multiplicar(10, 3.5);		
		assertEquals(35, total, 0);
		
		total = calc.multiplicar(15, 3);		
		assertEquals(45, total, 0);

	}
	@Test
	public void teste_com_memória_zero() {
		Calculadora calc = new Calculadora();
		calc.subtrair(1, 1);
		
		calc.memorizar();
		
		double memória = calc.getMemória();
		
		assertEquals(0, memória, 0);		
	}
	@Test
	public void teste_com_memória() {
		Calculadora calc = new Calculadora();
		calc.multiplicar(10, 3);
		
		calc.memorizar();
		 
		calc.multiplicar(10, 2);
		calc.multiplicar(1.5, -80);
		
		double memória = calc.getMemória();
		
		assertEquals(30, memória, 0);
	}
	@Test(expected = MemóriaInexistenteException.class)
	public void teste_sem_memória() {
		Calculadora calc = new Calculadora();
		
		double memória = calc.getMemória();		
	}
	@Test
	public void teste_limpando_memória() {
		Calculadora calc = new Calculadora();
		calc.multiplicar(10, 3);
		
		calc.memorizar();
		 
		calc.getMemória();
		calc.limparMemória();
		try {
			calc.getMemória();	
			fail("Cadê a exceção ao usar getMemória() quando não tem memória???");
		} catch (Exception e) {
		}
	}
	

}


