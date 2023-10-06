package edu.curso.java.integrador.sistema.reclamos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.curso.java.integrador.sistema.reclamos.bo.Reclamo;
import edu.curso.java.integrador.sistema.reclamos.controller.dto.ReclamoDTO;
import edu.curso.java.integrador.sistema.reclamos.controller.forms.ReclamoForm;
import edu.curso.java.integrador.sistema.reclamos.service.ReclamosService;

@Controller
@RequestMapping(value = "/reclamos")
public class ReclamosController {

	@Autowired
	private ReclamosService reclamosService;
	
	@RequestMapping(value = "/listar")
	public String listarReclamos(Model model) {
		List<Reclamo> reclamos = reclamosService.recuperarTodosLosReclamos();
		model.addAttribute("reclamos",reclamos);
		return "/reclamos/listar";
	}
	
	@RequestMapping(value = "/{id}")
	public String verReclamo(Model model, @PathVariable Long id) {
		Reclamo reclamo = reclamosService.buscarReclamosPorId(id);
		model.addAttribute("reclamo", reclamo);
		return "/reclamos/ver";
	}
	
	@RequestMapping(value = "/borrar/{id}")
	public String borrarReclamo(Model model, @PathVariable Long id) {
		reclamosService.borrarReclamo(id);
		return "redirect:/reclamos/listar";
	}
	
	@RequestMapping("/nuevo")
	public String nuevo(Model model) {
		ReclamoForm reclamoForm = new ReclamoForm();
		model.addAttribute("reclamoForm", reclamoForm);
		return "/reclamos/nuevo_reclamo";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardar(Model model, @Valid ReclamoForm ReclamoForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "/reclamos/nuevo_reclamo";
		}
		
		Long idForm = ReclamoForm.getId();
		  if(idForm == null) { 
			  Reclamo reclamo = new Reclamo();
			  reclamo.setTitulo(ReclamoForm.getTitulo());
			  reclamo.setDescripcion(ReclamoForm.getDescripcion());
			  reclamosService.AltaNuevoReclamo(reclamo);
		  } else { 
			  Reclamo reclamo = reclamosService.buscarReclamosPorId(idForm);
			  reclamo.setTitulo(ReclamoForm.getTitulo());
			  reclamo.setDescripcion(ReclamoForm.getDescripcion());
			  reclamosService.actualizarReclamo(reclamo);
		  }
		
		return  "redirect:/reclamos/listar";
	}
	
	@RequestMapping(value = "/{id}/editar")
	public String editarReclamo(Model model, @PathVariable Long id) {
		Reclamo reclamo = reclamosService.buscarReclamosPorId(id);
		ReclamoForm reclamoForm = new ReclamoForm();
		reclamoForm.setId(reclamo.getId());
		reclamoForm.setDescripcion(reclamo.getDescripcion());
		reclamoForm.setTitulo(reclamo.getTitulo());
		model.addAttribute("reclamoForm", reclamoForm);
		return "/reclamos/nuevo_reclamo";
	}
}
