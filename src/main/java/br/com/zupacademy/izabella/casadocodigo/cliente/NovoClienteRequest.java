package br.com.zupacademy.izabella.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.zupacademy.izabella.casadocodigo.compartilhado.validacao.CpfouCnpj;
import br.com.zupacademy.izabella.casadocodigo.compartilhado.validacao.ExistsId;
import br.com.zupacademy.izabella.casadocodigo.compartilhado.validacao.UniqueValue;
import br.com.zupacademy.izabella.casadocodigo.paisestado.Estado;
import br.com.zupacademy.izabella.casadocodigo.paisestado.Pais;

public class NovoClienteRequest {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "Email já existe em nossos registros!")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@CpfouCnpj
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento", message = "Documento já existe em nossos registros!")
	@NotBlank
	private String documento;

	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@ExistsId(domainClass = Pais.class, fieldName = "id", message = "O País informado não existe em nossos registros!")
	@NotNull
	private Long paisId;

	private Long estadoId;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public NovoClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long paisId, Long estadoId, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Cliente toModel(EntityManager manager) {

		Pais pais = manager.find(Pais.class, paisId);
		Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
				this.complemento, this.cidade, pais, this.telefone, this.cep);
		if (estadoId != null) {
			cliente.setEstado(manager.find(Estado.class, estadoId));
		}
		return cliente;
	}

}
