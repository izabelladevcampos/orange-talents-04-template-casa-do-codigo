package br.com.zupacademy.izabella.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.izabella.casadocodigo.compartilhado.validacao.ExistsId;

public class NovoEstadoRequest {

	@NotBlank
	private String nome;

	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id", message = "País não existe em nossos registros!")
	private Long paisId;

	public NovoEstadoRequest(@NotBlank String nome, @NotNull Long paisId) {
		super();
		this.nome = nome;
		this.paisId = paisId;
	}

	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Estado toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, this.paisId);
		return new Estado(nome, pais);
	}

}
