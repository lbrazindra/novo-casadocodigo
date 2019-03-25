package br.com.casadocodigo.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Preco {

	@Column(scale = 2)
	private BigDecimal valor;
	private TipoDeLivro tipoDeLivro;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoDeLivro getTipoDeLivro() {
		return tipoDeLivro;
	}

	public void setTipoDeLivro(TipoDeLivro tipoDeLivro) {
		this.tipoDeLivro = tipoDeLivro;
	}

}
