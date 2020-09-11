package org.serratec.java2.backend.marketplace.repositorio;


import org.serratec.java2.backend.marketplace.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	
}
