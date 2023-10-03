package edu.curso.java.integrador.sistema.reclamos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.curso.java.integrador.sistema.reclamos.bo.Reclamo;
import edu.curso.java.integrador.sistema.reclamos.controller.dto.ReclamoDTO;
import edu.curso.java.integrador.sistema.reclamos.service.ReclamosService;

@RestController
@RequestMapping("/api/reclamos")
public class ReclamosResController {
	@Autowired
	private ReclamosService reclamosService;
	
	@GetMapping(path = "/{id}")
	public ReclamoDTO recuperarReclamoPorId(@PathVariable Long id) {
		Reclamo reclamo = reclamosService.buscarReclamosPorId(id);
		ReclamoDTO reclamoDTO = new ReclamoDTO(reclamo);
		return reclamoDTO;
	}
	
	@GetMapping 
	public List<ReclamoDTO> recuperarTodosLosReclamos() {
		List<ReclamoDTO> reclamosDTO = new ArrayList<ReclamoDTO>();
		
		List<Reclamo> reclamos = reclamosService.recuperarTodosLosReclamos();
		for (Reclamo reclamo : reclamos) {
			reclamosDTO.add(new ReclamoDTO(reclamo));
		}
		
		return reclamosDTO;
	}
	@PostMapping
	public ReclamoDTO altaNuevoReclamo(@RequestBody @Valid ReclamoDTO reclamoDto) {
		
		Reclamo reclamo = new Reclamo();
		reclamo.setTitulo(reclamoDto.getTitulo());
		reclamo.setDescripcion(reclamoDto.getDescripcion());
		
		Long idReclamo = reclamosService.AltaNuevoReclamo(reclamo);
		reclamoDto.setId(idReclamo);
		return reclamoDto;
	}
	
	@DeleteMapping(path = "/{id}") 
	public void borarReclamoPorId(@PathVariable Long id) {
		reclamosService.borrarReclamo(id);	
	}
	
	@PutMapping(path = "/{id}") 
	public ReclamoDTO altaDeNuevoReclamo(@PathVariable Long id, @RequestBody ReclamoDTO reclamoDTO) {
		Reclamo reclamo = reclamosService.buscarReclamosPorId(id);
		reclamo.setTitulo(reclamoDTO.getTitulo());
		reclamo.setDescripcion(reclamoDTO.getDescripcion());
		reclamosService.actualizarReclamo(reclamo);
		return reclamoDTO;
	}
}
