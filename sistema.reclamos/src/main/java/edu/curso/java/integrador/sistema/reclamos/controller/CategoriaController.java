package edu.curso.java.integrador.sistema.reclamos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.curso.java.integrador.sistema.reclamos.bo.CategoriaReclamo;
import edu.curso.java.integrador.sistema.reclamos.controller.forms.CategoriaForm;
import edu.curso.java.integrador.sistema.reclamos.service.CategoriaService;

@Controller
@RequestMapping(value="/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="/nueva")
	public String NuevaCategoria(Model model) {
		CategoriaForm categoriaForm = new CategoriaForm();
		model.addAttribute("categoriaForm",categoriaForm);
		return "categoria/nueva_categoriaForm";
	}
	
	@RequestMapping(value="/guardar" , method=RequestMethod.POST)
	public String guardar(Model model,@Valid CategoriaForm categoriaForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "/reclamos/nueva_categoriaForm";
		}
		String nombreCategoria= categoriaForm.getNombre().trim().toLowerCase()
;		List<CategoriaReclamo> Listcategoria;
		Listcategoria = categoriaService.buscarCategoriaPorNombre(nombreCategoria);
		
		if(Listcategoria == null) {
			CategoriaReclamo categoria = new CategoriaReclamo();
			categoria.setNombre(nombreCategoria);
			categoriaService.nuevaCategoria(categoria);
		}
		
		return  "redirect:/reclamos/nuevo";
	}
	
}
