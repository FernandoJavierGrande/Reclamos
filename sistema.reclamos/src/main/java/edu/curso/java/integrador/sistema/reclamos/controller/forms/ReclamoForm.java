package edu.curso.java.integrador.sistema.reclamos.controller.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
public class ReclamoForm {

	private Long Id;
	@NotEmpty(message ="Titulo es obligatorio")
	private String titulo;
	@NotEmpty(message ="Descripcion es obligatorio")
	private String descripcion;
	@NotEmpty(message="Seleccione una categoria")
	private String categoria;
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}