package edu.curso.java.integrador.sistema.reclamos.service;

import java.util.List;

import edu.curso.java.integrador.sistema.reclamos.bo.CategoriaReclamo;

public interface CategoriaService {

	List<CategoriaReclamo> recuperarCategoriasReclamos();
	
	CategoriaReclamo buscarCategoriaPorId(Long id);
	
	List<CategoriaReclamo> buscarCategoriaPorNombre(String nombre);
	
	Long nuevaCategoria(CategoriaReclamo categoriaReclamo);
}
