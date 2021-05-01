package br.com.zupacademy.izabella.casadocodigo.paisestado.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.izabella.casadocodigo.paisestado.NovoEstadoRequest;

@Component
public class UnicoEstadoPorPais implements Validator {

	@PersistenceContext
	EntityManager manager;
	

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoEstadoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		NovoEstadoRequest request = (NovoEstadoRequest) target;
		Query query = manager
				.createQuery("select e from Estado e join e.pais p where p.id = :pPaisId and e.nome = :pNome");
		query.setParameter("pPaisId", request.getPaisId());
		query.setParameter("pNome", request.getNome());
		List<?> list = query.getResultList();

		if (!list.isEmpty()) {
			errors.rejectValue("paisId", null,
					"Em nossos registros já existe um Estado com mesmo nome no País selecionado!");
		}

	}

}
