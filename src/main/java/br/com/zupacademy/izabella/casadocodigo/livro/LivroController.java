package br.com.zupacademy.izabella.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@PersistenceContext
	private EntityManager manager;

	public LivroController(EntityManager manager) {
		this.manager = manager;
	}

	private LivroRepository livroRepository;

	@Autowired
	public LivroController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@PostMapping
	@Transactional
	public String criaLivro(@RequestBody @Valid NovoLivroRequest request) {
		Livro livro = request.toModel(manager);
		manager.persist(livro);
		return livro.toString();

	}

	@GetMapping
	public Page<LivroResponse> listaLivros(
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		Page<Livro> livros = livroRepository.findAll(paginacao);
		return LivroResponse.converter(livros);
	}

}
