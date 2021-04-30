package br.com.zupacademy.izabella.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.izabella.casadocodigo.compartilhado.UniqueValue;

public class NovaCategoriaRequest {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	@Deprecated
	public NovaCategoriaRequest() {

	}

	/*
	 * Para corrigir o problema da serialização por ter apenas um atributo, pois só
	 * estava dando certo criando um método getter
	 */
	@JsonCreator(mode = Mode.PROPERTIES)
	public NovaCategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);

	}

}
