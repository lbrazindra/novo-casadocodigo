package br.com.casadocodigo.loja.modelo;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String titulo;
	@Lob
	@NotBlank
	private String descricao;
	@Min(30)
	private int paginas;
	@ElementCollection
	private List<Preco> precos = new ArrayList<Preco>();
	@DateTimeFormat(iso = ISO.DATE)
	private Calendar dataDoRelaase;
	private File sumario;
	private String summaryPath;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public List<Preco> getPrecos() {
		return precos;
	}

	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}

	public Calendar getDataDoRelaase() {
		return dataDoRelaase;
	}

	public void setDataDoRelaase(Calendar dataDoRelaase) {
		this.dataDoRelaase = dataDoRelaase;
	}

	public File getSumario() {
		return sumario;
	}

	public void setSumario(File sumario) {
		this.sumario = sumario;
	}

	public String getSummaryPath() {
		return summaryPath;
	}

	public void setSummaryPath(String summaryPath) {
		this.summaryPath = summaryPath;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas
				+ ", precos=" + precos + "]";
	}

	public BigDecimal priceFor(TipoDeLivro tipoDeLivro) {
		return precos.stream().filter(preco -> preco.getTipoDeLivro().equals(tipoDeLivro)).findFirst().get().getValor();
	}

}
