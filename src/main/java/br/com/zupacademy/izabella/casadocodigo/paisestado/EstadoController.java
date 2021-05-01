package br.com.zupacademy.izabella.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.izabella.casadocodigo.paisestado.validacao.UnicoEstadoPorPais;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@PersistenceContext
	EntityManager manager;

	@Autowired
	UnicoEstadoPorPais unicoEstado;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(unicoEstado);
	}

	@PostMapping
	@Transactional
	public String criaEstado(@RequestBody @Valid NovoEstadoRequest request) {
		Estado estado = request.toModel(manager);
		manager.persist(estado);
		return estado.toString();
	}

}
