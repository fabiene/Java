package org.serratec.java2.backend.marketplace.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.java2.backend.marketplace.entidade.Usuario;
import org.serratec.java2.backend.marketplace.service.UsuarioService;
import org.serratec.java2.backend.marketplace.service.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List <Usuario>buscaTodos(){
		return usuarioService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public Usuario buscaPorId(@PathVariable Integer id) throws DataNotFoundException{
		return usuarioService.buscaPorId(id);
	}
	
	@PostMapping
	public Usuario inclui(@Valid @RequestBody Usuario usuario ) {
		return usuarioService.incluiUsuario(usuario);
	}
	
	@PutMapping("/{id}")
	public Usuario atualiza(@PathVariable Integer id, @Valid @RequestBody Usuario usuario ) throws DataNotFoundException {
		return usuarioService.atualizaUsuario(id, usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity apaga(@PathVariable Integer id) throws DataNotFoundException {
		usuarioService.apagaUsuario(id);
		return ResponseEntity.ok().build();
	}

}
