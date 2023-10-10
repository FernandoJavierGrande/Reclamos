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
		return (List<CategoriaReclamo>) categoriaReclamoRepository.findAll();
	}

	@Override
	public CategoriaReclamo buscarCategoriaPorId(Long id) {
		System.out.println("esta en reclamo service id: "+ id);
		Optional<CategoriaReclamo> optCategoria = categoriaReclamoRepository.findById(id);
		
		if(optCategoria.isPresent()) {
			return optCategoria.get();
		}
		else {
			return null;
		}
	}

}
