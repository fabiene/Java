package org.serratec.java2.backend.marketplace.service;

import java.util.List;
import java.util.Optional;

import org.serratec.java2.backend.marketplace.entidade.Categoria;
import org.serratec.java2.backend.marketplace.entidade.Usuario;
import org.serratec.java2.backend.marketplace.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	private Categoria findById(Integer id)throws DataNotFoundException{
		Optional<Categoria>usuario = categoriaRepositorio.findById(id);
		if(usuario.isPresent()){
			return usuario.get();
		}
		throw new DataNotFoundException(id);
	}
	
	public Categoria buscaPorId (Integer id) throws DataNotFoundException{
		return findById(id);
	}
	
	public List<Categoria> buscaTodos(){
		return categoriaRepositorio.findAll();
	}
	
	@Transactional
	public Categoria incluiCategoria(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}
	
	@Transactional
	public Categoria atualizaCategoria (Integer id, Categoria categoria ) throws DataNotFoundException {
		Categoria categoriaNova = findById(id);
		categoria.setNomeCategoria(categoriaNova.getNomeCategoria());
		categoria.setDescricaoCategoria(categoriaNova.getDescricaoCategoria());
		return categoriaRepositorio.save(categoria);
	}
	
	@Transactional
	public void apagaCategoria(Integer id) throws DataNotFoundException {
		Categoria categoria = findById(id);
		categoriaRepositorio.delete(categoria);
	}
}
