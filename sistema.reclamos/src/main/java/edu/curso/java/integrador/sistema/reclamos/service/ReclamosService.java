package edu.curso.java.integrador.sistema.reclamos.service;

import java.util.List;

import edu.curso.java.integrador.sistema.reclamos.bo.Reclamo;

public interface ReclamosService {

	Long AltaNuevoReclamo(Reclamo reclamo);

	List<Reclamo> recuperarTodosLosReclamos();

	List<Reclamo> recuperarTodosLosReclamos(String titulo);

	Reclamo buscarReclamosPorId(Long id);

	void borrarReclamo(Long id);

	void actualizarReclamo(Reclamo reclamo);

}