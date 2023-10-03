package edu.curso.java.integrador.sistema.reclamos.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import java.util.Date;

@Entity
public class Reclamo {
	
	@Id
	@GeneratedValue
	Long Id;
	
	private String titulo;
	private String descripcion;
	private Date fechaAlta;
	
	@ManyToOne
	private CategoriaReclamo categoriaReclamo;
	
	public CategoriaReclamo getCategoriaReclamo() {
		return categoriaReclamo;
	}
	public void setCategoriaReclamo(CategoriaReclamo categoriaReclamo) {
		this.categoriaReclamo = categoriaReclamo;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
