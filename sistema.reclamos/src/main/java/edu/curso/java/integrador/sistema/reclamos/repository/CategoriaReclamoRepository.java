package edu.curso.java.integrador.sistema.reclamos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.curso.java.integrador.sistema.reclamos.bo.CategoriaReclamo;

@Repository
public interface CategoriaReclamoRepository extends CrudRepository<CategoriaReclamo, Long> {
	
	@Query(value="from CategoriaReclamo")
	public List<CategoriaReclamo>recuperarCategorias();
	
}
