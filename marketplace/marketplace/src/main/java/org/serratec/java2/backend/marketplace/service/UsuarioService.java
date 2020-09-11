package org.serratec.java2.backend.marketplace.service;

import java.util.*;

import org.serratec.java2.backend.marketplace.entidade.Usuario;
import org.serratec.java2.backend.marketplace.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	private Usuario findById(Integer id)throws DataNotFoundException{
		Optional<Usuario>usuario = usuarioRepositorio.findById(id);
		if(usuario.isPresent()){
			return usuario.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Usuario buscaPorId (Integer id) throws DataNotFoundException{
		return findById(id);
	}
	
	public List<Usuario> buscaTodos(){
		return usuarioRepositorio.findAll();
	}
	
	@Transactional
	public Usuario incluiUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}

	@Transactional
	public Usuario atualizaUsuario (Integer id, Usuario usuario ) throws DataNotFoundException {
		Usuario usuarioNovo = findById(id);
		usuario.setNomeCliente(usuarioNovo.getNomeCliente());
		usuario.setCpf(usuarioNovo.getCpf());
		usuario.setNickName(usuarioNovo.getNickName());
		usuario.setEmail(usuarioNovo.getEmail());
		usuario.setDataNascimento(usuarioNovo.getDataNascimento());
		usuario.setCep(usuarioNovo.getCep());
		usuario.setRua(usuarioNovo.getRua());
		usuario.setBairro(usuarioNovo.getBairro());
		usuario.setNumero(usuarioNovo.getNumero());
		usuario.setCidade(usuarioNovo.getCidade());
		usuario.setEstado(usuarioNovo.getEstado());
		usuario.setDdd(usuarioNovo.getDdd());
		usuario.setTelefone(usuarioNovo.getTelefone());
		return usuarioRepositorio.save(usuario);
	}
	
	@Transactional
	public void apagaUsuario(Integer id) throws DataNotFoundException {
		Usuario usuario = findById(id);
		usuarioRepositorio.delete(usuario);
	}

	
}
