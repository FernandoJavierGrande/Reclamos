package edu.curso.java.integrador.sistema.reclamos.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.curso.java.integrador.sistema.reclamos.bo.Reclamo;
import edu.curso.java.integrador.sistema.reclamos.repository.CategoriaReclamoRepository;
import edu.curso.java.integrador.sistema.reclamos.repository.ReclamoRepository;

@Service
@Transactional
public class ReclamoServiceImpl implements ReclamosService {

	@Autowired
	private CategoriaReclamoRepository categoriaReclamoRepository;
	@Autowired
	private ReclamoRepository reclamoRepository; 
	
	@Override
	public Long AltaNuevoReclamo(Reclamo reclamo) {
		reclamo.setFechaAlta(new Date());
		
		reclamoRepository.save(reclamo);
		return reclamo.getId();
	}
	
	@Override
	public List<Reclamo> recuperarTodosLosReclamos(){
		return reclamoRepository.RecuperarReclamosPorTituloAlfa();
	}
	
	@Override
	public List<Reclamo> recuperarTodosLosReclamos(String titulo){
		return reclamoRepository.RecuperarReclamosPorTitulo(titulo);
		
	}
	@Override
	public Reclamo buscarReclamosPorId(Long id) {
		
		Optional<Reclamo> optionalReclamo = reclamoRepository.findById(id);
		
		if(optionalReclamo.isPresent()) {
			return optionalReclamo.get();
		}
		else {
			return null;
		}
		
	}
	@Override
	public void borrarReclamo(Long id) {
		reclamoRepository.deleteById(id);
	}
	@Override
	public void actualizarReclamo(Reclamo reclamo) {
		reclamoRepository.save(reclamo);
	}
}
