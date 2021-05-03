
package br.com.zupacademy.izabella.casadocodigo.cliente.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.izabella.casadocodigo.cliente.NovoClienteRequest;

@Component
public class VericaSePaisTemEstadoCadastrado implements Validator {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean supports(Class<?> clazz) {

		return NovoClienteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object request, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		NovoClienteRequest cliente = (NovoClienteRequest) request;
		Query query = manager.createQuery("select e from Estado e where e.pais.id =:pPaisId");

		query.setParameter("pPaisId", cliente.getPaisId());
		List<?> estados = query.getResultList();

		if (!estados.isEmpty() && cliente.getEstadoId() == null) {
			errors.rejectValue("estadoId", null,
					"Esse País possui Estados, escolha um estado para finalização do cadastro!");
		}

	}

}
