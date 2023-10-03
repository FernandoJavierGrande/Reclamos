package edu.curso.java.integrador.sistema.reclamos;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.curso.java.integrador.sistema.reclamos.bo.CategoriaReclamo;
import edu.curso.java.integrador.sistema.reclamos.bo.Reclamo;
import edu.curso.java.integrador.sistema.reclamos.repository.CategoriaReclamoRepository;
import edu.curso.java.integrador.sistema.reclamos.service.ReclamosService;


@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private CategoriaReclamoRepository categoriaReclamoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Autowired
	private ReclamosService reclamoService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		CategoriaReclamo categoriaReclamo = new CategoriaReclamo();
		categoriaReclamo.setNombre("nueva");
		
		categoriaReclamoRepository.save(categoriaReclamo);
		System.out.println("id  generado: "+ categoriaReclamo.getId());*/
		
		/*
		System.out.println("iCntidad de categorias: "+ categoriaReclamoRepository.count());
		
		Long idBuscar = 1L;
		CategoriaReclamo categoriaReclamo1 = categoriaReclamoRepository.findById(idBuscar).get();
		
		System.out.println("Nombre: "+ categoriaReclamo1.getNombre());
		
		*/
		/*
		Reclamo reclamo = new Reclamo();
		reclamo.setTitulo("ejemplo 1");
		reclamo.setDescripcion("Ejemplo de reclamo desde consola");
		
		Long idGenerado = reclamoService.AltaNuevoReclamo(reclamo);
		
		System.out.println("Id generado del nuevo reclamo: "+ idGenerado);*/
		
		
	}

}
