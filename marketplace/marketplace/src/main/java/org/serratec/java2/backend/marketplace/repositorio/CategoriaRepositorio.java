package org.serratec.java2.backend.marketplace.repositorio;

import org.serratec.java2.backend.marketplace.entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository <Categoria, Integer>{

}
