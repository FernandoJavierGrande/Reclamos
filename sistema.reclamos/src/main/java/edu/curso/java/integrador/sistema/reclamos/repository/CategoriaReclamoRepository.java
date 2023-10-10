package edu.curso.java.integrador.sistema.reclamos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.curso.java.integrador.sistema.reclamos.bo.CategoriaReclamo;

@Repository
public interface CategoriaReclamoRepository extends CrudRepository<CategoriaReclamo, Long> {
	
	@Query(value="select c from CategoriaReclamo c where c.nombre= :nombreCat")
	public List<CategoriaReclamo> recuperarCategoriaPorNombre(@Param("nombreCat")String nombre);
	
	@Query(value="select c from CategoriaReclamo c order by c.nombre ")
	public List<CategoriaReclamo> recuperarCategoriaAsc();
}
