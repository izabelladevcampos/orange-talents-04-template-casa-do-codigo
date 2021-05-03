package br.com.zupacademy.izabella.casadocodigo.autor.validacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.izabella.casadocodigo.autor.Autor;
import br.com.zupacademy.izabella.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.izabella.casadocodigo.autor.NovoAutorRequest;

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
