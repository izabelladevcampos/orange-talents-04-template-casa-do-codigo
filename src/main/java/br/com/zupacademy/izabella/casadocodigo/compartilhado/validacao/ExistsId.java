package br.com.zupacademy.izabella.casadocodigo.compartilhado.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = {ExistsIdValidator.class})
public @interface ExistsId {
	
	String message() default "Cadastro não consta em nossos registros.";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default { }; 
	
	String fieldName();
	Class<?> domainClass();
}
