package br.com.zupacademy.izabella.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.izabella.casadocodigo.compartilhado.UniqueValue;

public class NovaCategoriaRequest {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	@Deprecated
	public NovaCategoriaRequest() {

	}

	public NovaCategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);

	}

}
