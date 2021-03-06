package com.rodrigopeleias.minhacolecaovinhos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigopeleias.minhacolecaovinhos.model.Usuario;
import com.rodrigopeleias.minhacolecaovinhos.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public Usuario save(@RequestBody Usuario usuario) {
		return usuarioService.cadastrar(usuario);
	}

	@GetMapping(value = "/{id}")
	public Usuario findOne(@PathVariable Long id) {
		return usuarioService.consultar(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		usuarioService.excluir(id);
	}

}
