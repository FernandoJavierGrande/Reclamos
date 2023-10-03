package edu.curso.java.integrador.sistema.reclamos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.curso.java.integrador.sistema.reclamos.bo.CategoriaReclamo;

@Repository
public interface CategoriaReclamoRepository extends CrudRepository<CategoriaReclamo, Long> {
	
}
