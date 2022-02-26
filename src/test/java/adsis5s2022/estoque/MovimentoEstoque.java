package adsis5s2022.estoque;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class MovimentoEstoque {
	private TipoMovimentoEstoque tipo;
	private Date data;
	private BigDecimal quantidade;
	private BigDecimal valorUnitário;

	public MovimentoEstoque(TipoMovimentoEstoque tipo, Date data, BigDecimal quantidade, BigDecimal valorUnitário) {
		this.tipo = tipo;
		this.data = data;
		this.quantidade = quantidade;
		this.valorUnitário = valorUnitário;
	}
	
	public TipoMovimentoEstoque getTipo() {
		return tipo;
	}
	public Date getData() {
		return data;
	}
	public BigDecimal getQuantidade() {
		return quantidade.setScale(2,RoundingMode.HALF_DOWN);
	}
	public BigDecimal getValorUnitário() {
		return valorUnitário.setScale(2,RoundingMode.HALF_DOWN);
	}

}
