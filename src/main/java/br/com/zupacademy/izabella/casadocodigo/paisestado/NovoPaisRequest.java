package br.com.zupacademy.izabella.casadocodigo.paisestado;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.izabella.casadocodigo.categoria.Categoria;
import br.com.zupacademy.izabella.casadocodigo.compartilhado.validacao.UniqueValue;

public class NovoPaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	@Deprecated
	public NovoPaisRequest() {

	}

	public NovoPaisRequest(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}

}
