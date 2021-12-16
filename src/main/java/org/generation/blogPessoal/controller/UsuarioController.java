package org.generation.blogPessoal.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.generation.blogPessoal.model.UserLogin;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService; 
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> login (@Valid @RequestBody Optional<UserLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok (resp)).orElse(ResponseEntity.status(401).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> register (@Valid @RequestBody Usuario usuario) {
		return  ResponseEntity.status(201).body(usuarioService.CadastrarUsuario(usuario));
	}
}

