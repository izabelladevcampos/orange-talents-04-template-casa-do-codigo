package br.com.zupacademy.izabella.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.izabella.casadocodigo.cliente.validacao.VericaSePaisTemEstadoCadastrado;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private EntityManager manager;

	@Autowired
	private VericaSePaisTemEstadoCadastrado verificaSePaisTemEstadoCadastrado;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(verificaSePaisTemEstadoCadastrado);
	}

	@PostMapping
	@Transactional
	public String criaCliente(@RequestBody @Valid NovoClienteRequest request) {
		Cliente cliente = request.toModel(manager);
		manager.persist(cliente);
		return cliente.toString();
	}
}
