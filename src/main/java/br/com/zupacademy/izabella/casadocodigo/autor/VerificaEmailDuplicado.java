package br.com.zupacademy.izabella.casadocodigo.autor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class VerificaEmailDuplicado implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoAutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		NovoAutorRequest request = (NovoAutorRequest) target;
		Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());
		if (possivelAutor.isPresent()) {
			errors.rejectValue("email", null,
					"Já existe um cadastrado com o email (" + request.getEmail() + ") informado.");
		}
	}

}
