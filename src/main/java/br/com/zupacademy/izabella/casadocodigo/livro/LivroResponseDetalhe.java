package br.com.zupacademy.izabella.casadocodigo.livro;

import java.math.BigDecimal;

import br.com.zupacademy.izabella.casadocodigo.autor.AutorResponse;
import br.com.zupacademy.izabella.casadocodigo.categoria.CategoriaRespose;

public class LivroResponseDetalhe {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numPagina;
	private String isbn;
	private CategoriaRespose categoria;
	private AutorResponse autor;

	public LivroResponseDetalhe(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numPagina = livro.getNumPagina();
		this.isbn = livro.getIsbn();
		this.categoria = new CategoriaRespose(livro.getCategoria());
		this.autor = new AutorResponse(livro.getAutor());
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumPagina() {
		return numPagina;
	}

	public String getIsbn() {
		return isbn;
	}

	public CategoriaRespose getCategoria() {
		return categoria;
	}

	public AutorResponse getAutor() {
		return autor;
	}

}
