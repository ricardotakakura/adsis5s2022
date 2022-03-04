package adsis5s2022.estoque;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class Estoque {
	private BigDecimal saldoFísico = new BigDecimal("0.00");
	private BigDecimal saldoFinanceiro = new BigDecimal("0.00");

	public static Estoque processar(List<MovimentoEstoque> movimento) {
		Estoque novoEstoque = new Estoque();
		
		for (MovimentoEstoque movimentoEstoque : movimento) {
			if (movimentoEstoque.getTipo().equals(TipoMovimentoEstoque.COMPRA)) {
				novoEstoque.saldoFísico = novoEstoque.saldoFísico.add(
						movimentoEstoque.getQuantidade());
				
				novoEstoque.saldoFinanceiro = novoEstoque.saldoFinanceiro.add(
						movimentoEstoque.getQuantidade().multiply(movimentoEstoque.getValorUnitário()).setScale(2,RoundingMode.HALF_DOWN));
			} else if (movimentoEstoque.getTipo().equals(TipoMovimentoEstoque.VENDA)) {
				novoEstoque.saldoFinanceiro = novoEstoque.saldoFinanceiro.subtract(
						movimentoEstoque.getQuantidade().multiply(  novoEstoque.getCustoMédio() ).setScale(2,RoundingMode.HALF_DOWN));
				novoEstoque.saldoFísico = novoEstoque.saldoFísico.subtract(
						movimentoEstoque.getQuantidade());				
			}
		}
		
		return novoEstoque;
	}

	public BigDecimal getSaldoFísico() {
		return saldoFísico;
	}

	public BigDecimal getSaldoFinanceiro() {
		return saldoFinanceiro;
	}

	public BigDecimal getCustoMédio() {
		return saldoFinanceiro.divide(saldoFísico, 2, RoundingMode.HALF_DOWN);
	}

}
