package edu.curso.java.integrador.sistema.reclamos.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.integrador.sistema.reclamos.bo.CategoriaReclamo;
import edu.curso.java.integrador.sistema.reclamos.repository.CategoriaReclamoRepository;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaReclamoRepository categoriaReclamoRepository;
	
	@Override
	public List<CategoriaReclamo> recuperarCategoriasReclamos() {
		return (List<CategoriaReclamo>) categoriaReclamoRepository.recuperarCategoriaAsc();
	}

	@Override
	public CategoriaReclamo buscarCategoriaPorId(Long id) {
		Optional<CategoriaReclamo> optCategoria = categoriaReclamoRepository.findById(id);
		
		if(optCategoria.isPresent()) {
			return optCategoria.get();
		}
		else {
			return null;
		}
	}
	@Override
	public Long nuevaCategoria(CategoriaReclamo categoriaReclamo) {
		categoriaReclamoRepository.save(categoriaReclamo);
		return categoriaReclamo.getId();
	}
	
	@Override
	public List<CategoriaReclamo> buscarCategoriaPorNombre(String nombre) {
		List<CategoriaReclamo> categorias = categoriaReclamoRepository.recuperarCategoriaPorNombre(nombre);
		
		if(categorias.size() > 0) {
			return categorias;
		}
		else {
			return null;
		}
	}
}
