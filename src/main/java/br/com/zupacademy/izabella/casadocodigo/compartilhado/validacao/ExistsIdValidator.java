package br.com.zupacademy.izabella.casadocodigo.compartilhado.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {

	private String domainAttribute;
	private Class<?> klass;
	
	@PersistenceContext
	EntityManager manager;
	
	@Override
	public void initialize(ExistsId existsId) {
		domainAttribute = existsId.fieldName();
		klass = existsId.domainClass();
	}
	
	@Override
	public boolean isValid (Object value, ConstraintValidatorContext context) {
		
		
		Query query = manager.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE " + domainAttribute + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.isTrue(list.size() <=1, "Voce tem mais de um" +klass+"com o atributo" + domainAttribute + "com o valor =" +value );
		return !list.isEmpty();
	}

	
}
