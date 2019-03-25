package br.com.casadocodigo.loja.modelo;

import java.math.BigDecimal;
import java.util.Arrays;

public class ShoppingItem {

	private Produto produto;
	private TipoDeLivro tipoDeLivro;
	private Integer idDoProduto;

	public static ShoppingItem zeroed() {
		Produto produto = new Produto();
		Preco preco = new Preco();
		TipoDeLivro combo = TipoDeLivro.COMBO;
		preco.setTipoDeLivro(combo);
		preco.setValor(BigDecimal.ZERO);
		produto.setPrecos(Arrays.asList(preco));
		return new ShoppingItem(produto, combo);
	}

	public ShoppingItem(Produto produto, TipoDeLivro tipoDeLivro) {
		this.produto = produto;
		this.tipoDeLivro = tipoDeLivro;
		this.idDoProduto = produto.getId();
	}

	public Produto getProduto() {
		return produto;
	}

	public TipoDeLivro getBookType() {
		return tipoDeLivro;
	}

	public BigDecimal getPrice() {
		/**
		 * Navegue também até a classe Produto, para descobrir como é a implementação do
		 * método priceFor
		 **/
		return produto.priceFor(tipoDeLivro);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipoDeLivro == null) ? 0 : tipoDeLivro.hashCode());
		result = prime * result + ((idDoProduto == null) ? 0 : idDoProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingItem other = (ShoppingItem) obj;
		if (tipoDeLivro != other.tipoDeLivro)
			return false;
		if (idDoProduto == null) {
			if (other.idDoProduto != null)
				return false;
		} else if (!idDoProduto.equals(other.idDoProduto))
			return false;
		return true;
	}

	public BigDecimal getTotal(Integer quantity) {
		return getPrice().multiply(new BigDecimal(quantity));
	}

}
