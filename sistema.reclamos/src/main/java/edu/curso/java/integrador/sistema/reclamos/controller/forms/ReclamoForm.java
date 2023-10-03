package edu.curso.java.integrador.sistema.reclamos.controller.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
public class ReclamoForm {

	private Long Id;
	@NotEmpty(message ="Titulo es obligatorio")
	@Size(min = 15, max = 100)
	private String titulo;
	@NotEmpty(message ="Descripcion es obligatorio")
	private String descripcion;
	
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