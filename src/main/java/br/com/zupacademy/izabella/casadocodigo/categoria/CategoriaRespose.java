package br.com.zupacademy.izabella.casadocodigo.categoria;

public class CategoriaRespose {

	private String nome;

	public CategoriaRespose(Categoria categoria) {
		this.nome = categoria.getNome();
	}

	public String getNome() {
		return nome;
	}

}
