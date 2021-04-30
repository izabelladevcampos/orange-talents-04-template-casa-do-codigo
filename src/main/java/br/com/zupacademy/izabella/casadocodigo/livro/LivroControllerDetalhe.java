package br.com.zupacademy.izabella.casadocodigo.livro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroControllerDetalhe {

	private LivroRepository livroRepository;

	@Autowired
	public LivroControllerDetalhe(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> detalhaLivro(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new LivroResponseDetalhe(livro.get()));
		}
		return ResponseEntity.notFound().build();

	}

}
