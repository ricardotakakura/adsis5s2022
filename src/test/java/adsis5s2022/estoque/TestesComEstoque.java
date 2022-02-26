package adsis5s2022.estoque;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class TestesComEstoque {

	@Test
	public void testar_custo_médio_somente_entradas() {
		List<MovimentoEstoque> movimento = new ArrayList<>();
		MovimentoEstoque compra01 = new MovimentoEstoque(TipoMovimentoEstoque.COMPRA, criarDataDDMMYYYY("25/01/2022"), new BigDecimal("10.00"), new BigDecimal("3272.50"));
		MovimentoEstoque compra02 = new MovimentoEstoque(TipoMovimentoEstoque.COMPRA, criarDataDDMMYYYY("01/02/2022"), new BigDecimal("3.00"), new BigDecimal("3016.67"));
		
		movimento.add(compra01);
		movimento.add(compra02);
		
		Estoque e = Estoque.processar(movimento);
		
		assertEquals(new BigDecimal("13.00"), e.getSaldoFísico());
		assertEquals(new BigDecimal("41775.01"), e.getSaldoFinanceiro());
		assertEquals(new BigDecimal("3213.46") , e.getCustoMédio());
	}
	@Test
	public void testar_custo_médio_com_entradas_e_saídas() {
		List<MovimentoEstoque> movimento = new ArrayList<>();
		MovimentoEstoque compra01 = new MovimentoEstoque(TipoMovimentoEstoque.COMPRA, criarDataDDMMYYYY("25/01/2022"), new BigDecimal("5.00"), new BigDecimal("4800.00"));
		MovimentoEstoque compra02 = new MovimentoEstoque(TipoMovimentoEstoque.COMPRA, criarDataDDMMYYYY("01/02/2022"), new BigDecimal("7.00"), new BigDecimal("4428.57"));
		MovimentoEstoque venda01 = new MovimentoEstoque(TipoMovimentoEstoque.VENDA, criarDataDDMMYYYY("02/02/2022"), new BigDecimal("3.00"), new BigDecimal("5958.33"));
		
		movimento.add(compra01);
		movimento.add(compra02);
		movimento.add(venda01);
		
		Estoque e = Estoque.processar(movimento);
		
		assertEquals(new BigDecimal("9.00"), e.getSaldoFísico());
		assertEquals(new BigDecimal("41250.00"), e.getSaldoFinanceiro());
		assertEquals(new BigDecimal("4583.33") , e.getCustoMédio());
	}
	
	private Date criarDataDDMMYYYY(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
