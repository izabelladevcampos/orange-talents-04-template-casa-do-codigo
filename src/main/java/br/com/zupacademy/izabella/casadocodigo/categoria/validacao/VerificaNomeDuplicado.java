package br.com.zupacademy.izabella.casadocodigo.categoria.validacao;
/*
 * package br.com.zupacademy.izabella.casadocodigo.categoria;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Component; import
 * org.springframework.validation.Errors;
 * 
 * @Component public class VerificaNomeDuplicado implements
 * org.springframework.validation.Validator {
 * 
 * @Autowired private CategoriaRepository categoriaRepository;
 * 
 * @Override public boolean supports(Class<?> clazz) { return
 * NovaCategoriaRequest.class.isAssignableFrom(clazz); }
 * 
 * @Override public void validate(Object target, Errors errors) { if
 * (errors.hasErrors()) { return; }
 * 
 * NovaCategoriaRequest request = (NovaCategoriaRequest) target;
 * Optional<Categoria> possivelCategoria =
 * categoriaRepository.findByNome(request.getNome()); if
 * (possivelCategoria.isPresent()) { errors.rejectValue("nome", null,
 * "Já existe uma categoria com o nome " + request.getNome() + "."); } }
 * 
 * }
 */